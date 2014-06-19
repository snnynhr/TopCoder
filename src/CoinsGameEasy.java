import java.util.ArrayList;

public class CoinsGameEasy
{
	static ArrayList<Long> c = new ArrayList<Long>(1048576);
	static int[][] oo = new int[2][2];
	static int ind=0;
	static int[][] pos = new int[2][2];
	static String[] bd;
	public static int minimalSteps(String[] board)
	{
		bd = board;
		long ccc = System.currentTimeMillis();
		dfs(0,0);
		System.out.println(System.currentTimeMillis()-ccc);
		for(int i=0; i<board.length; i++)
			for(int j=0; j<board[i].length(); j++)
				if(bd[i].charAt(j)=='o') 
				{
					oo[ind][0]=i;
					oo[ind][1]=j;
					ind++;
				}
		int min = 11;
		ccc = System.currentTimeMillis();
		for(int i=0; i<c.size(); i++)
		{
			int res = applyMove(c.get(i), oo);
			if(res!=-1) min = Math.min(min, res);
		}
		System.out.println(System.currentTimeMillis() - ccc);
		if(min == 11) return -1;
		else return min;
	}
	public static int applyMove(long s,int[][] oo)
	{
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		pos[0][0] = oo[0][0];
		pos[1][0] = oo[1][0];
		pos[1][1] = oo[1][1];
		pos[0][1] = oo[0][1];
		for(int i=0; i<10; i++)
		{
			
			int a = (int) (s%10);
			int ddx = pos[0][0] + dx[a];
			int ddy = pos[0][1] + dy[a];
			int ddx1 = pos[1][0] + dx[a];
			int ddy1 = pos[1][1] + dy[a];
			boolean aa = inBounds(ddx,ddy);
			boolean bb = inBounds(ddx1,ddy1);
			if(aa&&!bb)
				return i+1;
			else if(!aa&&bb)
				return i+1;
			else if(!aa&&!bb) return -1;
			else 
			{
				if(bd[ddx].charAt(ddy)!='#')
				{
					pos[0][0]=ddx;
					pos[0][1]=ddy;
				}
				if(bd[ddx1].charAt(ddy1)!='#')
				{
					
					pos[1][0]=ddx1;
					pos[1][1]=ddy1;
				}
			}
			s/=10;
		}
		return -1;
	}
	public static boolean inBounds(int x, int y)
	{
		if(x<0 || x>=bd.length || y<0 || y>=bd[0].length()) return false;
		return true;
	}
	public static void dfs(long s, int d)
	{
		if(d==10) c.add(s);
		else
		{
			dfs(10*s+0,d+1);
			dfs(10*s+1,d+1);
			dfs(10*s+2,d+1);
			dfs(10*s+3,d+1);
		}
	}
}