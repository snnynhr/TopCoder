import java.util.Arrays;


public class DropCoins {

	int[] master=new int[50];
	int index=0;
	public int countAll(String[] b)
	{
		int count = 0;
		for(int i=0; i<b.length; i++)
		{
			for(int j=0; j<b[0].length(); j++)
			{
				if(b[i].charAt(j)=='o') count++;
			}
		}
		return count;
	}
	public int getMinimum(String[] board, int K)
	{
		System.out.println(countAll(board));
		i(board,countAll(board)-K,0);
		Arrays.sort(master);
		int a=0;
		System.out.println(Arrays.toString(master));
		while(master[a]==0)
		{
			a++;
		}
		return master[a];
	}
	public int getNum(String s)
	{
		int count=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='o') count++;
		}
		return count;
	}
	public int numPos(String[] b, int i)
	{
		if(b==null) return 0;
		if(i==0)
		{
			return getNum(b[0]);
		}
		else if(i==1)
		{
		    return getNum(b[b.length-1]);
		}
		else if(i==2)
		{
			String t="";
			for(int j=0; j<b.length; j++)
			{
				t+=b[j].charAt(0);
			}
			return getNum(t);
		}
		else if(i==3)
		{
			String t="";
			for(int j=0; j<b.length; j++)
			{
				t+=b[j].charAt(b[j].length()-1);
			}
			return getNum(t);
		}
		return 0;
	}
	public void i(String[] b, int K, int it)
	{
		boolean ok=true;
		if(K==0)
		{
			if(!(contains(it,master)))
			{
			master[index]=it;
			index++;
			ok=false;
			}
		}
		else if(K<0) ok=false;
		else if(countAll(b)==0) ok=false;
		if(ok)
		{
		i(rS(b,0),K-numPos(b,0),it+1);
		i(rS(b,1),K-numPos(b,1),it+1);
		i(rS(b,2),K-numPos(b,2),it+1);
		i(rS(b,3),K-numPos(b,3),it+1);
		}
	}
	public String[] rS(String[] b,int i)
	{
	    if(b==null) return null;
		String temp[] = null;
	 	if(i==0)
	 	{
	 		temp=new String[b.length];
	 		for(int j=1; j<b.length; j++)
	 		{
	 			temp[j-1]=b[j];
	 		}
	 		String s="";
	 		for(int j=0; j<b[0].length(); j++)
	 		{
	 			s+='.';
	 		}
	 		temp[b.length-1]=s;
	 	}
	 	else if(i==1)
	 	{
	 		temp=new String[b.length];
	 	    for(int j=0; j<b.length-1; j++)
	 	    {
	 	    	temp[j+1]=b[j];
	 	    }
	 	    String s="";
	 	    for(int j=0; j<b[0].length(); j++)
	 		{
	 			s+=".";
	 		}
	 		temp[0]=s;
	 	}
	 	else if(i==2)
	 	{
	 	    temp=new String[b.length];
	 	    for(int j=0; j<b.length; j++)
	 	    {
	 	    	temp[j]="."+b[j].substring(0,b[j].length()-1);
	 	    }
	 	    
	 	}
	 	else if(i==3)
	 	{
	 		temp=new String[b.length];
	 		for(int j=0; j<b.length; j++)
	 		{
	 			temp[j]=b[j].substring(1,b[j].length())+".";
	 		}
	 	}
	 	return temp;
	}
	public boolean contains(int element, int[] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]==element) return true;
		}
		return false;
	}
}