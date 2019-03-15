package uppgift;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Mergesort {

	static int[] readIntfile(String filename) throws Exception {
		// Read file into a byte array, and then combine every group of four bytes to an
		// int. (Not
		// the standard way, but it works!)
		byte[] bytes = Files.readAllBytes(Paths.get(filename));
		int[] ints = new int[bytes.length / 4];
		for (int i = 0; i < ints.length; i++) {
			for (int j = 0; j < 4; j++) {
				ints[i] += (bytes[i * 4 + j] & 255) << (3 - j) * 8;
			}
		}
		return ints;
	}

	public static void mergesort(int[] array) {
		mergesort(array, new int[array.length], 0, array.length - 1);
	}

	public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if (leftStart >= rightEnd) {
			return;
		}
		
		if((rightEnd-leftStart)<68) {
			insertionSort(array, leftStart, rightEnd);
		}else {		
		int middle = (leftStart + rightEnd) / 2;
		mergesort(array, temp, leftStart, middle);
		mergesort(array, temp, middle + 1, rightEnd);
		mergeHalves(array, temp, leftStart, rightEnd);
		}
	}

	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;

		while (left <= leftEnd && right <= rightEnd) {
			if (array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
			} else {
				temp[index] = array[right];
				right++;
			}
			index++;
		}

		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
	}
	
	static void insertionSort(int[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && a[j] < a[j - 1]; j--) {
				int x = a[j];
				a[j] = a[j - 1];
				a[j - 1] = x;
			}
		}
		}

	public static void main(String[] args) throws Exception {
		int[] data = readIntfile("files/largeints");
		int inde = data.length-1;

		int[] data2 = new int [inde];
		for(int i = 0; i<data2.length; i++) {
			data2[i] = data[i];
		}
		
//		long before = System.nanoTime();
//		for(int i = 0; i<100; i++) {
//			insertionSort(data, 0, inde);	
//		}
//		long after = System.nanoTime();
//		long average = (after-before)/100;
//		System.out.println("Insertion: " + (average));
		
		long before2 = System.nanoTime();
		for(int i = 0; i<100; i++) {
		mergesort(data2);
		}
		long after2 = System.nanoTime();
		long average = (after2-before2)/100;
		System.out.println("Merge: " + average);
	}
}
