import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class XorTravelingSalesman {
	static int[][] grid;
	static int N;
	public static int maxProfit(int[] cityValues, String[] roads)
	{
		N = roads.length;
		boolean[][] visited = new boolean[N][N];
		int[] maxVal = new int[N];
		grid = new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				if(roads[i].charAt(j)=='Y') grid[i][j]=1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		maxVal[0]=cityValues[0];
		while(!q.isEmpty())
		{
			int c = q.poll();
			//visited[c]=true;
			for(int i=0; i<N; i++)
			{
				if(grid[c][i]==1)
				{
					if(!visited[c][i]) 
					{
						visited[c][i]=true;
						q.add(i);
					}
					maxVal[i]= Math.max(maxVal[i],maxVal[c]^cityValues[i]);
				}
			}
		}
		//boolean[] w = new boolean[N];
		//System.out.println(dfs(0,w,cityValues[0],cityValues));

		System.out.println(Arrays.toString(maxVal));
		return 0;
	}
	public static int dfs(int c, boolean[] v, int value, int[] cost)
	{
		System.out.println(value);
		int max=0;
		boolean pass=false;
		v[c]=true;
		System.out.println(c+"c");
		for(int i=0; i<N; i++)
		{
			if(grid[i][c]==1 && !v[i])
			{   
				pass=true;
				max=Math.max(max,value^dfs(i,v,value^cost[i],cost));
			}
		}
		if(!pass)
		{
			return value;
		}
		System.out.println(max);
		return max;
	}
	public static void main(String[] args) {
		int[] a = {0, 7, 11, 5, 2};
		String[] s={"NYNYY",
				"YNYNN",
				"NYNNN",
				"YNNNN",
		"YNNNN"};
		System.out.println(maxProfit(a, s));

	}
}