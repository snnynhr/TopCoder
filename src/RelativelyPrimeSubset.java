import java.util.ArrayList;
import java.util.Collections;

public class RelativelyPrimeSubset
{
	public int findSize(int[] S)
	{
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> dump = new ArrayList<Integer>();
		for(int i=0; i<S.length; i++)
		{
			if(S[i]%2==0) even.add(S[i]);
			else odd.add(S[i]);
		}
		
		if(odd.size()!=0)
			Collections.sort(odd);
		if(even.size()!=0)
			Collections.sort(even);
		for(int i=0; i<odd.size(); i++)
		{
			if(isPrimeInt(odd.get(i))) primes.add(odd.get(i));
			else dump.add(odd.get(i));
		}
		/*
		for(int i=0; i<primes.size(); i++)
			System.out.print(primes.get(i)+" ");
		System.out.println();
		
		for(int i=0; i<dump.size(); i++)
			System.out.print(dump.get(i)+" ");
		System.out.println();*/
		
		for(int i=0; i<dump.size(); i++)
		{
			boolean a = true;
			for(int j=0; j<primes.size(); j++)
			{
				if(gcd(primes.get(j),dump.get(i))!=1)
				{
					a=false;
					break;
				}
			}
			if(a) primes.add(dump.get(i));
		}
		//greedy
		if(even.size()==0)
		return primes.size();
		else return primes.size()+1;
	}
	public int gcd(int p, int q) {
		while (q != 0) {
			int t = q;
			q = p % q;
			p = t;
		}
		return p;
	}
	public static boolean isPrimeInt(int x)
	{
		//naive algorithm runtime sqrt(x)/4 + 2 for all x>=0;
		if(x==2 || x==3) return true;
		if(x==1 || x%2==0 || x%3==0) return false;
		int z=(int)Math.sqrt(x);
		for(int i=5; i<=z; i+=2+((i-1)%4))
			if(x%i==0) return false;
		return true;
	}
}