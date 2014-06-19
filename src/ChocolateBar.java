
public class ChocolateBar
{

	public static int maxLength(String letters)
	{
		int maxLength = 0;
		for(int i=0; i<letters.length(); i++)
		{
			boolean[] found = new boolean[26];
			boolean broke=false;
			for(int j=0; i+j<letters.length(); j++)
			{
				if(!found[letters.charAt(i+j)-97])
				{
					found[letters.charAt(i+j)-97]=true;
				}
				else
				{
					maxLength = Math.max(maxLength,j);
					broke = true;
					break;
				}
			}
			if(!broke)
				maxLength = Math.max(maxLength,letters.length()-i);
		}
		return maxLength;
	}
	public static void main(String args[])
	{
		System.out.println(maxLength("srm"));
	}
}
//Powered by [KawigiEdit] 2.0!