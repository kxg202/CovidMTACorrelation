import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat; 
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ProfileCovid1stMonthOnly {

    public static void main(String[] args) throws Exception { 

        if (args.length != 2) {
            System.err.println("Usage: ProfileCovid1stMonthOnly <input path> <output path>");
            System.exit(-1);
        }

        Job job = new Job(); 
        job.setJarByClass(ProfileCovid1stMonthOnly.class); 
        job.setJobName("Profile Covid 1st Month Only");
        FileInputFormat.addInputPath(job, new Path(args[0])); 
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(ProfileCovid1stMonthOnlyMapper.class);
        job.setReducerClass(ProfileCovid1stMonthOnlyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(1); // 1 Reduce task
        
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
