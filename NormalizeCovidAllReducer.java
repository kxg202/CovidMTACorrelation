import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class NormalizeCovidAllReducer extends Reducer<Text, Text, Text, Text> {
         @Override
         public void reduce(Text key, Iterable<Text> lines, Context context) throws IOException, InterruptedException {
                double normalizedValue = 0;
                String result = "";
                for(Text line : lines){
                String [] fields = line.toString().split(",");
                normalizedValue = Double.parseDouble(fields[1])/6589;
                String normalizedVal = Double.toString(normalizedValue);
                result += fields[0] + "," + normalizedVal;
                }
                context.write(new Text(key), new Text(result));
        }

}                                                                                                                                                                                 
