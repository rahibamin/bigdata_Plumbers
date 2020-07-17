
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.util.HashMap;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordCount {
  
  /**
   * Counts the words in each line.
   * For each line of input, break the line into words and emit them as
   * (<b>word</b>, <b>1</b>).
   */
  public static class MapClass {
    public java.util.HashMap<String,BigInteger> map(String value) {
      java.util.HashMap<String,BigInteger> output = new java.util.HashMap<String,BigInteger>();
	for ( String word : value.split("[\\W\\d]+")) {
        // TODO make word keys case-insensitive.
	output.putIfAbsent(word,java.math.BigInteger.ZERO);
        output.put(word,java.math.BigInteger.ONE);
      }
	return output;
    }
  }
  
  /**
   * A reducer class that just emits the sum of the input values.
   */
  public static class Reduce {
    
    public HashMap<String, BigInteger> reduce(String key, Iterator<BigInteger> values) {
      BigInteger sum = BigInteger.ZERO;
      while (values.hasNext()) {
        sum = values.next().add(sum);
      }
	
	HashMap<String,BigInteger> output = new HashMap<String,BigInteger>();
	output.put(key,sum);
	return output;
    }
  }
  
  /**
   * The main driver for word count map/reduce program.
   * Invoke this method to submit the map/reduce job.
   * @throws IOException When there is communication problems with the 
   *                     job tracker.
   */
  public int run(String[] args) throws Exception {
	MapClass mapper = new MapClass();
	HashMap<String,BigInteger> parse = mapper.map(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("./input.txt"))));

	for (String key : parse.keySet()) {
		System.out.print(key);
		System.out.print(" ");
	  System.out.println(parse.get(key));
	}

    return 0;
  }
  
  
  public static void main(String[] args) throws Exception {
	WordCount parser = new WordCount();
    int res = parser.run(args);
    System.exit(res);
  }

}
