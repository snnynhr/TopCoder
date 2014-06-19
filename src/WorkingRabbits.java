
public class WorkingRabbits
{
	public double getEfficiency(String[] profit)
	{
		double sum=0;
		int x = profit.length;
		for(int i=0; i<profit.length; i++)
		{
			for(int j=0; j<profit[i].length(); j++)
			{
				sum+=Integer.parseInt(profit[i].charAt(j)+"");
			}
		}
		return sum/((x-1)*x);
	}
}