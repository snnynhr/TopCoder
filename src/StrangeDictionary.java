import java.util.Arrays;


public class StrangeDictionary
{
	static int L;
	public double[] getExpectedPositions(String[] words)
	{
		String[] abc = {"aza","aab","bba"};
		L=words[0].length();
		int[] q = {1,0,2};
		int[] r = {0,0,0};
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				r[i]+=compare(abc[i],abc[j],q);
			}
		}
		System.out.println(Arrays.toString(r));
		return null;
	}
	public int compare(String A, String B, int[] p)
	{
		for(int i=0; i<L; i++)
		{
			char a = A.charAt(p[i]);
			char b = B.charAt(p[i]);
			if(a<b) return -1;
			if(b<a) return 1;
		}
		return 0;
	}
	public void evaluate(String[] words)
	{
		double[] p = new double[words.length];
		for(int i=0; i<words.length; i++)
		{
			for(int j=0; j<words.length; j++)
			{
				if(i!=j)
				{
					double sum=0;
					double d=0;
					for(int k=0; k<words[i].length(); k++)
					{
						if(words[i].charAt(k)==words[j].charAt(k)) continue;
						d++;					
						if(words[i].charAt(k)<words[j].charAt(k)) sum+=1;

						//else if(words[i].charAt(k)>words[j].charAt(k)) p[i]+=1;
					}
					p[i]+=sum/d;
				}
			}
		}
		System.out.println(Arrays.toString(p));
	}
}