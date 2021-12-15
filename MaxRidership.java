import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxRidership {


	public static void main(String[] args) throws Exception {

		if(args.length != 2){
			System.err.println("Usage: MaxRidership <input path> <output path>");
			System.exit(-1);
		}

		Job job = new Job();
		job.setJarByClass(MaxRidership.class);
		job.setJobName("MaxRidership");
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setMapperClass(MaxRidershipMapper.class);
		job.setReducerClass(MaxRidershipReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		job.setNumReduceTasks(1); // one reduce task

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
