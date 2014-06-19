import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TTT {
	static int N;
	public static void main(String args[]) throws IOException
	{
		long time = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("test.in"));
		PrintWriter out = new PrintWriter( new BufferedWriter( new FileWriter("test.out")));
		N = Integer.parseInt(in.readLine());
		for(int i=0; i<N; i++)
		{
			char[][] a = new char[4][4];
			for(int j=0; j<4; j++)
			{
				String s = in.readLine();
				a[j] = s.toCharArray();
			}
			in.readLine();
			out.println("Case #"+(i+1)+": "+parse(a));
		}
		in.close();
		out.close();
		System.out.println("Runtime: "+(System.currentTimeMillis()-time));
		System.exit(0);
	}
	public static boolean contains(String s, String[] a)
	{
		for(int i=0; i<a.length; i++)
			if(s.equals(a[i])) return true;
		return false;	
	}
	public static String parse(char[][] a)
	{
		String[] Xwin = {"XXXT","XXXX","TXXX","XXTX","XTXX"};
		String[] Owin = {"TOOO","OOOT","OOOO","OTOO","OOTO"};
		boolean done = true;
		for(int i=0; i<a.length; i++)
			for(int j=0; j<a[i].length; j++)
				if(a[i][j]=='.') done = false;
		for(int i=0; i<a.length; i++)
		{
			String s="";
			for(int j=0; j<a[i].length; j++)
				s+=a[i][j];
			if(contains(s,Xwin)) return "X won";
			else if(contains(s,Owin)) return "O won"; 
		}
		for(int i=0; i<a.length; i++)
		{
			String s = "";
			for(int j=0; j<a[i].length; j++)
				s+=a[j][i];
			if(contains(s,Xwin)) return "X won";
			else if(contains(s,Owin)) return "O won"; 
		}
		String s = "";
		for(int i=0; i<4; i++)
			s+=a[i][i];
		if(contains(s,Xwin)) return "X won";
		else if(contains(s,Owin)) return "O won";
		s = "";
		for(int i=0; i<4; i++)
			s+=a[3-i][i];
		if(contains(s,Xwin)) return "X won";
		else if(contains(s,Owin)) return "O won";
		if(!done) return "Game has not completed";
		else return "Draw";
	}
}
