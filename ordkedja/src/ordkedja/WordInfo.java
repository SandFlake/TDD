package ordkedja;

import java.util.ArrayList;

public class WordInfo {
	String word;
	ArrayList<Integer> wordLinks;
	
	public WordInfo(String word) {
		this.word = word;
		wordLinks = new ArrayList<Integer>();
	}
	
	public void addWordLink(int index) {
		wordLinks.add(index);
	}
	
	public String getWord() {
		return word;
	}
	
	public String getWordLinks() {
		String words = "";
		for(int i = 0; i<wordLinks.size(); i++) {
			words += wordLinks.get(i) + ", ";
		}
		return words;
	}
	
	public ArrayList<Integer> getWordLinksList(){
		return wordLinks;
	}
}
