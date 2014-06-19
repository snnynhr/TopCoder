
public class CorrectMultiplicationTwo {
	public int getMinimum(int a, int b, int c)
	{
		int min = 10000;
		return compute(a+1,b,c,a,b,c,min);
	}
	public int compute(int A, int B, int C, int a, int b, int c, int Min)
	{
		int tmp = Math.abs(A-a)+Math.abs(B-b)+Math.abs(C-c);
		if(tmp<Min)
		{
			Min=tmp;
			compute(A+1,B,(A+1)*B,a,b,c,Min);
			compute(A,B+1,(B+1)*A,a,b,c,Min);
			if(A-1>0) compute(A-1,B,(A-1)*B,a,b,c,Min);
			if(B-1>0) compute(A,B-1,A*(B-1),a,b,c,Min);
		}
		return Min;
	}
}
