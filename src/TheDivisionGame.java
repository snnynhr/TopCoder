
public class TheDivisionGame
{
	public static long countWinningIntervals(int L, int R)
	{
		
		int[] x = new int[1000000];
		for(int i=2; i<1000000; i++)
		{
			x[i] = getNumF(i);
		}
		return x[100000-1];
	}
	public static void main(String args[])
	{
		System.out.println(countWinningIntervals(9, 10));
	}
	public static int getNumF(int x)
	{
		int count=0;
		while(x!=1)
		{
			boolean ok=false;
			for(int i=2; i<=Math.sqrt(x); i++)
			{
				if(x%i==0) 
				{
					count++;
					x/=i;
					ok=true;
					break;

				}
			}
			if(!ok){
				count++;
				break;
			}

		}
		return count;
	}
}
