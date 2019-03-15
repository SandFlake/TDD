package ordkedja2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * En main klass som l�ser in text filer och test data. Inneh�ller metoder som
 * kollar om de sista fyra bokst�ver ord ett finns i ord tv�, g�r en lista med
 * ord som �r kopplade, och kollar om det finns en v�g mellan tv� ord fr�n test
 * data.
 * 
 * @author Sara Dalvig, Anton Tiwe, Antoine Rebelo
 *
 */
public class MainClass {
	private static ArrayList<String> words;
	private static Digraph dig;

	public static ArrayList<String> readData() throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("files/ord5757.txt")));
		ArrayList<String> words = new ArrayList<String>();
		while (true) {

			String word = r.readLine();

			if (word == null) {
				break;
			}
			assert word.length() == 5; // indatakoll, om man k�r med assertions p� words.add(word);
			words.add(word);
		}
		return words;

	}

	/**
	 * G�r igenom en lista med ord. Om det finns mer �n 3 matchande bokst�ver mellan
	 * tv� ord, s� skapas en l�nk mellan dessa tv� ord.
	 * 
	 * @param words
	 * @return wordsInfoList
	 */
	public static ArrayList<WordInfo> checkWordMatch(ArrayList<String> words) {
		ArrayList<WordInfo> wordsInfoList = new ArrayList<>();

		for (int i = 0; i < words.size(); i++) {
			WordInfo wordInfo = new WordInfo(words.get(i));
			for (int j = 0; j < words.size(); j++) {
				if (i != j) {
					int u = checkSingleWord(words.get(i), words.get(j));
					if (u > 3) {
						wordInfo.addWordLink(j);
					}
				}
			}
			wordsInfoList.add(wordInfo);
		}
		return wordsInfoList;
	}

	/**
	 * Kollar om de sista fyra bokst�verna i ord ett finns i ord tv�. Returnerar
	 * antalet bokst�ver som finns med i b�da ord.
	 * 
	 * @param word
	 * @param word2
	 * @return matchChars
	 */
	public static int checkSingleWord(String word, String word2) {
		int matchChars = 0;
		boolean[] marked = new boolean[word2.length()];

		for (int i = 1; i < word.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if ((word.charAt(i) == (word2.charAt(j))) && marked[j] == false) {
					matchChars++;
					marked[j] = true;
					break;
				}
			}
		}
		return matchChars;
	}

	/**
	 * @Author Jesper Larsson f�r att l�sa in test data. Vi har lagt till extra kod
	 *         f�r att leta fr�n en start position till ett m�l i
	 *         BreadthFirstDirectedPaths med distanceTo
	 * @throws IOException
	 */
	public static void testfall() throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("files/testfall5757.txt")));
		while (true) {
			String line = r.readLine();
			if (line == null) {
				break;
			}
			assert line.length() == 11; // indatakoll, om man k�r med assertions p�
			String start = line.substring(0, 5);
			String goal = line.substring(6, 11); // ... s�k v�g fr�n start till goal h�r
			int startPos = -1;
			int goalPos = -1;
			for (int i = 0; i < words.size(); i++) {
				if (start.equals(words.get(i))) {
					startPos = i;
				}
				if (goal.equals(words.get(i))) {
					goalPos = i;
				}
			}
			BreadthFirstDirectedPaths b = new BreadthFirstDirectedPaths(dig, startPos);
			System.out.println(b.distTo(goalPos));
		}
	}

	public static void main(String[] args) throws IOException {

		words = readData();
		ArrayList<WordInfo> list = checkWordMatch(words);
		dig = new Digraph(words.size());
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> edgeList = list.get(i).getWordLinksList();
			for (int j = 0; j < edgeList.size(); j++) {
				dig.addEdge(i, edgeList.get(j));
			}
		}

		testfall();

	}
}
