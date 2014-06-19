import java.util.ArrayList;
public class CasketofStarEasy
{
	static int n;
	ArrayList<Integer> sums = new ArrayList<Integer>();
	public void generateP(String s, int n)
	{
		// decreasing set permutations i.e n=4=>{1..4},{1..3},{1..2},{1}
		if(s.length()==n) sums.add(Integer.parseInt(s));
		else
			for(int i=1; i<=n-s.length(); i++)
				generateP(i+s,n);
	}
	public int maxEnergy(int[] weight)
	{
		n=weight.length-2;	
		generateP("",n);
		int max = 0;
		for(int i=0; i<sums.size(); i++)
			max=Math.max(max, read(sums.get(i),weight));
		return max;
	}
	public int read(int n, int[] weight)
	{
		int sum=0;
		ArrayList<Integer> m = new ArrayList<Integer>();
		for(int i=0; i<weight.length; i++)
			m.add(weight[i]);
		while(n!=0)
		{
			int a=n%10;
			sum+=m.get(a-1)*m.get(a+1);
			m.remove(a);
			n/=10;
		}
		return sum;
	}
}