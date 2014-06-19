import java.util.Arrays;


public class PillarsDivTwo
{
	public double maximalLength(int[] height, int w)
	{
		int[] maxA = new int[height.length];
		int[] maxB = new int[height.length];
		int s=0;
		for(int i=0; i<height.length; i++)	
		{
			if(s==0) maxA[i]=height[i];
			if(s==1) maxA[i]=1;
			if(height[i]==1) 
			{
				s=1;
				maxA[i]=1;
			}
			s=1-s;
		}
		System.out.println(Arrays.toString(maxA));
		s=1;
		for(int i=0; i<height.length; i++)	
		{
			if(s==0) maxB[i]=height[i];
			if(s==1) maxB[i]=1;
			if(height[i]==1) 
			{
				s=1;
				maxB[i]=1;
			}
			s=1-s;
		}
		System.out.println(Arrays.toString(maxB));
		return Math.max(getLength(maxA,w), getLength(maxB,w));
	}
	public double getLength(int[] seq, int w)
	{
		double d=0.0;
		for(int i=0; i<seq.length-1; i++)
			d+=Math.sqrt((seq[i+1]-seq[i])*(seq[i+1]-seq[i])+w*w);
		return d;
	}
}