import java.util.Arrays;


public class PenguinSledding
{
	static int[][] adj;
	static boolean[] vertex = new boolean[51];
	static int[] cc = new int[51];
	static int counter = 1;
	static boolean[] visited = new boolean[51];
	public static long countDesigns(int numCheckpoints, int[] checkpoint1, int[] checkpoint2)
	{
		int N = checkpoint1.length;
		adj = new int[51][51];
		for(int i=0; i<N; i++)
		{
			adj[checkpoint1[i]][checkpoint2[i]]=1;
			adj[checkpoint2[i]][checkpoint1[i]]=1;
			vertex[checkpoint1[i]]= true;
			vertex[checkpoint2[i]]= true;
		}
		for(int i=0; i<visited.length; i++)
		{
			if(!visited[i]&&vertex[i])
			{
				dfs(i,counter);
				counter++;
			}
		}
		System.out.println(Arrays.toString(cc));
		for(int i=0; i<cc.length; i++)
		{
			
		}
		return 0;
	}
	public static void dfs(int v, int c)
	{
		cc[v] = c;
		visited[v] = true;
		for(int i=0; i<adj.length; i++)
		{
			if(adj[v][i]==1 && visited[i]==false) dfs(i,c);
		}
	}
	public static void main(String args[])
	{
		int a= 36;
		int[] b = 
				{13, 24, 24, 20, 31, 16, 10, 36, 34, 32, 
			 28, 5, 20, 29, 23, 2, 14, 4, 9, 5, 19, 
			 21, 8, 1, 26, 27, 25, 15, 22, 30, 30, 
			 6, 11, 7, 2, 35, 13, 29, 4, 12, 33, 18, 
			 13, 14, 17, 35, 3}			;
				
		int[] c = {10, 15, 27, 1, 29, 11, 5, 18, 33, 1, 9,
				 2, 31, 6, 19, 10, 33, 18, 6, 27, 3, 22,
				 4, 12, 31, 30, 34, 16, 7, 24, 3, 28, 15,
				 21, 22, 8, 26, 20, 14, 32, 25, 17, 35,
				 8, 36, 26, 23};
		countDesigns(a, b, c);
	}
}