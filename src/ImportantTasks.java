import java.util.Arrays;

public class ImportantTasks
{
	public int maximalCost(int[] complexity, int[] computers)
	{
		Arrays.sort(complexity);
		Arrays.sort(computers);
		int count =0;
		int j=complexity.length-1;
		for(int i=computers.length-1; i>=0; i--)
		{

			while(j>0 && computers[i]<complexity[j])
			{
				j--;
			}
			
			if(j>=0)
			{
				if(computers[i]>=complexity[j])
				{
					
					count++;
				}
			}
			j--;

		}
		return count;		
	}
}