
import java.util.Arrays;


public class MarbleDecoration {
	public int maxLength(int R, int G, int B)
	{
		int[] collection = {R,G,B};
		Arrays.sort(collection);
		
			int a=collection[2];
			              int b=collection[1];
			int diff=a-b;
		if(a>b)
		
		return collection[2]+collection[1]-diff+1;
		else return a+b;
	}
}
