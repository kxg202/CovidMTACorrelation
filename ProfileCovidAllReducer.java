import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class ProfileCovidAllReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	 public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
	 int maxValue = Integer.MIN_VALUE;
	 for (IntWritable value : values) {
	 	if(value.get() > maxValue)
	 		maxValue = value.get();
	 }
	 context.write(new Text("Max Value: "), new IntWritable(maxValue));
	}
}
