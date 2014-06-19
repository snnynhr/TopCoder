import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class MultiplesWithLimit
{
	static int F;
	static int[] valid;
	static Queue<String> BFS= new LinkedList<String>();
	ArrayList<Integer> done = new ArrayList<Integer>();
	public String minMultiples(int N, int[] forbiddenDigits)
	{
		F=N;
		if(forbiddenDigits.length==10) return "IMPOSSIBLE";
		valid = new int[10-forbiddenDigits.length];
		boolean[] not = new boolean[10];
		Arrays.sort(forbiddenDigits);
		for(int i=0; i<forbiddenDigits.length; i++)
			not[forbiddenDigits[i]]=true;
		int j=0;
		for(int i=0; i<10; i++)
			if(!not[i]) 
			{
				valid[j]=i;
				j++;
			}
		for(int k=0; k<valid.length; k++)
			BFS.add(valid[k]+"");
		bfs();
		if(done.size()==0) return "IMPOSSIBLE";
		String p=done.get(0)+"";
		if(p.length()<9) return p;
		return p.substring(0,3)+"..."+p.substring(p.length()-3)+"("+p.length()+ " digits)";
	}
	public void bfs()
	{
		while(!BFS.isEmpty())
		{
			String s=BFS.poll();
			System.out.println(s);
			if(s.length()<=9)
			{
				int x = Integer.parseInt(s);
				if(x%F==0 && x>=F) 
				{
					done.add(x);
					return;
				}
				for(int i=0; i<valid.length; i++)
					BFS.add(s+valid[i]);
			}
		}
	}
}