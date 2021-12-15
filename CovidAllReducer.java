import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CovidAllReducer extends Reducer<Text, Text, Text, Text> {
         @Override
         public void reduce(Text key, Iterable<Text> lines, Context context) throws IOException, InterruptedException {
                String result = "";
                for(Text line : lines){
                String [] fields = line.toString().split(",");
                result += fields[0] + "," + fields[1];
                }
                context.write(new Text(key), new Text(result));
        }

}                                                                                                                                                                                 
