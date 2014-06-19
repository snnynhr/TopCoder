import java.util.ArrayList;


public class NetworkXOneTimePad {
	public static ArrayList<String> keys = new ArrayList<String>(10);
	public int crack(String[] plaintexts, String[] ciphertexts)
	{
		for(int i=0; i<plaintexts.length; i++)
		{
			for(int j=0; j<ciphertexts.length; j++)
			{
				addnew(xor(plaintexts[i],ciphertexts[j]));
			}
		}
		return keys.size();
	}
	public void addnew(String z)
	{
		int flag=0;
		for(int i=0; i<keys.size(); i++)
		{
			if(z.equals(keys.get(i))) flag=1;
		}
		if(flag==0) keys.add(z);
	}
	public String xor(String a,String b)
	{
		String ret="";
		for(int i=0; i<a.length(); i++)
		{
			if(a.charAt(i)=='1' && b.charAt(i)=='1') ret+="0";
			else if(a.charAt(i)=='0' && b.charAt(i)=='0') ret+="0";
			else ret +="1";
		}
		return ret;
	}
	public void print()
	{
		for(int i=0; i<keys.size(); i++)
		{
			System.out.println(keys.get(i));
		}
	}
}
