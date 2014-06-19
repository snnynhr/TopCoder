import java.util.Arrays;

public class MonstersValley
{
	public static int minimumPrice(long[] dread, int[] price)
	{
		int N = dread.length;
		//long[][] dp = new long[N+1][N+1];
		long[] dpp = new long[N];
		int[] pr = new int[N];
		dpp[0]=0;
		long[] maxupto = new long[N];
		maxupto[0]=dread[0];
		for(int i=1; i<N; i++) 
		{
			pr[i] = Integer.MAX_VALUE;
			maxupto[i] = Math.max(dread[i], maxupto[i-1]);
		}
		pr[0] = price[0];
		dpp[0] = dread[0];
		for(int i=1; i<N; i++)
		{
			for(int j= i-1; j>=0; j--)
			{

				long best=0;
				int minp = 2;
				for(int k=j+1; k<=i; k++)
				{
					
					if(maxupto[i]-dpp[j]>0 && dread[k]>=maxupto[i]-dpp[i] && dread[k]>=best && price[k]<=minp)
					{
						minp = price[k];
						best = dread[k];
					}
				}
				dpp[i] = Math.max(dpp[j]+best, dpp[i]);
				pr[i] = Math.min(pr[j]+minp, pr[i]);
			}

		}
		//System.out.println(Arrays.toString(maxupto));
		System.out.println(Arrays.toString(dpp));
		System.out.println(Arrays.toString(pr));
		return pr[pr.length-1];
	}
	public static void main(String args[])
	{
		long[] d = {200, 107, 105, 206, 307, 400};
		
		int[] p = {1, 2, 1, 1, 1, 2};
		minimumPrice(d, p);
	}
}