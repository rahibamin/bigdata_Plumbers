
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.util.HashSet;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class WordCount {
  
  /**
   * Counts the words in each line.
   * For each line of input, break the line into words and emit them as
   * (<b>word</b>, <b>1</b>).
   */
  public static class MapClass {
    public java.util.HashSet<String,BigInteger> map(String key, java.io.InputStream value) {
      java.util.HashSet<String,BigInteger> output = new java.util.HashSet<String,BigInteger>();
      String line = value.toString();
      StringTokenizer itr = new StringTokenizer(line);
      while (itr.hasMoreTokens()) {
	String word = itr.nextToken();
	output.putIfAbsent(word,java.math.BigInteger.ZERO);
        output.put(word,java.math.BigInteger.ONE);
      }
    }
  }
  
  /**
   * A reducer class that just emits the sum of the input values.
   */
  public static class Reduce {
    
    public HashMap<String, BigInteger> reduce(String key, Iterator<BigInteger> values) {
      BigInteger sum = BigInteger.ZERO;
      while (values.hasNext()) {
        sum += values.next().get();
      }

	
	HashMap<String, BigInteger> output = new HashMap<String, BigInteger>();
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
    private final static java.io.FileInputStream one = new java.io.FileInputStream("./input.txt");

    return 0;
  }
  
  
  public static void main(String[] args) throws Exception {
	WordCount parser = new WordCount();
    int res = parser.run(args);
    System.exit(res);
  }

}
