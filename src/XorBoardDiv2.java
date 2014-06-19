
public class XorBoardDiv2
{
	int[][] grid;
	public int theMax(String[] board)
	{
		grid = new int[board.length][board[0].length()];
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[i].length(); j++)
			{
				grid[i][j]=(int)board[i].charAt(j);
			}
		}
		int res=0;
		for(int i=0; i<grid.length; i++)
		{
			for(int j=0; j<grid.length; j++)
		    {
				res = Math.max(res,switchRC(0,0,i,j,grid));
		    }
		    for(int j=0; j<grid[0].length; j++)
		    {
		    	res = Math.max(res,switchRC(0,1,i,j,grid));
		    }
		}
		for(int i=0; i<grid[0].length; i++)
		{
			for(int j=0; j<grid.length; j++)
		    {
				res = Math.max(res,switchRC(1,0,i,j,grid));
		    }
		    for(int j=0; j<grid[0].length; j++)
		    {
		    	res = Math.max(res,switchRC(1,1,i,j,grid));
		    }
		}
		return res;
	}
	public int switchRC(int v,int w,int x,int y, int[][] g)
	{
		int res=0;
		if(v==0)
		{
			for(int i=0; i<g[x].length; i++)
			{
				g[x][i]=(1-(int)g[x][i]);
			}
		}
		else
		{
			for(int i=0; i<g.length; i++)
			{
				g[i][x] = (1 - (int)g[i][x]);
			}
		}
		if(w==0)
		{
			for(int i=0; i<g[y].length; i++)
			{
				g[y][i]=(1-(int)g[y][i]);
			}
		}
		else
		{
			for(int i=0; i<g.length; i++)
			{
				g[i][y] = (1 - (int)g[i][y]);
			}
		}
		for(int i=0; i<g.length; i++)
		{
			for(int j=0; j<g[i].length; j++)
			{
				if(g[i][j]==1) res++;
			}
		}
		return res;
	}
}
//Powered by [KawigiEdit] 2.0!