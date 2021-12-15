import java.io.IOException;
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class NormalizeCovidAllMapper extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
    	try{
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        Date STARTDATE = sdf.parse("03/1/2020");

	        String[] line = value.toString().split(",");
	        if(line[0].equals("DATE_OF_INTEREST")){
	        	return;
	        }
	        Date curDate = sdf.parse(line[0]);

		    if (curDate.after(STARTDATE) || curDate.equals(STARTDATE)){
		    	context.write(new Text("DATE_OF_INTEREST,CASE_COUNT"), 
		    		new Text("\n" + line[0] + "," + line[1]));
		    }
		}
		catch(ParseException e){
			e.printStackTrace();
		}
    	
	}
}
