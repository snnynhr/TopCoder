public class MinCostPalindrome
{
	public int getMinimum(String s, int oCost, int xCost)
	{
		int cost=0;
		for(int i=0; i<s.length()/2; i++)
		{
			char a =s.charAt(i);
			char b =s.charAt(s.length()-i-1);
			if((a=='o' && b =='?' )||( b=='o'&& a=='?')) cost+=oCost;
			else if((a=='x' && b =='?' )||( b=='x'&& a=='?')) cost+=xCost;
			else if(b =='?' && a=='?') cost+=2*Math.min(xCost,oCost);
			else if(b!=a) return -1;
		}
		return cost;
	}
	
}