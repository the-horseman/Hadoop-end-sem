import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> 
{

	
	public void map(LongWritable key, Text value, Context context)throws java.io.IOException, InterruptedException
	{
		String data[]=value.toString().split(",");    //data =  [85 131 993 392 689....]
		
	
		for(String num:data)
		{
			int number=Integer.parseInt(num);
//			if((number%2)==1)
//			{
//				context.write(new Text("ODD"), new IntWritable(number));   //  ODD 85  131  993 
//			}
//			else
//			{
//				context.write(new Text("EVEN"), new IntWritable(number));   //  EVEN  392
//			}
			int c=0;
			for (int i=2; i<number/2 ;++i)
			{
				if(number%i==0)
				{
					c=1;
				}
			}
			if(c==0)
			{
				context.write(new Text("PRIME"), new IntWritable(number));
			}
					
		}
	}
}

