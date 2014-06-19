
public class ConnectGraph {
	public long numGraphs(long nodes)
	{
		if(nodes<=1) return 1;
		else
		{
			long z=0;
			for(int k=1; k<nodes; k++)
			{
				z+=k*binom(nodes,k)*((long)Math.pow(2,binom(nodes-k,2)))*numGraphs(k);
			}
			return ((long)(Math.pow(2, binom(nodes,2))))-z/nodes;
		}
	}
	private long binom(long n, long p)
	{
		return factorial(n)/(factorial(n-p)*factorial(p));
	}
	private long factorial( long n)
	{
		long k=1;
		for(long i=n; i>0; i--) k*=i;
		return k;	
	}
}
