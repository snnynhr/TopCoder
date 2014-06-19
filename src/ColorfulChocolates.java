import java.util.ArrayList;
import java.util.Collections;


public class ColorfulChocolates
{
	int count=0;
	boolean[] found = new boolean[26];
	public int maximumSpread(String chocolates, int maxSwaps)
	{
		int max=0;
		for(int i=0; i<chocolates.length(); i++)
			found[chocolates.charAt(i)-65]=true;
		for(int i=0; i<found.length; i++)
		{
			if(found[i])
			{
				
				char z = (char) (i+65);
				int[] dep = new int[chocolates.length()];
				for(int j=0; j<dep.length; j++)
					if(chocolates.charAt(j)==z) dep[j]=1;
				for(int c=0; c<=dep.length; c++)
				{
					ArrayList<Integer> distances = new ArrayList<Integer>();
					int numleft=0, numright=0;
					for(int x=c-1; x>=0; x--)
					{
						int d=c-1;
						if(dep[x]==1)
						{
							distances.add((d-x)-numleft);
							numleft++;
						}
					}
					for(int y=c; y<dep.length; y++)
					{
						if(dep[y]==1)
						{
							distances.add((y-c)-numright);
							numright++;
						}
					}
					Collections.sort(distances);
					int sum=0;
					int count=0;
					for(int m=0; m<distances.size(); m++)
					{
						if(sum+distances.get(m)<=maxSwaps) 
						{
							count++;
							sum+=distances.get(m);
						}
					}
					max=Math.max(count,max);
				}
			}
		}
		return max;
	}
}