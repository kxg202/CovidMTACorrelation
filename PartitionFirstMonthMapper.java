import java.io.IOException;

import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class PartitionMapper
	extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		
    	try{
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        Date STARTDATE = sdf.parse("3/1/20");
	        Date ENDDATE = sdf.parse("4/1/20");

	        String[] line = value.toString().split(",");
	        if(line[0].equals("Date")){
	        	return;
	        }
	        Date curDate = sdf.parse(line[0]);

		    if ((curDate.after(STARTDATE) || curDate.equals(STARTDATE)) &&
            		(curDate.before(ENDDATE) || curDate.equals(ENDDATE))){
            	Date date = sdf.parse(line[0]);
            	String res = sdf.format(date);
            	res = res.substring(0,res.length()-4) + "20" + res.substring(res.length()-2, res.length());

		    	context.write(new Text("Date,Subways,Buses"), 
		    		new Text("\n" + res + "," + line[1] + "," + line[3]));
		    }
		}
		catch(ParseException e){
			e.printStackTrace();
		}
    	
	}
}