
public class PointErasingTwo {
	public int getMaximum(int[] y)
	{
		int max =0;
		for(int i=0; i<y.length; i++)
		{
			for(int j=0; j<y.length; j++)
			{
				int l = count(i,j,y);
				if(l>max) max=l;
			}
		}
		return max;
	}
	public int count(int a, int b, int[] z)
	{
		int count=0;
		for(int i=0; i<z.length; i++)
		{
			if(inRect(i, z[i], a, b, z)) count++;
		}
		return count;
	}
	public boolean inRect(int x, int y, int a, int b, int[] z)
	{
		int left=0,right=0,up=0,down=0;
		if(a<b)
		{
			left = a;
			right =b;
		}
		else
		{
			left = b;
			right =a;
		}
		if(z[a]<z[b])
		{	
			up = b;
			down =a;
		}
		else
		{
			up = a;
			down =b;
		}
		if( x<right && x>left && y>down && y<up) return true;
		else return false;
	}
}
