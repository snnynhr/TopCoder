
public class BinaryCards {

	public long largestNumber(long A, long B)
	{
		if(A==B) return A;
		double z = Math.log10(B)/Math.log(2);
		if( ((int)(Math.pow(2, z))) == B) return 2*B-1;
		int highestPow=(int)Math.pow(2, z);
		if(highestPow>=A) return 2*B-1;
		else 
		{
			if(B%2==1) return B;
			else if(B%2==0) return B+1;
		}
		return 0;
	}
}
