
public class GogoXReimuHakurai
{
	int N;
	int[][] possible;
	public int solve(String[] choices)
	{
		N=choices.length;
		int c=0;
		possible= new int[N][N];
		for(int i=0; i<N; i++)
		{
			if(choices[0].charAt(i)=='Y') 
			{
				c++;
				possible[0][i]=1;
			}
		}
		if(c==0) return 0;
		return c;
		

	}
}