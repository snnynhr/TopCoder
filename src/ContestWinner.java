import java.util.ArrayList;

public class ContestWinner
{
	ArrayList<Integer> x = new ArrayList<Integer>();
	int[] scores;
	int index=0;
	public int getWinner(int[] events)
	{
		for(int i=0; i<events.length; i++)
		{
			if(!x.contains(events[i])) x.add(events[i]);
		}
		scores = new int[x.size()];
		
		int winner = x.get(0);
		for(int i=0; i<events.length; i++)
		{
			scores[x.indexOf(events[i])]++;
			winner = x.get(winner(scores,index));
			System.out.println(winner);
		}
		return winner;
	}
	public int winner(int[] a, int max)
	{
		for(int i=0; i<a.length; i++)
		{
			if(a[max]<a[i]) max=i;
		}
		index=max;
		return max;
	}
}