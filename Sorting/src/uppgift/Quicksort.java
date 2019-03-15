package uppgift;


public class Quicksort {

	public Quicksort(int[] intList) {
	MyInsertionTest.shuffle(intList, 0, intList.length - 1);
		sort2(intList, 0, intList.length - 1);

	}

//	public void writeInts(int sum) {
//		for (int i = 0; i < intList.length; i++) {
//			System.out.println(intList[i]);
//		}
//	}


	public void sort2(int[] ints, int lo, int hi) {
//		if(!(hi >lo))return;
//
//		int index = partition2(ints, lo, hi);
//
//		sort2(ints, lo, index - 1);
//		sort2(ints, index + 1, hi);
		
		int intsss = 12;
		if(!(hi >lo))return;

		int index = partition2(ints, lo, hi);

		if((index-lo)>intsss) {
			sort2(ints, lo, index - 1);	
		}else {
			MyInsertionTest.insertionSort(ints, lo, index-1);
		}
		if((hi-index)>intsss) {
			sort2(ints, index + 1, hi);
		}else {
			MyInsertionTest.insertionSort(ints, index+1, hi);
		}
	}

	public int partition2(int[] ints, int lo, int hi) {
		int p = ints[lo];
		int i = lo;
		int j = hi + 1;
		while(i < j) {
			i++;
			while(i<hi && ints[i] < p) {
				i++;
			}
			j--;
			while(ints[j] > p) {
				j--;
			}
			if(i>=j) {
				break;
			}
			int save = ints[i];
			ints[i] = ints[j];
			ints[j] = save;
		}

		int save = ints[j];
		ints[j] = ints[lo];
		ints[lo] = save;
		return j;
	}

	public static void main(String[] args) {
		int[] intList = null;
		int dela = 9;
		try {
			intList = MyInsertionTest.readIntfile("files/largeints");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] intList2 = new int [(intList.length)];
		for(int i = 0; i<intList2.length; i++) {
			intList2[i] = intList[i];
		}

        long before = System.nanoTime();
        for(int i=0; i<100; i++) {
        	Quicksort q = new Quicksort(intList);	
        }
        long after = System.nanoTime();
        long average = (after-before)/100;
        System.out.println("Quicksort: " + average);
        
//        long before2 = System.nanoTime();
//		MyInsertionTest.insertionSort(intList2, 0, (intList2.length)/dela);
//        long after2 = System.nanoTime();
//        System.out.println("InsertionTest: " + (after2 - before2));
	}

}
