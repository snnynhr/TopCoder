
public class PairingPawns {
	public int savedPawnCount(int[] start)
	{
		int s=start.length-1;
		for(int i=s; i>0; i--)
		{
			start[i-1]+=start[i]/2;
		}
		return start[0];
	}
}
