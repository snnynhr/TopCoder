
public class MysteriousRestaurant {
	public int maxDays(String[] prices, int budget)
	{
		
		if(prices.length<=7)
		{
			int days=0;
			int startPrice = smallestMultiPrice(prices, 0);
			if(budget<startPrice) return 0;
			else
			{
				budget-=startPrice;
				days++;
				while(budget>=smallestMultiPrice(prices,days))
				{
					budget-=smallestMultiPrice(prices,days);
					days++;	
				}
			}
			return days;
		}
		else{
			if(budget>smallestWeekPrice(prices, 0));
		}
		return 0;
	}
	public int getPrice(String a,int l)
	{
		int loc = (int)a.charAt(l);
		if (loc>97) return loc-98+36;
		else if(loc>64) return loc-65+10;
		else return loc-48;
	}
	public int smallestPrice(String[] prices, int loc)
	{
		String comp = prices[loc];
		int min = getPrice(comp, 0);
		for(int i=1; i<comp.length(); i++)
		{
			if(getPrice(comp,i)<min) min=getPrice(comp,i);
		}
		return min;
	}
	public int smallestMultiPrice(String[] prices, int loc)
	{
		
		int min = 0, tempmin=0;
		for(int i=loc; i<prices.length; i+=7)
		{
			min += getPrice(prices[i], 0);
		}
		
		for(int j=1; j<prices[loc].length(); j++)
		{
			for(int i=loc; i<prices.length; i+=7)
			{
				tempmin += getPrice(prices[i], j);
			}
			if(tempmin<min) min=tempmin;
		}
		return min;
	}
	public int smallestWeekPrice(String[] prices, int start)
	{
		int minweekprice=0;
		for(int i=start; i<start+7; i++)
		{
			minweekprice+=smallestPrice(prices, i);
		}
		return minweekprice;
			
	}
}
