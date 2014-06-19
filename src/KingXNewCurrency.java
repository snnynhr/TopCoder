public class KingXNewCurrency
{
	public int howMany(int A, int B, int X)
	{
		int C=A%X;
		int D=B%X;
		if(A % X==0 && B%X==0) return -1;
		boolean b = true;
		int count=0;
		int[] ok = new int[(int)Math.max(A, B)];
		for(int k=1; k<=Math.max(A, B); k++)
		{
			b=true;
			for(int x=0; x<=200; x++)
			{
				for(int y=0; y<=200; y++)
				{
					if(!((A*x+B*y)/k == (A*x+B*y)/(double)k))
						b=false;
				}
			}
			if(b) ok[k-1]=1;
			b=true;
			for(int x=0; x<=200; x++)
			{
				for(int y=0; y<=200; y++)
				{
					if(!((C*x+B*y)/k == (C*x+B*y)/(double)k))
						b=false;
				}
			}
			if(b) ok[k-1]=1;
			b=true;
			for(int x=0; x<=200; x++)
			{
				for(int y=0; y<=200; y++)
				{
					if(!((A*x+D*y)/k == (A*x+D*y)/(double)k))
						b=false;
				}
			}
			if(b) ok[k-1]=1;
		}
		for(int i=0; i<ok.length; i++)
		{
			System.out.println(i+" "+ok[i]);
			if(ok[i]==1) count++;
		}
		return count;
	}
	public int howManys(int A, int B, int X)
	{
		if(A % X==0 && B%X==0) return -1;
		boolean b = true;
		int count=0;
		int[] ok = new int[(int)Math.max(A, B)];
		for(int k=0; k<=Math.min(A, B); k++)
		{
			b=true;
			for(int x=0; x<=200; x++)
			{
				for(int y=0; y<=200; y++)
				{
					int K=gcf(X,k);
					if(((A*x+B*y)/K != (A*x+B*y)/(double)K))
						b=false;
				}
			}
			if(b) ok[k]=1;
		}
		for(int i=0; i<ok.length; i++)
		{
			System.out.println(i+" "+ok[i]);
			if(ok[i]==1) count++;
		}
		return count;
	}
	public static int gcf(int u, int v) {
		int gcd = 0;
		u = Math.abs (u);
		v = Math.abs (v);
		if (v == 0) {
			gcd = u;
		}
		else {
			gcd = gcf(v, u % v);
		}
		return gcd;

	}

}