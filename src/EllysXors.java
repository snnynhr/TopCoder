
public class EllysXors
{
	public long getXor(long L, long R)
	{
		if(L%2==1)
		{
			if((R-L)%4==3) return R^L-1;
			else if((R-L)%4==1) return R^L;
			else if((R-L)%4==2) return L-1;
			else if((R-L)%4==0) return L;
		}
		else
		{
			if((R-L)%4==3) return 0;
			else if((R-L)%4==1) return 1;
			else if((R-L)%4==2) return R+1;
			else if((R-L)%4==0) return R;
		}
		return R;
	}
}