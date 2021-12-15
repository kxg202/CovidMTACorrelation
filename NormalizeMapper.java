import java.io.IOException;

//import org.apache.hadoop.io.IntWritable;
//import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;



public class NormalizeMapper
	extends Mapper<LongWritable, Text, Text, Text> {
    
    private static final double MAXVALSUB = 5515945;
    private static final double MAXVALBUS = 2244500;


    @Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		    
	String[] line = value.toString().split(",");
	try{
		double res1 = Integer.parseInt(line[1])/MAXVALSUB;
		double res2 = Integer.parseInt(line[2])/MAXVALBUS;
		
		String res = "," + res1 + "," + res2;
		context.write(new Text(line[0]), new Text(res));
	}
	catch(Exception e){
		
	}
}
}
