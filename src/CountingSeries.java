import java.util.ArrayList;


public class CountingSeries {

	//long[] arith,geo;
	ArrayList<Long> both;
	public	long countThem(long a, long b, long c, long d, long upperBound)
	{
		both=new ArrayList<Long>();
		long arith=((upperBound-a)/b+1);
		for(long i=0; i<arith; i++)
		{
			long z=a+i*b;
			if(!both.contains(z)) both.add(z);
		}
		if(d!=1)
		{
			long geo = (long) (Math.log10(upperBound/c)/Math.log10(d)+1);
			for(long i=0; i<geo; i++)
			{
				long z=c*(long)(Math.pow(d,i));
				if(!both.contains(z)) both.add(z);
			}
		}
		else
			if(!both.contains(c)) both.add(c);
		return both.size();
	}

}
