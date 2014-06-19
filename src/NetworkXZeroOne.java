
public class NetworkXZeroOne {
	public String reconstruct(String message)
	{
		//String newstring=message;
		for(int i=0; i<message.length(); i++)
		{
			if(message.charAt(i)=='?')
			{
				int numx =countx(message.substring(0, i));
				int numo =counto(message.substring(0, i));
				if(numo<=numx) message= message.substring(0,i)+"o"+message.substring(i+1);
				else message= message.substring(0,i)+"x"+message.substring(i+1);
			}
			
			
		}
		return message;
	}
	public int countx(String s)
	{
		int count=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='x') count++;
		}
		return count;
	}
	public int counto(String s)
	{
		int count=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='o') count++;
		}
		return count;
	}
	public int countq(String s)
	{
		int count=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='?') count++;
		}
		return count;
	}
	

	
	
}
