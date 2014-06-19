
public class P8XGraphBuilder
{
	public int solve(int[] scores)
	{
		int m=(50+1)*4;
		int[][] mat = new int[m][m];
		int length = scores.length+1;
		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[0].length; j++)
				mat[i][j]=-1000;
		mat[0][0]=0;
		for(int i=1; i<=length; i++)
			for(int j=0; j<=2*(length-1); j++)
				for(int k=0; k<length-1; k++)
					if(j>=k+1 && mat[i-1][j-k-1]!=-1000)
						mat[i][j]=Math.max(mat[i][j], mat[i-1][j-k-1]+scores[k]);
		return mat[length][2*(length-1)];
	}
}