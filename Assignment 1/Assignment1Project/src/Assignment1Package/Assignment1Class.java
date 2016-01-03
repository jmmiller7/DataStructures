package Assignment1Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignment1Class {

	public static void main(String[] args) {

		String word = ""; // used in method1 to get a word to scramble
		String text = ""; // used in method2 to get a list of words

		int numChars = 0;

		System.out.println("* * * Welcome to Assignment 1! * * *\n");

		// -------------------------------------------------------------

		System.out.println("- - - Method 1: scrambleWord - - -");

		word = "TAN";

		System.out.println("\nBefore Scrambling: \"" + word + "\"");

		word = scrambleWord(word);

		System.out.println("After Scrambling:  \"" + word + "\"");

		// -------------------------------------------------------------

		System.out.println("\n- - - Method 2: scrambleOrRemove - - -");

		// take String text and split into wordList
		text = "TAN, ABRACADABRA, WHOA, APPLE, EGGS";
		List<String> wordList = stringToList(text);

		System.out.println("\nList before scrambleOrRemove: " + wordList);

		wordList = scrambleOrRemove(wordList);

		System.out.println("List after scrambleOrRemove:  " + wordList);

		// -------------------------------------------------------------

		System.out.println("\n- - - Method 3: getNumCharacters - - -");

		text = "TAN, ABRACADABRA, WHOA, APPLE, EGGS";
		wordList = stringToList(text);
		
		numChars = getNumCharacters(wordList);

		System.out.println("There are " + numChars + " characters  in the list " + wordList);

		// -------------------------------------------------------------
		System.out.println("\n- - - Method 4: scrambleAndDisplay - - -");

		text = "JAKE,TOM,MATTHEW,AUSTIN,MASON";
		scrambleAndDisplay(text);

		// -------------------------------------------------------------

		System.out.println("\n* * * Thank you for using Assignment 1! * * *");
	}

	public static String scrambleWord(String word) {
		// variables
		String helper = "";

		// check if word has contents
		if (helper.equals(word))
			return helper;

		// length of word, used as parameter in following for loop
		int length = word.length();

		// scramble word and put in helper string
		for (int position = 0; position < length; position++) {
			char origLtr = ' ';
			char swapLtr = ' ';

			origLtr = word.charAt(position);

			if (position < length - 1) {
				if (origLtr == 'A') {
					swapLtr = word.charAt(position + 1);
					if (swapLtr == 'A')
						helper += origLtr;
					else {
						helper += swapLtr;
						helper += origLtr;
						if (position <= length - 2)
							position++;
					}
				} else
					helper += origLtr;
			} else
				helper += origLtr;
		} // end for

		return helper;
	}

	public static List<String> scrambleOrRemove(List<String> wordList) {

		String convWord = "";
		List<String> helper = new ArrayList<String>();
		List<String> sortList = new ArrayList<String>();

		// make sure wordList is all caps
		for (int i = 0; i < wordList.size(); i++) {
			String word = wordList.get(i);
			word = word.toUpperCase();
			wordList.set(i, word);
		}

		// process wordList
		for (int currWord = 0; currWord < wordList.size(); currWord++) {
			convWord = scrambleWord(wordList.get(currWord));
			helper.add(convWord);
		}

		// remove unchanged words
		for (int currWord = 0; currWord < wordList.size(); currWord++) {
			if (!wordList.get(currWord).equals(helper.get(currWord)))
				sortList.add(helper.get(currWord));
		}
		
		return sortList;
	}

	public static int getNumCharacters(List<String> wordList) {
		int numChars = 0;

		for (int currWord = 0; currWord < wordList.size(); currWord++) {
			numChars += (wordList.get(currWord)).length();
		}

		return numChars;
	}

	public static void scrambleAndDisplay(String text) {
		int numChars = 0;
		List<String> wordList = stringToList(text);

		wordList = scrambleOrRemove(wordList);
		
		numChars = getNumCharacters(wordList);

		System.out.println("The sorted list has " + numChars + " characters");
		System.out.println(wordList);
	}
	
	public static List<String> stringToList(String text){
		String[] wordArray = text.split("[ .,?!]+");
		List<String> wordList = Arrays.asList(wordArray);
		return wordList;
	}

}