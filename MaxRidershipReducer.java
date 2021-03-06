import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxRidershipReducer
	extends Reducer<Text, IntWritable, Text, IntWritable> {

		@Override
		public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

			int max = -1;
			for(IntWritable value : values) {
				if(max<value.get()){
					max = value.get();
				}
			} 
			context.write(key, new IntWritable(max));
	}
}
