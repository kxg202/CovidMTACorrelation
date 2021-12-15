import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class ProfileCovidAllMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	 public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
			String line = value.toString();
			String [] contents = line.split(",");
			if(key.get() == 0) {
				
			}
			else
				context.write(new Text("value"), new IntWritable(Integer.parseInt(contents[1])));
		}
	}

