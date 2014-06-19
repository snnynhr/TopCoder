import java.util.Arrays;
import java.util.Stack;

public class Suminator
{
	static Stack<Long> s = new Stack<Long>();
	static String curr;
	public static int findMissing(int[] program, int wantedResult)
	{
		int[] p = program.clone();
		for(int i=0; i<p.length; i++)
			if(p[i]==-1)
			{
				p[i]=0; break;
			}
		System.out.println(Arrays.toString(p));
		for(int i = 0; i< p.length; i++) {
			if (p[i]==0) 
			{
				long a,b;
				if(s.size()>0)
					a =s.pop();
				else a=0;
				if(s.size()>0)
					b = s.pop();
				else b=0;
				s.push(a+b);
			} 
			else {
				s.push((long)p[i]);
			}
		}
		if(s.size()>0)
		{
			long reswith0=s.pop();
			System.out.println(reswith0);
			if(wantedResult==reswith0) return 0;
		}
		int index=0;
		int index2=0;
		s = new Stack<Long>();
		for(int i = 0; i< program.length; i++) 
		{
			if (program[i]==0) {
				index--;
				long a,b;
				if(s.size()>0)
					a =s.pop();
				else a=0;
				if(s.size()>0)
					b = s.pop();
				else b=0;
				s.push(a+b);
			}
			else if(program[i]==-1) 
			{
				s.push(0l);
				index+=s.size();
			}
			else 
			{
				s.push((long)program[i]);
			}
		}
		index2=s.size();
		long res=s.pop();
		long res1=wantedResult-res;
		System.out.println(index2 + ", "+ index);
		System.out.println(res1);
		if(index2>index && res == wantedResult) 
		{
			System.out.println("0result");
			return 0; //0result
		}
		if(index2>index && res != wantedResult) 
		{
			System.out.println("2>1 -1 result");
			return -1;
		}
		if(res1<=0) return -1; 
		else return (int)res1;
	}
	public static void main( String args[])
	{
		int[] a ={808312155, 85035091, -1};
		System.out.println(findMissing(a, 893347246));
	}
}