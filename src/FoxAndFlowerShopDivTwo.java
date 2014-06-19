
public class FoxAndFlowerShopDivTwo
{
	public int theMaxFlowers(String[] flowers, int r, int c)
	{
		int max=0;
		int top = 0,bottom=0,left=0,right=0;
		for(int i=0; i<r; i++)
			for(int j=0; j<flowers[i].length(); j++)
				if(flowers[i].charAt(j)=='F') top++;
		for(int i=r+1; i<flowers.length; i++)
			for(int j=0; j<flowers[i].length(); j++)
				if(flowers[i].charAt(j)=='F') bottom++;
		for(int i=0; i<flowers.length; i++)
			for(int j=0; j<c; j++)
				if(flowers[i].charAt(j)=='F') left++;
		for(int i=0; i<flowers.length; i++)
			for(int j=c+1; j<flowers[i].length(); j++)
				if(flowers[i].charAt(j)=='F') right++;
		max=Math.max(max,top);
		max=Math.max(max,bottom);
		max=Math.max(max,left);
		max=Math.max(max,right);
		return max;
	}
}	
	