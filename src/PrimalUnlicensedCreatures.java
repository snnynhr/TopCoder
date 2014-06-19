import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimalUnlicensedCreatures
{
	public static int maxWins(int initialLevel, int[] grezPower)
	{
		int c=0;
		Arrays.sort(grezPower);
		for(int i=0; i<grezPower.length; i++)
		{
			if(initialLevel>grezPower[i])
			{
				initialLevel += grezPower[i]/2;
				c++;
			}
			else
			{
				break;
			}
		}
		return c;
	}
	public static int maxWinsD(int initialLevel, int[] grezPower)
	{
		int wins=0; 
		int myP = initialLevel;
		List<Integer> ps = new ArrayList<Integer>();
		for(int i=0; i<grezPower.length; i++)
			ps.add(grezPower[i]);
		boolean c = true;
		while(c)
		{
			c=false;
			for(java.util.Iterator<Integer> iterator = ps.iterator(); iterator.hasNext();){
				Integer p = iterator.next(); 
				System.out.println(p);
				if(p<myP){
					myP +=p/2;
					wins++;
					iterator.remove();
					c=true;
				}
			}
		}
		return wins;
	}
	public static void main(String args[])
	{
		System.out.println(maxWinsD(4, new int[]
				{3, 133, 6, 4, 9,9}));
	}
}