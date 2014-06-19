import java.util.ArrayList;
import java.util.Arrays;

public class EelAndRabbit
{
	static int T = 0;
	public static int getmax(int[] l, int[] t)
	{
		int[] init = new int[l.length];
		int[] fin = new int[l.length];
		int[] index = new int[l.length];
		for(int i=0; i<l.length; i++)
		{
			init[i] = T-t[i]-l[i];
			fin[i] = T - t[i];
			index[i] = i;
		}
		linkedInsertionSort(init, fin);
		System.out.println(Arrays.toString(init));
		System.out.println(Arrays.toString(fin));

		return countMax(init,fin);
	}
	public static int countMax(int[] init, int[] fin)
	{
		int MAX = 1;
		boolean[] d = new boolean[init.length];
		int max = 1;
		int curr=1;
		ArrayList<Integer> end = new ArrayList<Integer>();
		end.add(fin[0]);
		d[0] = true;
		for(int i=1; i<init.length; i++)
		{
			//int rc=0;
			for(int j=0; j<end.size(); j++)
			{
				if(d[j] && init[i]>end.get(j)) 
				{
					//rc++;
					d[j] = false;
					curr--;
				}
			}
			//curr-=rc;
			curr+=1;
			d[i] = true;
			max = Math.max(max,curr);
			//curr+=rc;
			//System.out.println(Arrays.toString(d));
			end.add(fin[i]);
			
			//
			System.out.println(max+" "+countMax1(init, fin,d,max));
			MAX = Math.max(MAX, max+countMax1(init, fin,d,max));
			//
			
		}
		return MAX;
	}
	public static int countMax1(int[] initt, int[] finn, boolean[] dd, int mm)
	{
		
		int ll = initt.length - mm;
		if(ll==0) return 0;
		ArrayList<Integer> inittt = new ArrayList<Integer>();
		ArrayList<Integer> finnn = new ArrayList<Integer>();
		for(int i=0; i<initt.length; i++)
		{
			if(!dd[i])
			{
				inittt.add(initt[i]);
				finnn.add(finn[i]);
			}
		}
		int[] init = new int[inittt.size()];
		int[] fin = new int[finnn.size()];
		for(int i=0; i<init.length; i++)
		{
			init[i] = inittt.get(i);
			fin[i] = finnn.get(i);
		}
		boolean[] d = new boolean[init.length];
		int max = 1;
		int curr=1;
		ArrayList<Integer> end = new ArrayList<Integer>();
		end.add(fin[0]);
		d[0] = true;
		for(int i=1; i<init.length; i++)
		{
			//int rc=0;
			for(int j=0; j<end.size(); j++)
			{
				if(d[j] && init[i]>end.get(j)) 
				{
					//rc++;
					d[j] = false;
					curr--;
				}
			}
			//curr-=rc;
			curr+=1;
			d[i] = true;
			max = Math.max(max,curr);
			//curr+=rc;
			//System.out.println(Arrays.toString(d));
			end.add(fin[i]);
		}
		return max;
	}
	public static void linkedInsertionSort(int[] arr, int[] link) {
		int i, j, curr,c;
		for (i = 1; i < arr.length; i++) 
		{
			curr = arr[i];
			c = link[i];
			j = i;
			while (j > 0 && arr[j - 1] > curr) 
			{
				arr[j] = arr[j - 1];
				link[j]=link[j-1];
				j--;
			}
			arr[j] = curr;
			link[j]= c;
		}
	}
	public static void main(String args[])
	{
		int[] a = {8, 2, 1, 10, 8, 6, 3, 1, 2, 5}
		;
		int[] b = {17, 27, 26, 11, 1, 27, 23, 12, 11, 13};
		System.out.println(getmax(a, b));
	}
}