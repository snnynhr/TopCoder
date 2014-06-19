import java.util.*;
public class CompositeSmash
{
	public String thePossible(int N, int target)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		if(N==target) return "Yes";
		if (!(N % target ==0)) return "No";
				
		int exp=(int) ((Math.log10(N))/(Math.log10(target)));
		int res = (int)(Math.pow(target, exp));
		if((numFactor(target)==0) && (res==N)) return "Yes";
				
		for(int i=2; i<=Math.sqrt(N); i++)
		{
			if( N % i ==0)
			{ 
				a.add(i);
				b.add(N/i);
			}	
		}
		for( int i=0; i<a.size(); i++)
		{
			if( (a.get(i)%target!=0) && (b.get(i)%target!=0) || numFactor(a.get(i))>2 || numFactor(b.get(i))>2) return "No";
		}
		return "Yes";
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