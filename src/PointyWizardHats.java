import java.util.Arrays;

public class PointyWizardHats
{
	public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius)
	{
		int[][] arr = new int[topHeight.length][bottomHeight.length];
		for(int i=0; i<topHeight.length; i++)
			for(int j=0; j<bottomHeight.length; j++)
				if(isValid(topHeight[i],topRadius[i],bottomHeight[j],bottomRadius[j])) arr[i][j]=1;
		for(int i=0; i<arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
		return 0;
	}
	public boolean isValid(int topHeight, int topRadius, int bottomHeight, int bottomRadius)
	{
		if(topRadius>=bottomRadius) return false;
		double a=topHeight;
		double b=topRadius;
		double c=bottomHeight;
		double d=bottomRadius;
		if(d/c<=b/a) return false;
		return true;
	}
}