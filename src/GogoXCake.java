import java.util.Arrays;

public class GogoXCake
{
	char[][] grid;
	char[][] cut;
	public String solve(String[] cake, String[] cutter)
	{
		int count=0;
		int ncut=0;
		grid=new char[cake.length][cake[0].length()];
		for(int i=0; i<cake.length; i++)
			for(int j=0; j<cake[i].length(); j++)
			{
				grid[i][j]=cake[i].charAt(j);
				if(cake[i].charAt(j)=='.') count ++;
			}
		cut= new char[cutter.length][cutter[0].length()];
		for(int i=0; i<cutter.length; i++)
			for(int j=0; j<cutter[i].length(); j++)
			{
				cut[i][j]=cutter[i].charAt(j);
				if(cutter[i].charAt(j)=='.') ncut ++;
			}
		if(count%ncut!=0) return "NO";

		for(int i=0; i<grid.length; i++)
		{
			for(int j=0; j<grid[i].length; j++)
			{
				if(ifapplyMove(i, j))
				{
					System.out.println(i+" "+j);
					for(int a=0; a<cut.length; a++)
					{
						for(int b=0; b<cut[0].length; b++)
						{
							if(cut[a][b]=='.') grid[i+a][j+b]='X';
						}
					}
				}
			}
		}
		for(int i=0; i<grid.length; i++)
			System.out.println(Arrays.toString(grid[i]));
		for(int i=0; i<grid.length; i++)
			for(int j=0; j<grid[i].length; j++)
			{
				if(grid[i][j]=='.') return "NO";
			}
		return "YES";
	}
	public boolean ifapplyMove(int i, int j)
	{
		
		if(i+cut.length>grid.length || j+cut[0].length>grid[0].length) return false;
		System.out.println("ok");
		for(int a=0; a<cut.length; a++)
		{
			for(int b=0; b<cut[0].length; b++)
			{
				if(grid[i+a][j+b]=='X' && cut[a][b]=='.') return false;
			}
		}
		return true;
	}
}