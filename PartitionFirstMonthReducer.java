import java.io.IOException;

import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PartitionReducer
      extends Reducer<Text, Text, Text, Text> {

      @Override
      public void reduce(Text key, Iterable<Text> values, Context context) 
            throws IOException, InterruptedException {

            String out = "";
            for (Text value : values) {
                  out += value.toString();
            }
            context.write(key, new Text(out)); 
      }
}