import java.util.ArrayList;


public class KingXNewBaby
{
	ArrayList<String> v = new ArrayList<String>();
	public String isValid(String name)
	{
		if(name.length()!=8) return "NO";
		for(int i=0; i<8; i++)
		{
			String s=name.substring(i,i+1);
			if(s.equals("a") || s.equals("e")||s.equals("i")||s.equals("o")||s.equals("u")) v.add(s);
		}
		if(v.size()!=2) return "NO";
		System.out.println("PASS");
		if(!(v.get(0).equals(v.get(1)))) return "NO";
		return "YES";
	}
	
}