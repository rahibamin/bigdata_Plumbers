
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
  public static class Reduce extends MapReduceBase
    implements Reducer<Text, IntWritable, Text, IntWritable> {
    
    public void reduce(Text key, Iterator<IntWritable> values,
                       OutputCollector<Text, IntWritable> output, 
                       Reporter reporter) throws IOException {
      int sum = 0;
      while (values.hasNext()) {
        sum += values.next().get();
      }
      output.collect(key, new IntWritable(sum));
    }
  }
  
  static int printUsage() {
    System.out.println("wordcount [-m <maps>] [-r <reduces>] <input> <output>");
    ToolRunner.printGenericCommandUsage(System.out);
    return -1;
  }
  
  /**
   * The main driver for word count map/reduce program.
   * Invoke this method to submit the map/reduce job.
   * @throws IOException When there is communication problems with the 
   *                     job tracker.
   */
  public int run(String[] args) throws Exception {
    JobConf conf = new JobConf(getConf(), WordCount.class);
    conf.setJobName("wordcount");
 
    // the keys are words (strings)
    conf.setOutputKeyClass(Text.class);
    // the values are counts (ints)
    conf.setOutputValueClass(IntWritable.class);
    
    conf.setMapperClass(MapClass.class);        
    conf.setCombinerClass(Reduce.class);
    conf.setReducerClass(Reduce.class);
    
    List<String> other_args = new ArrayList<String>();
    for(int i=0; i < args.length; ++i) {
      try {
        if ("-m".equals(args[i])) {
          conf.setNumMapTasks(Integer.parseInt(args[++i]));
        } else if ("-r".equals(args[i])) {
          conf.setNumReduceTasks(Integer.parseInt(args[++i]));
        } else {
          other_args.add(args[i]);
        }
      } catch (NumberFormatException except) {
        System.out.println("ERROR: Integer expected instead of " + args[i]);
        return printUsage();
      } catch (ArrayIndexOutOfBoundsException except) {
        System.out.println("ERROR: Required parameter missing from " +
                           args[i-1]);
        return printUsage();
      }
    }
    // Make sure there are exactly 2 parameters left.
    if (other_args.size() != 2) {
      System.out.println("ERROR: Wrong number of parameters: " +
                         other_args.size() + " instead of 2.");
      return printUsage();
    }
    FileInputFormat.setInputPaths(conf, other_args.get(0));
    FileOutputFormat.setOutputPath(conf, new Path(other_args.get(1)));
        
    JobClient.runJob(conf);
    return 0;
  }
  
  
  public static void main(String[] args) throws Exception {
    private final static java.io.FileInputStream one = new java.io.FileInputStream("./input.txt");
    int res = ToolRunner.run(new Configuration(), new WordCount(), args);
    System.exit(res);
  }

}
