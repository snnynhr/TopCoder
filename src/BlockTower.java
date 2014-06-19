public class BlockTower
{
	static int[] dp;
	public static int getTallest(int[] blockHeights)
	{
		int n = blockHeights.length;
		dp = new int[n];
		for(int i=0; i<n; i++)
		{
			int c = blockHeights[i];
			dp[i]=c;
			for(int j=0; j<i; j++)
				if(!(c%2==0&&blockHeights[j]%2==1))
					dp[i] = Math.max(dp[i],c+dp[j]);
		}
		int max=0;
		for(int i=0; i<n; i++)
			max=Math.max(dp[i],max);
		return max;
	}
	public static void main(String args[])
	{
		System.out.println(getTallest(new int[] {44,349,3,3,44,3,44,47,2,47,2,47,2}));
	}
}