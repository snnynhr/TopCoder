
public class FoxPaintingBalls
{
	public long theMax(long R, long G, long B, int N)
	{
		long min = Math.min(Math.min(R,G),Math.min(G, B));
		//return(Math.min((R+G+B)/(N*(N+1)/2)), min/);
		return min;
	}
}