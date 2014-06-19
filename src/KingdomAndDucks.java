import java.util.ArrayList;
import java.util.Arrays;

public class KingdomAndDucks
{
	ArrayList<Integer> dump = new ArrayList<Integer>();
	public int minDucks(int[] duckTypes)
	{
		Arrays.sort(duckTypes);
		if(duckTypes.length==1) return 1;
		int maxcount=0;
		int curr=0;
		for(int i=0; i<duckTypes.length; i++)
			if(!dump.contains(duckTypes[i])) dump.add(duckTypes[i]);
		for(int i=0; i<duckTypes.length-1; i++)
		{
			curr++;
			if(duckTypes[i]!=duckTypes[i+1])
			{
				maxcount = Math.max(maxcount, curr);
				curr=0;
			}
		}
		if(duckTypes[duckTypes.length-2]==duckTypes[duckTypes.length-1])
		{
			curr++;
			maxcount = Math.max(maxcount, curr);
		}
		return maxcount*dump.size();
	}
}