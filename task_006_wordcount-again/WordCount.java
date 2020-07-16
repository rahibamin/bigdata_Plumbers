
import java.util.HashSet;
import java.lang.System;

import java.io.FileInputStream;
import java.nio.Buffer;

public class WordCount {
    public java.util.HashSet<String,BigInteger> words = new java.util.HashSet<String,BigInteger>();

    /**
     * Increment the count of the word.
     */
    public BigInteger account(String word) {
	parsing.words.putIfAbsent(word,BigInteger.ZERO);
	return parsing.words.put(word,BigInteger.ONE+parsing.words.get(word));
    }

    public void book( keep) {
	
    }

    /**
     * Read ./input.txt and count the words.
     */
    public static void main(String[] args) {
	WordCount parsing = new WordCount(new java.io.File("./input.txt"));

	java.io.FileInputStream text = new java.io.FileInputStream("./input.txt");
	
	parsing.book(text);

	/* TODO print results */
    }
}
