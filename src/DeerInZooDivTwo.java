
public class DeerInZooDivTwo
{
	public int[] getminmax(int N, int K)
	{
		int smallest = Math.max(0,N-K);
		int largest;
		if(K%2==1) largest = N-(K/2+1);
		else largest = N-(K/2);
		return new int[] {smallest,largest};
	}
}