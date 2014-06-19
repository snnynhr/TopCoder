
public class FoxAndIntegers
{
	int[] empty = new int[0];
	int[] sol = new int[3];
	public int[] get(int AminusB, int BminusC, int AplusB, int BplusC)
	{
		double A=(AminusB+AplusB)/2.0;
		double B=(BminusC+BplusC)/2.0;
		double C=(BplusC-B);
		System.out.println(A+" "+B+" "+C);
		int iA = (int)A;
		int iB = (int)B;
		int iC = (int)C;
		if(A!=iA) return empty;
		if(B!=iB) return empty;
		if(C!=iC) return empty;
		if((iA-iB)!=AminusB) return empty;
		if((iB-iC)!=BminusC) return empty;
		if((iA-iB)!=AminusB) return empty;
		if((iA-iB)!=AminusB) return empty;
		sol[0]=iA;
		sol[1]=iB;
		sol[2]=iC;
		return sol;
	}
	
}