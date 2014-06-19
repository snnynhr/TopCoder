
public class RowAndManyCoins {
	public String getWinner(String cells)
	{
		int x = cells.length();
		if(x==2)
		{
			if(cells.equals("BB")) return "Bob";
			else return "Alice";
		}
		else
		{
			if(cells.charAt(0)=='A') return "Alice";
			else return "Bob";
		}
	}
}
