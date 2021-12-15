import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class MaxRidershipMapper
	extends Mapper<LongWritable, Text, Text, IntWritable> {
    
    @Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		    
	String[] line = value.toString().split(",");
	try{
		context.write(new Text("Maximum Number of Subway Riders in a Given Day is:"), 
			new IntWritable(Integer.parseInt(line[1])));
		context.write(new Text("Maximum Number of Bus Riders in a Given Day is:"), 
			new IntWritable(Integer.parseInt(line[2])));
		context.write(new Text("Maximum Number of Metro North Riders in a Given Day is:"), 
			new IntWritable(Integer.parseInt(line[3])));
	}

	catch(Exception e){
		
	}
}
}
