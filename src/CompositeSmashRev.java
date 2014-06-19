import java.util.ArrayList;
public class CompositeSmashRev
{
	public String thePossible(int N, int target)
	{
		if(N==target) return "Yes";
		if (!(N % target ==0)) return "No";	
		return "";
	}
	public int numFactor(int N)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=2; i<=Math.sqrt(N); i++)
		{
			if( N % i ==0)
			{ 
				a.add(i);
				a.add(N/i);
			}	
		}
		return a.size();
	}
}