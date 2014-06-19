import java.util.Arrays;

public class Mosquitoes
{
	double[] pos;
	double[] a;
	public int getMaximum(int[] xInit, int[] v, int R)
	{
		pos=new double[xInit.length];
		for(int i=0; i<pos.length; i++)
			pos[i]=xInit[i];
		int max=0;
		for(double t=0; t<=100; t+=.5)
		{
			double[] a = pos.clone();
			Arrays.sort(a);
			for(double i=a[0]; i<=a[a.length-1]; i+=.5)
				max=Math.max(getNum(i,R),max);
			updatePos(.5,v);
		}
		return max;
	}
	public void updatePos(double s, int[] v)
	{
		for(int i=0; i<pos.length; i++)
			pos[i]=pos[i]+s*((double)v[i]);
	}
	public int getNum(double p, int R)
	{
		int count=0;
		for(int i=0; i<pos.length; i++)
			if((pos[i]>=p-R )&&(pos[i]<=p+R)) count ++;
		return count;
	}
}