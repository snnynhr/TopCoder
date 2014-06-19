
public class PlatypusPaternity
{
	public int maxFamily(String[] femaleCompatibility, String[] maleCompatibility, String[] siblingGroups)
	{
		int max=0;
		for(int a=0; a<femaleCompatibility.length; a++)
		{
			for(int b=0; b<maleCompatibility.length; b++)
			{
				for(int i=0; i<siblingGroups.length; i++)
				{
					int count=0;
					boolean ok=true;
					for(int j=0; j<siblingGroups[i].length(); j++)
					{
						if(siblingGroups[i].charAt(j)=='Y'&&femaleCompatibility[a].charAt(j)=='Y' && maleCompatibility[b].charAt(j)=='Y')
						{
							count++;
						}
						if(siblingGroups[i].charAt(j)=='Y' && (femaleCompatibility[a].charAt(j)!='Y'|| maleCompatibility[b].charAt(j)!='Y'))
						{
							ok = false;	
						}
					}
					if(ok) max=Math.max(max,count);
				}
			}
		}
		if(max!=0) max+=2; return max;
	}
}