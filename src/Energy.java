import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Energy {
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
			int E = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[] data = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++)
			{
				data[j] = Integer.parseInt(st.nextToken());
			}
			out.println("Case #"+(i+1)+": "+maximum(E,R,data));
		}
		in.close();
		out.close();
		System.out.println("Runtime: "+(System.currentTimeMillis()-time));
		System.exit(0);
	}
	private static String maximum(int e, int r, int[] data) {
		return null;
	}
}
