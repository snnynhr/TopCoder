
public class BlackAndWhiteSolitaire
{
	public static int minimumTurns(String cardFront)
	{
		int mina=0, minb = 0;
		for(int i=0; i<cardFront.length(); i++)
		{
			if(i%2==0 && cardFront.charAt(i)=='B') mina++;
			else if(i%2==1 && cardFront.charAt(i)=='W') mina++;
		}
		for(int i=0; i<cardFront.length(); i++)
		{
			if(i%2==0 && cardFront.charAt(i)=='W') minb++;
			else if(i%2==1 && cardFront.charAt(i)=='B') minb++;
		}
		return Math.min(mina, minb);
	}
	public static void main(String args[])
	{
		System.out.println(minimumTurns("BWBWB"));
	}
}