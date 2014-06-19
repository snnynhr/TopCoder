
public class PastingPaintingDivTwo
{
	static String[][] grid = new String[501][501];
	static int cutoff = 50;
	public static long countColors(String[] clipboard, int T)
	{
		long sum;
		for(int i=0; i<501; i++)
			for(int j=0; j<501; j++)
				grid[i][j]=".";
		if(T<cutoff)
		{
			for(int i=0; i<T; i++)
			{
				paste(i,clipboard);
			}
			return sum = count();
		}
		else
		{
			for(int i=0; i<cutoff; i++)
			{
				paste(i,clipboard);
			}
			sum = count();
			paste(cutoff,clipboard);
			long diff = count()-sum;
			return sum+diff*(T-cutoff);
		}
	}
	public static void main(String args[])
	{
		String[] a = {
				"..........B..........",
				".........B.B.........",
				"........B...B........",
				".......B.....B.......",
				"......B..B.B..B......",
				".....B...B.B...B.....",
				"....B...........B....",
				"...B...B.....B...B...",
				"..B.....BBBBBB....B..",
				".B..........BB.....B.",
				"BBBBBBBBBBBBBBBBBBBBB"
		};
		System.out.println(countColors(a, 1000000000));
		System.out.println(fact(13));
	}
	public static int fact(int n)
	{
		if(n==1) return 1;
		return n*fact(n-1);
	}
	public static void paste(int dx, String[] clipboard)
	{
		for(int i=0; i<clipboard.length; i++)
			for(int j=0; j<clipboard[i].length(); j++)
				if(clipboard[i].charAt(j)=='B') grid[i+dx][j+dx] = "B";
	}
	public static int count()
	{
		int count=0;
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid.length; j++)
				if(grid[i][j].equals("B")) count++;
		return count;
	}
}