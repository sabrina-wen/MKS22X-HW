import java.util.*;

public class Quiz2Redux {
    
    public static ArrayList<String> combinations (String s) {
	ArrayList<String> words = new ArrayList<String>();
	combinationH(s, words,0, "");
	Collections.sort(words);
	return words;
    }
    
    public static void combinationH(String s, ArrayList<String> words, int start, String partition) {
	if (start == s.length()) {
	    words.add(partition);
	    return;
	}

	combinationH(s, words, start + 1, s.substring(start, start + 1) + partition);
	combinationH(s, words, start + 1, partition);
    }

    public static void main (String[] args) {
	System.out.println(combinations("abc"));
    }
    
}
