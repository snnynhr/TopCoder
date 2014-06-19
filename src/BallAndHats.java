
public class BallAndHats
{
	public int getHat(String hats, int numSwaps)
	{
		if(hats.equals(".o."))
		{
			if(numSwaps==0) return 1;
			else if(numSwaps%2==0) return 1;
			return 0;
		}
		else if(hats.equals("..o"))
		{
			if(numSwaps==0) return 2;
			else if(numSwaps%2==1) return 1;
			return 0;
		}
		else if(hats.equals("o.."))
		{
			if(numSwaps==0) return 0;
			else if(numSwaps%2==1) return 1;
			return 0;
		}
		return 0;
	}
}
//Powered by [KawigiEdit] 2.0!