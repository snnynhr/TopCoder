public class KingdomAndTrees
{
	public int minLevel(int[] heights)
	{
		int max = 0;
		for(int i=0; i<heights.length-1; i++)
		{
			for(int j=i+1; j<heights.length; j++)
			{
				if(heights[j]<=heights[i]) max=Math.max(max,(heights[i]-heights[j])/2+1);
			}
		}
		return max;
	}
}