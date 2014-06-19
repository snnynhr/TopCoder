
public class TypingDistance
{
	public int minDistance(String keyboard, String word)
	{
		int res = 0;
		//int index = keyboard.indexOf(word.charAt(0));
		for(int i=1; i<word.length(); i++)
		{
			int j = Math.abs(keyboard.indexOf(word.charAt(i))-keyboard.indexOf(word.charAt(i-1)));
			res+=j;
		}
		return res;
	}
	
}