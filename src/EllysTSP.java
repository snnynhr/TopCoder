
public class EllysTSP
{
	public static int getMax(String places)
	{
		int a=cCount(places);
		int b=vCount(places);
		if(a==b) return a+b;
		if(a<b) return 2*a+1;
		if(b<a) return 2*b+1;
		return 1;
	}
	public static int cCount(String places)
	{
		int c=0;
		for(int i=0; i<places.length(); i++)
		{
			if(places.charAt(i)=='C') c++;
		}
		return c;
	}
	public static int vCount(String places)
	{
		int c=0;
		for(int i=0; i<places.length(); i++)
		{
			if(places.charAt(i)=='V') c++;
		}
		return c;
	}
}