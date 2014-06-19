public class FoxAndGCDLCM
{
	public long get(long G, long L)
	{
		if(L<G) return -1;
		if(L==G) return L;
		if((L % G)!=0) return -1;
		
		long gcd =(long) gcf(G,L);
		long a=G/gcd;
		long b=L/gcd;
		if(a==1 && isPrimeLong(b)) return gcd*(a+b);
		
		double product = G*L;
		double start=Math.floor(Math.sqrt(product));
		System.out.println("ok");
		
		while(start<=product)
		{
			if(product/start==Math.floor(product/start))
				if(gcf(start,product/start)==G)
				return (long)(start+product/start);
			start+=1;
		}
		return -1;
	}
	public double gcf(double starta, double d) 
	{
		double gcd = 0;
		if (d == 0) 
			gcd = starta;
		else 
			gcd = gcf(d, starta % d);
		return gcd;
	}
	public static boolean isPrimeLong(long x)
	{
		//naive algorithm runtime sqrt(x)/4 + 2 for all x>=0;
		if(x==2 || x==3) return true;
		if(x==1 || x%2==0 || x%3==0) return false;
		long z=(long)Math.sqrt(x);
		for(long i=5; i<=z; i+=2+((i-1)%4))
			if(x%i==0) return false;
		return true;
	}
}