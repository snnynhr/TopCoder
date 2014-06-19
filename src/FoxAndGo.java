import java.util.Arrays;


public class FoxAndGo {
	int count;
	int n;
	int[][] xx;
	boolean[][] vis;
	int[] cc;
	public int maxKill(String[] board)
	{
		count = 1;
		n = board.length;
		xx = new int[n][n];
		vis = new boolean[n][n];
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(board[i].charAt(j)=='o' && !vis[i][j])
				{
					floodfill(i,j,board);
					count++;
				}
				else if(board[i].charAt(j)=='x') xx[i][j]=-1;
			}
		}
		for(int i=0; i<n; i++)
			System.out.println(Arrays.toString(xx[i]));
		cc = new int[count];
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(xx[i][j]>=1)
				{
					cc[xx[i][j]]++;					
				}
			}
		}
		int max = 0;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(board[i].charAt(j)=='.')
				{
					max = Math.max(putX(i, j,board),max);
				}
			}
		}
		return max;
	}
	public int putX(int x, int y,String[] board)
	{
		int countKill = 0;
		board[x] =board[x].substring(0,y)+'x'+board[x].substring(y+1);
		for(int c=1; c<count; c++)
		{
			boolean safe = false;
			out: for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++)
				{
					if(xx[i][j]==c)
					{
						if(isSafe(i, j, board))
						{
							safe = true;
							break out;
						}
						
					}
				}
			}
			if(!safe) countKill +=cc[c];
		}
		board[x] =board[x].substring(0,y)+'.'+board[x].substring(y+1);
		return countKill;
	}
	public boolean isSafe(int x, int y, String[] board)
	{
		boolean f = false;
		if(isV(x+1,y) && board[x+1].charAt(y)=='.')
			f = true;
		else if(isV(x-1,y) && board[x-1].charAt(y)=='.')
			f = true;
		else if(isV(x,y+1) && board[x].charAt(y+1)=='.')
			f = true;
		else if(isV(x,y-1) && board[x].charAt(y-1)=='.')
			f = true;
		return f;
	}
	public void floodfill(int x, int y, String[] board)
	{
		xx[x][y] = count;
		vis[x][y] = true;
		if(isV(x+1,y)&& !vis[x+1][y] && board[x+1].charAt(y)=='o')
			floodfill(x+1,y,board);
		if(isV(x-1,y)&& !vis[x-1][y] && board[x-1].charAt(y)=='o')
			floodfill(x-1,y,board);
		if(isV(x,y+1)&& !vis[x][y+1] && board[x].charAt(y+1)=='o')
			floodfill(x,y+1,board);
		if(isV(x,y-1)&& !vis[x][y-1] && board[x].charAt(y-1)=='o')
			floodfill(x,y-1,board);
	}
	public boolean isV(int x, int y)
	{
		if(x>=0 && y>=0 && x<n && y<n) return true;
		return false;
	}
}
