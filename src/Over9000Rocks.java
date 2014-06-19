import java.util.ArrayList;
import java.util.Arrays;

public class Over9000Rocks
{
	public int countPossibilities(int[] lowerBound, int[] upperBound)
	{
		int size = lowerBound.length;
		int iter = (int)Math.pow(2, size);
		int combinations = 0;
		int[] mins;
		int[] maxs;
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i=0; i<iter; i++)
		{
			String s = Integer.toBinaryString(i);
			s = "00000000000000000000".substring(0,size-s.length())+s;
			//System.out.println(s);
			int mincount=0;
			int maxcount=0;
			for(int j=0; j<s.length(); j++)
			{
				if(s.charAt(j)=='1') 
				{
					mincount+=lowerBound[j];
					maxcount+=upperBound[j];
				}
			}
			if(mincount>9000) {a.add(mincount); b.add(maxcount);}
			else if(maxcount>9000) {a.add(9001); b.add(maxcount);}
		}
		mins = new int[a.size()];
		maxs = new int[b.size()];
		for(int i=0; i<a.size(); i++)
		{
			mins[i]=a.get(i);
			maxs[i]=b.get(i);
		}
		if(a.size()==0) return 0;
		linkedsort(mins, maxs);
		System.out.println(Arrays.toString(mins));
		System.out.println(Arrays.toString(maxs));
		
		int start=mins[0];
		int end=maxs[0];
		for(int i=0; i<mins.length; i++)
		{
			while(i<mins.length && end>mins[i]) {
				end = Math.max(end, maxs[i]);
				i++;
			}
			//System.out.println(start+"--"+end);
			combinations+=end-start+1;
			if(i<mins.length)
			{
				start=mins[i];
				end = maxs[i];
			}
		}
		return combinations;
	}
	public static void linkedsort(int[] x,int[] link) {
		for (int i=0; i<x.length-1; i++) {
			int minIndex = i;      // Index of smallest remaining value.
			for (int j=i+1; j<x.length; j++) {
				if (x[minIndex] > x[j]) {
					minIndex = j;  // Remember index of new minimum
				}
			}
			if (minIndex != i) { 
				//...  Exchange current element with smallest remaining.
				int temp = x[i];
				x[i] = x[minIndex];
				x[minIndex] = temp;
				int tem  = link[i];
				link[i]=link[minIndex];
				link[minIndex]=tem;
			}
		}
	}
}