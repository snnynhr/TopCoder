public class MinimalTriangle
{
	public double maximalArea(int length)
	{
		double l = length;
		return (double)(l*l)*Math.sqrt(3)/4;
	}
}