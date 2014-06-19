
public class HyperKnight
{
	public static long countCells(int a, int b, int numRows, int numColumns, int k)
	{
		long z=Math.max(a,b);
		long w=Math.min(a,b);
		long R = numRows;
		long C = numColumns;
		if(k%2==1) return 0;
		if(k==8)
		{
			long res = (R-2*z)*(C-2*z);
			if (res<0) return 0;
			else return res;
		}
		if(k==4)
		{
			long res = 2*z*w;
			long res1 = 0;
			long res2=res+res1;
			if (res2<0) return 0;
			else return res2;
		}
		if(k==2)
		{
			return w*(R-2*w)*2 + w*(C-2*w)*2;
		}
		if(k==6)
		{

		}
		if(k==0)
		{
			return 0;
		}
		return -10;
	}
	public static int quickCount(int r,int c, int a, int b, int k)
	{
		int[][] grid = new int[r][c];
		int cc=0;
		for(int i=0; i<r; i++)
		{
			for(int j=0; j<c; j++)
			{
				int count=0;
				if(i+a<r && j+b<c) count++;
				if(i+a<r && j-b>=0) count++;
				if(i-a>=0 && j+b<c) count++;
				if(i-a>=0 && j-b>=0) count++;
				if(j+a<r && i+b<c) count++;
				if(j+a<r && i-b>=0) count++;
				if(j-a>=0 && i+b<c) count++;
				if(j-a>=0 && i-b>=0) count++;
				if(count==k) 
				{
					grid[i][j]=1;
					cc++;
				}
			}
		}
		for(int i=0; i<r; i++)
		{
			for(int j=0; j<c; j++)
			{
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		System.out.println(cc);
		return cc;
		
	}
	public static void main(String args[])
	{
		
		quickCount(100,10,1,4,6);
	}
}