import java.math.BigInteger;
import java.util.ArrayList;
public class Testing {
	static int pl;
	static long[] modulo;
	static long count=0;
	static long[] p = new long[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199};
	public static double gcd(double a, double b)
	{
		if (b==0) return a;
		return gcd(b,a%b);
	}
	public static double quality(double i,double j,int k)
	{
		double res = Math.floor(Math.pow(j/i,k));
		String rr = res+"";
		rr = rr.substring(rr.length()-2);
		BigInteger ii = new BigInteger(i+"");
		BigInteger jj = new BigInteger(j+"");
		BigInteger diff =  jj.pow(k).subtract(ii.pow(k).multiply(new BigInteger(rr)));
		ArrayList<BigInteger> r = new ArrayList<BigInteger>();
		ArrayList<BigInteger> r1 = primeDecomposition(jj);
		ArrayList<BigInteger> r2 = primeDecomposition(new BigInteger(rr).multiply(ii));
		ArrayList<BigInteger> r3 = primeDecomposition(diff);
		for(int a=0; a<r1.size(); a++) 
			if(!r.contains(r1.get(a))) 
				r.add(r1.get(a));
		for(int a=0; a<r2.size(); a++) 
			if(!r.contains(r2.get(a)))
				r.add(r2.get(a));
		for(int a=0; a<r3.size(); a++) if(!r.contains(r3.get(a))) r.add(r3.get(a));
		double sum = 0;
		for(int a=0; a<r.size(); a++)
			sum+=Math.log10(r.get(a).doubleValue());
		return k*Math.log10(j)/sum;
	}
	public static ArrayList<BigInteger> primeDecomposition(BigInteger x)
	{
		ArrayList<BigInteger> p = new ArrayList<BigInteger>();
		while(!x.equals(BigInteger.ONE))
		{
			BigInteger r = factor(x);
			if(!p.contains(r))
				p.add(r);
			x.divide(r);
		}
		return p;
	}
	public static BigInteger factor(BigInteger x)
	{
		for(int i=0; i<p.length; i++)
		{
			System.out.println(i);
			BigInteger pp = new BigInteger(p[i]+"");
			if(x.mod(pp).equals(BigInteger.ZERO)) return pp;
		}

		for(double i=p[p.length-1]; x.compareTo(new BigInteger(i*i+""))==1; i+=2)
		{
			BigInteger ii = new BigInteger(i+"");
			if(x.mod(ii).equals(BigInteger.ZERO)) 
				return ii;
		}
		return x;
	}
	public static void maind(String[] args) 
	{
		/*for(double i=5000; i<50000; i++)
		{
			if(i%1000==0) System.out.println(i/1000);
			for(double j=i+1; j<100000; j++)
			{
				if(gcd(j,i)==1)
				{
					for(double k=2; k<20; k++)
					{
						double res = Math.pow(j/i,k);
						double resl = Math.floor(res);
						double diff = Math.pow(j,k)-Math.pow(i,k)*resl;
						if(res-resl<.0001 && gcd(resl*i,diff)==1) 
						{
							double r = quality(i,j,k);
							if(r>1.4)
								System.out.println("("+j+"/"+i+")^"+k+"   "+diff + "  rad:"+r);
						}
					}	
				}
			}
		}*/
		/*
		BigInteger aa = new BigInteger("50");
		ArrayList<BigInteger> x = primeDecomposition(aa);
		for(int i=0; i<x.size(); i++) System.out.println(x.get(i));*/
		//System.out.println(quality(3125,43038,2));
		modulo = new long[20];
		modulo[0]=1l;
		for(int i=1; i<20; i++)
			modulo[i]=10*modulo[i-1];
		long c = System.currentTimeMillis();
		pl = 10;
		System.out.println("result: "+semiPrime(999989*999991l,9,1,1));
		long cc = System.currentTimeMillis()-c;
		System.out.println("RUNTIME:"+ cc + " iter"+count);
	}
	public static void main(String args[])
	{
		int N = 2013;
		double sum = 0.0;
		for(int i=N+1; i<=2*N; i++)
		{
			sum += (f(i,i-N)%2011);
			System.out.println(sum%2011);
		}
		System.out.println(sum);
	}
	public static double f(int n, int k)
	{
		if(k == 0 )return 0;
		if(k==1 ) return 1;
		else
		return (n*f(n,k-1)-(n-k+1)*f(n,k-2))/(k-1);
	}
	public static long semiPrime(long p, long x, long y, int size)
	{
		count++;
		if(x==p) return -1; 
		if(p==x*y && x!=1) 
		{
			return x;
		}
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++)
			{
				long mod = modulo[size+1];
				Long l = i*modulo[size]+x;
				Long m = j*modulo[size]+y;
				if(l*m<=p && size<pl)
					if(l*m % mod == p %mod)
					{
						long res = semiPrime(p,l,m,size+1);
						if(res!=-1) return res;
					}
			}
		return -1;
	}
}
