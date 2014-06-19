import java.util.ArrayList;
import java.util.Arrays;

public class SurveillanceSystem
{
	public static String getContainerInfo(String containers, int[] reports, int L)
	{

		Arrays.sort(reports);
		int[] numocc = new int[containers.length()-L+1];
		for(int i=0; i<numocc.length; i++)
		{
			numocc[i] = countOcc(containers,i,i+L-1);
		}
		char[] res = new char[containers.length()];
		for(int i=0; i<res.length; i++)
			res[i] = '-';
		int[] repo = new int[L+1];
		for(int i=0; i<reports.length; i++)
			repo[reports[i]]++;
		for(int i=0; i<repo.length; i++)
		{
			ArrayList<Integer> ind = new ArrayList<Integer>();
			for(int j=0; j<numocc.length; j++)
			{
				if(numocc[j]==i) ind.add(j);
			}
			if(ind.size()==repo[i])
			{
				for(int j=0; j<ind.size(); j++)
				{
					int s = ind.get(j);
					for(int k=0; k<L; k++)
						res[k+s]='+';
				}
			}
			else
			{
				int LL = ind.size();
				System.out.println(LL);
				for(int j=0; j<LL; j++)
				{
					int s = ind.get(j);
					for(int k=0; k<L; k++)
						if(res[k+s]=='-') res[k+s]='?';
				}
				int[][] g = new int[LL][containers.length()];
				for(int j=0; j<LL; j++)
				{
					/*ArrayList<Integer> inds = new ArrayList<Integer>();*/
					
					for(int k=0; k<repo[i]; k++)
					{
						for(int m=0; m<L; m++)
							g[j][ind.get((j+k)%LL)+m]=1;
						//FIND INTERSECTION
					}
					//for(int x=0; x<g.length; x++)
						//System.out.println(i+":"+Arrays.toString(g[x]));
					//System.out.println(g.length);
					for(int k=0; k<g[0].length; k++)
					{
						
						boolean d = true;
						for(int l=0; l<LL; l++)
						{
							if(g[l][k]==0) 
							{
								d = false;
								break;
							}
						}
						if(d) res[k] = '+';
					}
				}
			}
			System.out.println(Arrays.toString(res));
		}
		String r = "";
		for(int i=0; i<res.length; i++)
			r+=res[i];
		return r;
	}
	public static int countOcc(String s, int l, int r)
	{
		int c=0;
		for(int i=l; i<=r; i++)
		{
			if(s.charAt(i)=='X') c++;
		}
		return c;
	}
	public static void main(String args[])
	{
		System.out.println(getContainerInfo("-XX--X-XX-X-X--X---XX-X---XXXX-----X", new int[] {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 7));
	}
}