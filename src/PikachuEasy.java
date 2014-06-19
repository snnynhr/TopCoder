public class PikachuEasy
{
	public String check(String word)
	{
		while(word.length()>=2)
		{
			if(word.startsWith("pi")||word.startsWith("ka")) word=word.substring(2);
			else if(word.startsWith("chu")) word=word.substring(3); 
			else return "NO";
		}
		if(word.length()==0) return "YES";
		if(word.length()==1) return "NO";
		if(word.length()==2)
		{
			if(word.equals("pi") || word.equals("ka")) return "YES";
			else return "NO";
		}
		if(word.length()==3)
		{
			if(word.equals("chu")) return "YES";
			else return "NO";
		}
		return "NO";
	}
}