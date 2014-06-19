import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CucumberMarket
{
	public String check(int[] price, int budget, int k)
	{
		Arrays.sort(price);
		ArrayList<Integer> x = new ArrayList<Integer>();
		for(int i=0; i<price.length; i++)
		{
			x.add(price[i]);
		}
		Collections.sort(x);
		Collections.reverse(x);
		int sum=0;
		for(int i=0; i<k; i++)
		{
			sum+=x.get(i);
		}
		if(sum<=budget) return "YES";
		else return "NO";
	}
}