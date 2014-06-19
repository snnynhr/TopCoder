
public class Prime {
	
	public static void main(String args[])
	{
		long t = System.currentTimeMillis();
		System.out.println("RunTime: "+(System.currentTimeMillis()-t));
		//167772156 HeapSP
		//15499251 TCHeapSP
	}
	public static boolean isPrimeInt(int x)
	{
		//naive algorithm runtime sqrt(x)/4 + 2 for all x>=0;
		if(x==2 || x==3) return true;
		if(x==1 || x%2==0 || x%3==0) return false;
		int z=(int)Math.sqrt(x);
		for(int i=5; i<=z; i+=2+((i+1)%4))
			if(x%i==0) return false;
		return true;
	}
}
