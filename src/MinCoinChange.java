public class MinCoinChange {
	
	public int MinChange(int x)
	{
		int[] dp = new int[x+1];
		int[] chg = {1,5,10,25};
		dp[0]=0;
		for(int i=1; i<=x; i++)
		{
			dp[i]=Integer.MAX_VALUE;
			for(int j=0; j<chg.length; j++)
			{
				if(i>=chg[j])
				dp[i]=Math.min(dp[i],dp[i-chg[j]]+1);
			}
		}
		return dp[x];
	}
	public int improvedMinChange(int x)
	{
		return((x/25)+MinChange(x%25));
	}
}
