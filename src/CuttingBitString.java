import java.util.ArrayList;
public class CuttingBitString
{
	static ArrayList<String> five = new ArrayList<String>();
	static int minCut = Integer.MAX_VALUE;
	public static int getmin(String S)
	{
		long res=1;
		for(int i=0; i<22; i++)
			five.add(Long.toBinaryString(res*=5));
		solve(S,0,0);
		if(minCut==Integer.MAX_VALUE) return -1;
		return minCut;
	}
	public static void solve(String s, int depth, int index)
	{
		if(index == s.length()) 
			minCut = Math.min(minCut,depth);
		else
		{
			for(int i=s.length()-1; i>=index; i--)
				if(five.contains(s.substring(index,i+1)))
					solve(s,depth+1,i+1);
		}
	}
}