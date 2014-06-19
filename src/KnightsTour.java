import java.util.ArrayList;

public class KnightsTour
{
	boolean grid[][] = new boolean[8][8];
	public int visitedPositions(String[] board)
	{
		int count=1;
		int x = 0,y = 0;
		for(int i=0; i<8; i++)
		{
			for(int j=0; j<8; j++)
			{
				grid[i][j]=false;
				if(board[i].charAt(j)=='K')
				{
					x=i;
					y=j;
				}
			}
		}
		//grid[x][y]=true;
		while(getAccessiblity(x, y, board)>0)
		{
			System.out.println("("+x+","+y+")");
			int[][] pos = {{x-2,y-1},{x-1,y-2},{x+1,y-1},{x+2,y-1},{x-1,y+2},{x-2,y+1},{x+1,y+2},{x+2,y+1}};
			int[] res = new int[9];
			for(int i=0; i<8; i++)
			{
				if(pos[i][0]>=0 && pos[i][0]<8 && pos[i][1]>=0 && pos[i][1]<8)
					res[i]=getAccessiblity(pos[i][0], pos[i][1], board);
			}
			res[8]=9;
			int min=8;
			for(int i=0; i<8; i++)
			{
				if(res[i] < res[min] && res[i]>0) min=i;
			}
			ArrayList<Integer> m = new ArrayList<Integer>();
			for(int i=0; i<8; i++)
				if(res[i]==res[min])
					m.add(i);
			if(m.size()>1)
			{
				int minr=0;

				for(int i=0; i<m.size(); i++)
				{
					if(pos[m.get(i)][0]<pos[minr][0]) minr=m.get(i);
				}
				ArrayList<Integer> l = new ArrayList<Integer>();
				for(int i=0; i<m.size(); i++)
					if(pos[i][0]==pos[minr][0])
						l.add(i);
				if(l.size()>1)
				{
					if(pos[l.get(0)][1]<pos[l.get(1)][1]) min = l.get(0);
					else min = l.get(1);
				}
			}
			if(res[min]==0 || res[min]==9)
			{

			}
			else
			{
				count++;
				grid[x][y]=true;
				x=pos[min][0];
				y=pos[min][1];
			}
		}
		return count;
	}
	public int getAccessiblity(int r, int c, String[] board)
	{
		if(grid[r][c]==true || board[r].charAt(c)=='*') return 0;
		if(r<0 || r>7 || c<0 || c>7) return 0;
		int count=0;
		int[][] pos = {{r-2,c-1},{r-1,c-2},{r+1,c-1},{r+2,c-1},{r-1,c+2},{r-2,c+1},{r+1,c+2},{r+2,c+1}};
		for(int i=0; i<pos.length; i++)
		{
			if( pos[i][0]<8 && pos[i][0]>=0 && pos[i][1]<8 && pos[i][1]>=0)
				if(board[pos[i][0]].charAt(pos[i][1])=='.' && grid[pos[i][0]][pos[i][1]]==false)
					count++;
		}
		return count;
	}
}