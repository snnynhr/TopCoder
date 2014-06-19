import java.util.ArrayList;
import java.util.Collections;
public class Cut
{
	ArrayList<Integer> mod = new ArrayList<Integer>();
	ArrayList<Integer> rest = new ArrayList<Integer>();
	public int getMaximum(int[] eelLengths, int maxCuts)
	{
		int num=0;
		for(int i=0; i<eelLengths.length; i++)
		{
			if(eelLengths[i]==10) num++;
			else if(eelLengths[i]%10==0) mod.add(eelLengths[i]);
			else if(eelLengths[i]>10) 
				rest.add(eelLengths[i]);
		}
		Collections.sort(mod);
		Collections.sort(rest);
		int i=mod.size()-1;
		while(i>=0 && maxCuts>0)
		{
			int c=mod.get(i)/10-1;
			if(c<maxCuts)
			{
				maxCuts=-c;
				num+=(c+1);
			}
			else
			{
				num+=maxCuts+1; return num;
			}
			i--;
		}
		i=rest.size()-1;
		while(i>=0 && maxCuts>0)
		{
			int c=rest.get(i)/10;
			if(c<maxCuts)
			{
				maxCuts=-c;
				num+=c;
			}
			else
			{
				num+=maxCuts; return num;
			}
			i--;
		}
		return num;
	}
}