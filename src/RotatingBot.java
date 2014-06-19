
public class RotatingBot
{
	static int[][] grid = new int[105][105];
	static int x = 52;
	static int y = 52;
	static int direction =0;
	static int MaxH=0, MaxL=0;
	public int minArea(int[] moves)
	{
		/*if(moves.length>=4)
			if(moves[2]<moves[0]) return -1;
		if(moves.length>=5)
		{
			if(moves[2]==moves[0])
			{
				if(moves[3]!=(moves[1]-1)) return -1; 
			}
			else if(moves[2]>moves[0])
			{
				if(moves[3]<moves[1]) return -1;
			}
		}*/
		grid[x][y]=1;
		for(int i=0; i<moves.length; i++)
		{
			int res = executeMove(moves[i], (direction++)%4,i,moves);
			if(res==-1) return -1;
		}
		return getMax();
	}
	public int getMax()
	{
		int maxR=52, maxL=52, minR=52, minL=52;
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid.length; j++)
				if(grid[i][j]==1)
				{
					if(i>=maxL)
						maxL=i;
					else if(i<=minL)
						minL=i;
					if(j>=maxR)
						maxR=j;
					else if(j<=minR)
						minR=j;
				}
		return (maxL-minL+1)*(maxR-minR+1);
	}
	public int executeMove(int l, int dir,int index, int[] moves)
	{
		if(dir%2==0) MaxL = Math.max(MaxL,l);
		else MaxH = Math.max(MaxH,l);
		if(dir==0)
		{
			for(int i=1; i<=l; i++)
			{
				if(grid[x+1][y]!=1)
					grid[++x][y]=1;
				else
					return -1;
			}
			if(index!=moves.length-1 && l<MaxL && grid[x+1][y]!=1) return -1;
		}
		else if(dir==1)
		{
			for(int i=1; i<=l; i++)
			{
				if(grid[x][y+1]!=1)
					grid[x][++y]=1;
				else
					return -1;
			}
			if(index!=moves.length-1 && l<MaxH && grid[x][y+1]!=1) return -1;
		}
		else if(dir==2)
		{
			for(int i=1; i<=l; i++)
			{
				if(grid[x-1][y]!=1)
					grid[--x][y]=1;
				else
					return -1;
			}
			if(index!=moves.length-1 && l<MaxL && grid[x-1][y]!=1) return -1;
		}
		else if(dir==3)
		{
			for(int i=1; i<=l; i++)
			{
				if(grid[x][y-1]!=1)
					grid[x][--y]=1;
				else
					return -1;
			}
			if(index!=moves.length-1 && l<MaxH && grid[x][y-1]!=1) return -1;
		}
		return 0;
	}
}