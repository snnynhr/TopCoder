import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Diamond {
	static int N;
	public static void main(String args[]) throws IOException
	{
		long time = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("test.out")));
		N = Integer.parseInt(in.readLine());
		for(int i=0; i<N; i++)
		{
			StringTokenizer st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			out.println("Case #"+(i+1)+": "+parse(M, X,Y));
		}
		in.close();
		out.close();
		System.out.println("Runtime: "+(System.currentTimeMillis()-time));
		System.exit(0);
	}
	public static double parse(int M, int X, int Y)
	{
		return 0;	
	}
}
