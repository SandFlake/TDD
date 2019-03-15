package ordkedja;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ExempelKod {

	public ArrayList<String> readData() throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("files/ord23423.txt")));
		ArrayList<String> words = new ArrayList<String>();
		while(true) {

			String word = r.readLine();

			if (word == null) {
				break;
			}
			assert word.length() == 5; // indatakoll, om man kör med assertions på words.add(word); }
			words.add(word);

		}

		System.out.println("" + words.size());
		return words;

	}
	public static ArrayList<String> readData2() throws IOException {

		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("files/ord5757.txt")));
		ArrayList<String> words = new ArrayList<String>();
		while(true) {

			String word = r.readLine();

			if (word == null) {
				break;
			}
			assert word.length() == 5; // indatakoll, om man kör med assertions på words.add(word); }
			words.add(word);

		}

		System.out.println("" + words.size());
		return words;

	}
	// V = words.size();
	
	public static ArrayList<WordInfo> checkWordMatch(ArrayList<String> words) {
		ArrayList<WordInfo> wordsInfoList = new ArrayList<>();
		for(int i = 0; i<words.size(); i++) {
			WordInfo wordInfo = new WordInfo(words.get(i));
			for(int j = 0; j<words.size(); j++) {
				int u = checkSingleWord(words.get(i), words.get(j));
				if(u>3) {
					wordInfo.addWordLink(j);
				}	
			}
			wordsInfoList.add(wordInfo);
		}
		return wordsInfoList;
	}
	
	public static int checkSingleWord(String word, String word2) {
		int matchChars = 0;
		for(int i=1; i<word.length(); i++) {
			for(int j = 0; j<word2.length(); j++) {
				if(word.charAt(i)==(word2.charAt(j))) {
					if(i!=j) {
						matchChars++;
						
						if(i<word.length()-1) {
							i++;
						}else {
							break;
						}
					}

				}
			}
		}
		return matchChars;
	}




	public static void testfall() throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream("files/testfall14.txt")));
		while (true) {
			String line = r.readLine();
			if (line == null) { 
				break;
			}
			assert line.length() == 11; // indatakoll, om man kör med assertions på 
			String start = line.substring(0, 5);
			String goal = line.substring(6, 11); // ... sök väg från start till goal här

		}
	}




	public static void main(String[] args) throws IOException {

		ArrayList<String> words = readData();	
		ArrayList<WordInfo> list = checkWordMatch(words);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getWord() + ", " + list.get(i).getWordLinks());
		}
		System.out.println("lol");
//		Digraph dig = new Digraph(words.size());
//		for(int i = 0; i<list.size(); i++) {
//			ArrayList<Integer> edgeList = list.get(i).getWordLinksList();
//			for(int j = 0; j<edgeList.size(); j++) {
//				dig.addEdge(i, edgeList.get(j));	
//			}
//		}
//		System.out.println(dig.V() + " " + dig.E());
		//testfall();

	}
}

