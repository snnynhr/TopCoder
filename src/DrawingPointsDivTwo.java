import java.util.ArrayList;


public class DrawingPointsDivTwo
{
	static ArrayList<Point> pts;
	static DrawingPointsDivTwo x = new DrawingPointsDivTwo();
	public static void main(String args[])
	{
		String aaa[] = {"....................",
				 "..........*.........",
				 "....................",
				 ".........*..........",
				 "....................",
				 "....................",
				 "....................",
				 "....................",
				 "....................",
				 "....................",
				 "....................",
				 "....................",
				 ".*..................",
				 "....................",
				 "*.............**....",
				 "....................",
				 "....................",
				 "................*...",
				 "....................",
				 "...................."};
		System.out.println(maxSteps(aaa));
	}
	public static int maxSteps(String[] points)
	{
		pts = new ArrayList<Point>();
		for(int i=0; i<points.length; i++)
		{
			for(int j=0; j<points[i].length(); j++)
			{
				if(points[i].charAt(j)=='*')
				{
					Point p = x.new Point(i, j);
					pts.add(p);
				}
			}
		}
		System.out.println(points.length + "adsf");
		for(int zz=1; zz<30; zz++)
		{
			int len = pts.size();
			step();
			int r = calculate(zz,points[0].length());
			if(len == r) System.out.println("YES");
			else return zz-1;
		}
		return -1;
	}
	public static int calculate(int i, int l)
	{

		int res=0;
		int[][] g = new int[2*i+l][2*i+l];
		for(int j=0; j<pts.size(); j++)
		{
			//System.out.println(pts.get(j).x+ " "+pts.get(j).y);
			g[pts.get(j).x][pts.get(j).y]=1;
		}
		for(int k=0; k<g.length-1; k++)
		{
			for(int m=0; m<g[k].length-1; m++)
			{
				if(g[k][m]==1 && g[k+1][m]==1 && g[k+1][m+1]==1 && g[k][m+1]==1)
				{
					res++;
				}
			}
		}
		return res;
	}
	public static void step()
	{
		int l = pts.size();
		for(int i=0; i<l; i++)
		{
			Point p = pts.remove(0);
			pts.add(x.new Point(p.x+0.5,p.y+0.5));
			pts.add(x.new Point(p.x+0.5,p.y-0.5));
			pts.add(x.new Point(p.x-0.5,p.y+0.5));
			pts.add(x.new Point(p.x-0.5,p.y-0.5));
		}
	}
	class Point
	{
		int x, y;
		public Point(double a, double b)
		{
			double aa = (int) a;
			if(aa!=a)
			{
				double xx=a+0.5;
				double yy=b+0.5;
				x = (int) xx;
				y = (int) yy;
			}
			else
			{
				x=(int)a;
				y=(int)b;
			}
		}
	}

}	