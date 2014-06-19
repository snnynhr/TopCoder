import java.util.Arrays;
public class TomekPhone
{
	public static int minKeystrokes(int[] occurences, int[] keySizes)
	{
		int size = occurences.length;
		int keysum=0;
		for(int i=0; i<keySizes.length; i++)
		{
			keysum+=keySizes[i];
		}
		if(keysum<size) return -1;
		selectionSort(occurences);
		Arrays.sort(keySizes);
		int[] s = new int[51];
		for(int i=1; i<51; i++)
			for(int j=0; j<keySizes.length; j++)
				if(keySizes[j]>=i) s[i]++;

		int sum=0;
		int z = size;
		int curr = 1;
		int cind = 0;
		while(z>0)
		{
			if(s[curr]>=z)
			{
				z=0;
				for(int i=cind; i<occurences.length; i++)
				{
					sum+= occurences[i]*curr;
				}
			}
			else
			{
				for(int i=cind; i<cind+s[curr]; i++)
				{
					sum+= occurences[i]*curr;
				}
				cind+=s[curr];
				z-=s[curr];
				curr++;
			}
		}
		return sum;
	}
	public static void main(String args[])
	{
		int[] a ={11,23,4,50,1000,7,18};
		int[] b = {3,1,4};
		System.out.println(minKeystrokes(a, b));
	}
	public static void selectionSort(int[] arr) {
	      int i, j, minIndex, tmp;
	      int n = arr.length;
	      for (i = 0; i < n - 1; i++) {
	            minIndex = i;
	            for (j = i + 1; j < n; j++)
	                  if (arr[j] > arr[minIndex])
	                        minIndex = j;
	            if (minIndex != i) {
	                  tmp = arr[i];
	                  arr[i] = arr[minIndex];
	                  arr[minIndex] = tmp;
	            }
	      }
	}
}