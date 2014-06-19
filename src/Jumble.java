import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Jumble {
	static int N;
	static String[] dict= new String[521196];
	static int min = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException
	{
		int max=0;
		long time = System.currentTimeMillis();
		BufferedReader inn = new BufferedReader(new FileReader("dict.txt"));
		for(int i=0; i<521196; i++)
		{
			dict[i] = new String(inn.readLine());
			max = Math.max(dict[i].length(), max);
		}
		System.out.println(max);
		inn.close();
		BufferedReader in = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("test.out")));
		N = Integer.parseInt(in.readLine());
		for(int i=0; i<N; i++)
		{
			min = Integer.MAX_VALUE;
			String t = in.readLine();
			dfs(0,t,"");
			System.out.println("Case #"+(i+1)+": "+min);
		}
		in.close();
		out.close();
		System.out.println("Runtime: "+(System.currentTimeMillis()-time));
		System.exit(0);
	}
	public static void dfs(int xc, String string, String ress)
	{
		System.out.println(xc +": "+ string + "  comp:"+ress);
		if(string.length()==0 || string.length()<=8)
		{
			min = Math.min(min, xc);
			return;
		}
		else
		{
			for(String i: dict)
			{
				int d = i.length();
				if(string.length()>=d)
				{
					int res = comp(i,string.substring(0,d));
					if(res!=-1)
					{
						if(d==string.length())
						{
							min = Math.min(min, xc);

						}
						else
						{
							dfs(xc+res,string.substring(d),ress+i);
						}
					}
				}
			}
		}
	}
	public static int comp(String i2, String bb)
	{
		int c=0;
		int[] aa = {0,0};
		for(int i=0; i<i2.length(); i++)
		{
			if(i2.charAt(i)!=bb.charAt(i)) 
			{
				c++;
				if(c>2) return -1;
				aa[c-1] = i;
			}
		}
		if(c==2) 
		{
			if(aa[1]-aa[0]<5) return -1;
		}
		return c;
	}
}
