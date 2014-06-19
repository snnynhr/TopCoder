import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UndoHistory
{
	static String master;
	static String maxS;
	static int keyP;
	static ArrayList<String> undos;
	public static int minPresses(String[] lines)
	{
		String buffer;
		undos = new ArrayList<String>();
		int minP = 0;
		minP += 1 + lines[0].length();
		for(int i=1; i<=lines[0].length(); i++)
			undos.add(lines[0].substring(0,i));
		buffer = lines[0];
		System.out.println(minP);
		for(int i=1; i<lines.length; i++)
		{
			int res = bfsI(lines[i]);
			if(buffer.equals(lines[i])) minP+=1;
			else
			{
				if(res==-1)
				{
					minP+= 2 + 1 + lines[i].length();
					for(int j=1; j<=lines[i].length(); j++)
						undos.add(lines[i].substring(0,j));
				}
				else
				{
					minP+=lines[i].length()-res + 1;
					for(int j=res+1; j<=lines[i].length(); j++)
						undos.add(lines[i].substring(0,j));
				}
			}
			buffer = lines[i];
			//for(int j=1; j<=lines[i].length(); j++)
			//	undos.add(lines[i].substring(0,j));
			System.out.println(minP);
		}
		return minP;
	}

	public static int bfsI(String s)
	{
		Comparator<String> c = Collections.reverseOrder();
		Collections.sort(undos, c);
		int max = -1;
		int ss = s.length();
		for(int i=0; i<undos.size(); i++)
		{
			int ll = undos.get(i).length();
			if(ll<=ss)
			{
				if(s.substring(0,ll).equals(undos.get(i)))
				{
					max = ll;
					break;
				}
			}
		}
		return max;
	}
	/*
	public static void bfs(String s, int d)
	{
		keyP = Math.min(keyP, s.length()+2*d);

		int ss = s.length();
		for(int i=0; i<undos.size(); i++)
		{
			int ll = undos.get(i).length();
			if(ll<=ss)
			{
				if(s.substring(0,ll).equals(undos.get(i)))
				{
					bfs(s.substring(ll),d+1);
				}
			}
		}
	}*/
	public static void main(String args[])
	{
		System.out.println(minPresses(new String[] {"ba","a","a","b","ba"}));
	}

}