public class GameOfLifeDiv2 {
	public String theSimulation(String init, int T)
	{
		for(int i =0; i<T; i++)
		{
			init=update(init);
		}
		return init;
	}
	public String update(String s)
	{	
		String n = "";
		for(int i=0; i<s.length(); i++)
		{
			n=n+check(s,i);
		}
		return n;
	}
	public int check(String s,int i)
	{
		if(i==0)  return num(s,0,1,s.length()-1);
		else if(i==s.length()-1) return num(s,s.length()-2,s.length()-1,0);
		return num(s,i-1,i,i+1);
		
	}
	public int num(String s,int i,int j,int k)
	{
		int m=0;
		if(s.charAt(i)=='0') m++; 
		if(s.charAt(j)=='0') m++; 
		if(s.charAt(k)=='0') m++; 
		if(m >=2) return 0;
		else return 1;
	}
}