public class MagicStonesStore
{
	public String ableToDivide(int n)
	{
		for(int i=0; i<=n/2; i++)
		{
			if(isPrime(i)&&isPrime(n-i)) return "YES";
		}
		return "NO";
	}
	public static boolean isPrime(int x)
	{
		if(x==1) return false;
		if(x==2) return true;
		if(x==3) return true;
		if(x%2==0) return false;
		if(x%3==0) return false;
		int z=(int)Math.sqrt(x);
		for(int i=5; i<=z; i+=2+((i+1)%4))
		{
			if(x%i==0) return false;
		}
		return true;
	}
}