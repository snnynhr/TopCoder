import java.util.ArrayList;
import java.util.Collections;

public class SafeRemoval
{
	static ArrayList<Integer> res0 = new ArrayList<Integer>();
	static ArrayList<Integer> res1 = new ArrayList<Integer>();
	static ArrayList<Integer> res2 = new ArrayList<Integer>();
	static ArrayList<Integer> res3 = new ArrayList<Integer>();
	static ArrayList<Integer> res;
	static int sum=0;
	public static int removeThem(int[] seq, int k)
	{
		for(int i=0; i<seq.length; i++)
		{
			sum+=seq[i];
			if(seq[i]%4==0)
				res0.add(seq[i]);
			else if(seq[i]%4==1)
				res1.add(seq[i]);
			else if(seq[i]%4==2)
				res2.add(seq[i]);
			else if(seq[i]%4==3)
				res3.add(seq[i]);
		}
		Collections.sort(res0);	Collections.sort(res1);	Collections.sort(res2);	Collections.sort(res3);
		for(int i=0; i<k; i++)
		{
			res = new ArrayList<Integer>();
			ArrayList<Integer> ok = new ArrayList<Integer>();
			if(res0.size()>0)
				res.add(res0.get(0));
			if(res1.size()>0)
				res.add(res1.get(0));
			if(res2.size()>0)
				res.add(res2.get(0));
			if(res3.size()>0)
				res.add(res3.get(0));
			for(int j=0; j<res.size(); j++)
			{
				if((sum-res.get(j))%4!=0) ok.add(res.get(j));
			}
			if(ok.size()==0) return -1;
			else
			{
				Collections.sort(ok);
				int a =ok.get(0);
				sum-=a;
				if(a%4==0) res0.remove(0);
				else if (a%4==1) res1.remove(0);
				else if (a%4==2) res2.remove(0);
				else if (a%4==3) res3.remove(0);
			}
		}
		return sum;
	}
	public static void main(String args[])
	{
		int[] ab={1,1,1,1,1,1,1,1,7};
		System.out.println(removeThem(ab, 3));
	}
}