
public class FoxAndHandleEasy
{
	public static String isPossible(String S, String T)
	{
		String comp;
		for(int i=0; i<S.length(); i++)
		{
			comp = S.substring(0,i)+S+S.substring(i);
			if(comp.equals(T)) return "Yes";
		}
		return "No";
	}
	public static String issPossible(String S, String T)
	{
		System.out.println(T.replaceFirst(S,""));
		if(T.replaceFirst(S,"").equals(S))
			return "Yes";
		return "No";
	}
	public static void main(String args[])
	{
		System.out.println(isPossible("ABA", "ABABAA"));
		System.out.println(issPossible("ABA", "ABABAA"));
	}
}