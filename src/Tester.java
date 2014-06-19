import java.util.ArrayList;

public class Tester {
	static ArrayList<Integer> perm = new ArrayList<Integer>();
	static int N;
	static int[] start = {42,0};
	static int[][] grid = {{0,1,8,14,22,28,34,36},{7,0,7,18,0,7,16,7}};
	public static void main(String args[])
	{
		N=grid[0].length;
		String minval="";
		double min = 1000000.0;
		boolean[] v = new boolean[N];
		p(0,v);
		System.out.println(perm.size());
		for(int i=0; i<perm.size(); i++)
		{
			double sum=0.0;
			int cx=start[0],cy=start[1],dx,dy;
			int check = perm.get(i);
			for(int j=0; j<N; j++)
			{
				int c=check%10;
				dx = grid[0][c-1];
				dy = grid[1][c-1];
				sum+=dist(cx,cy,dx,dy);
				cx=dx;
				cy=dy;
				check/=10;
			}
			sum+=dist(cx,cy,start[0],start[1]);
			if(sum<min)
			{
				min=sum;
				minval = perm.get(i)+"";
			}
		}
		System.out.println(minval+" "+min);
	}
	public static double dist(int x,int y,int w,int z)
	{
		return Math.sqrt((x-w)*(x-w)+(y-z)*(y-z));
	}
	public static void p(int res, boolean v[])
	{
		if(res>Math.pow(10, v.length-1)) 
		{
			perm.add(res);
			return;
		}
		else
		{
			for(int i=1; i<=v.length; i++)
			{
				if(!v[i-1])
				{
					boolean[] w = v.clone();
					w[i-1]=true;
					p(res*10+i,w);
				}
			}
		}
	}
}
