
import java.io.*;
import java.util.StringTokenizer;

public class PrimeSum {
	public static double nsum(double pi) throws IOException
	{
		double sum = 0.0;
		for(int z=1; z<=21; z++)
		{
			long start = System.currentTimeMillis();
			String bufferstring = "C:\\Users\\Ankur\\Downloads\\primes1\\primes"+z+".txt";
			BufferedReader f = new BufferedReader(new FileReader(bufferstring));
			f.readLine();
			f.readLine();
			StringTokenizer s;
			for(int i=0; i<125000; i++)
			{
				s = new StringTokenizer(f.readLine());
				while(s.hasMoreTokens())
				{
					sum+=Math.pow(Integer.parseInt(s.nextToken()),-pi);
				}
			}
			System.out.println((System.currentTimeMillis()-start)+"\t\t"+sumToString(sum));
			f.close();
			
		}
		return sum;
	}
	public static void main(String args[]) throws IOException
	{
		long begin = System.currentTimeMillis();
		double sum=nsum(Math.PI/Math.E);
		sumToString(sum);
		System.out.println("TOTAL TIME "+(System.currentTimeMillis()-begin));
		System.exit(0);                               
	}
	public static String sumToString(double sum)
	{
		String summation=""+sum;
		for(int i=0; i<summation.length()-2; i++)
		{
			sum=(10*sum)-(int)(10*sum);
		}
		String summation1 = (sum+"").substring(2);
		for(int i=0; i<summation.length()-2; i++)
		{
			sum=(10*sum)-(int)(10*sum);
		}
		String summation2 = (sum+"").substring(2);
		return summation +summation1+summation2;
	}
}
