import java.util.ArrayList;


public class NetworkXMessageRecovery {
	public String recover(String[] messages)
	{
		for(int i=0; i<messages.length-1; i++)
		{
			//String a = messages[i];
			//String b = messages[i+1];
			//ArrayList<String> compare =common(a,b);
			//
		}
		return "";
	}
	public ArrayList<String> common(String a,String b)
	{
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0; i<a.length(); i++)
		{
			if(b.contains(""+a.charAt(i))) res.add(""+b.charAt(i));
		}
		return res;
	}
	
}
