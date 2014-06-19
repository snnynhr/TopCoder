
public class MinskyMysteryDiv2 {
	
	public long computeAnswer(long N)
	{
		if(N==0 || N==1) return -1;
		if(N%2==0) return N/2+2;
		if(N%6==3) return N/3+3;
		
		long[] bags = new long[5];
		bags[0]=N;
		bags[1]++;
		while(true)
		{
			//System.out.println(Arrays.toString(bags));
			bags[1]++;
			bags[4]=0;
			while(bags[0]>0)
			{
				while(bags[1]>0 && bags[0]>0)
				{
					bags[0]--;
					bags[1]--;
					bags[2]++;
					bags[3]++;
				}
				bags[4]++;
				if(bags[0]==0 && bags[1]==0)
				{
					bags[4]+=bags[3];
					bags[3]=0;
					return bags[4];
				}
				bags[1]+=bags[3];
				bags[3]=0;
			}
			bags[0]+=bags[2];
			bags[2]=0;
		}
	}
}
