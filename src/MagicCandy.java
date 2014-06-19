
public class MagicCandy
{
	//1<=n<=1,000,000,000
	public int whichOne(int n)
	{
		if(n==1) return 1;
		int z=(int)(Math.sqrt(n)-0.5);
		if(n>=((z+1)*(z+1)+1)) return (z+1)*(z+1)+1;
		return z*(z+1)+1;
	}
}