import java.util.ArrayList;

public class TheBrickTowerEasyDivTwo
{
	static ArrayList<Integer> total = new ArrayList<Integer>();
	public static int find(int redCount, int redHeight, int blueCount, int blueHeight)
	{
		for(int i=0; i<=redCount; i++)
			for(int j=i-1; j<=i+1; j++)
			{
				if(j<=blueCount && j>=0)
				{
					int res=i*redHeight + j*blueHeight;
					if(!total.contains(res)) total.add(res);
					System.out.println(res);
				}

			}
		return total.size()-1;
	}
	public static void main(String args[])
	{
		System.out.println(find(4,4,4,7));
	}
}