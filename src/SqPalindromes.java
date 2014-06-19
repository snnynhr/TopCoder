import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class SqPalindromes {
	static int count =0;
	static int T;
	static long[][] g;
	static long[] d = {0,1,2,3,11,22,101,111,121,202,212,1001,1111,2002,10001,10101,10201,11011,11111,11211,20002,20102,100001,101101,110011,111111,200002,1000001,1001001,1002001,1010101,1011101,1012101,1100011,1101011,1102011,1110111,1111111,2000002,2001002};
	public static void main(String args[]) throws IOException
	{
		long time = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("test.in"));
		long aaa = (long)3.924;
		System.out.println(aaa);
		T = Integer.parseInt(in.readLine());
		g = new long[T][2];
		for(int i=0; i<T; i++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long x = (long)Math.sqrt(a);
			if(x != Math.sqrt(a)) x+=1;
			long y = (long)Math.sqrt(b);
			g[i][0] = x;
			g[i][1] = y;
		}
		in.close();
		int[] sol = new int[T];
		for(int i=0; i<T; i++)
		{
			int count = 0;
			for(int j=0; j<d.length; j++)
			{
				if(d[j]>=g[i][0])
				{
					if(d[j]<=g[i][1]) count++;
					else break;
				}
			}
			sol[i] = count;
		}
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("test.out")));
		for(int i=0; i<T; i++)
		{
			out.println("Case #"+(i+1)+": "+sol[i]);
			System.out.println("Case #"+(i+1)+": "+sol[i]+"("+g[i][0]+","+g[i][1]+")");
		}
		out.close();
		System.out.println("Runtime: "+(System.currentTimeMillis()-time));
		System.exit(0);
	}
	public void generate(long lower, long upper, StringBuffer s)
	{
		if(Integer.parseInt(s.toString())>upper) return;
		if(Integer.parseInt(s.toString())>=lower) count++;
		if(s.length()%2==0)
		{
			
		}
		else
		{
			
		}
	}
}
