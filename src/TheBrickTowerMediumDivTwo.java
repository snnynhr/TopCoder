import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class TheBrickTowerMediumDivTwo
{
	static ArrayList<String> mins = new ArrayList<String>();
	public static int[] find(int[] heights)
	{
		int minval=Integer.MAX_VALUE;
		for(int i=0; i<heights.length; i++)
		{
			int arr[]  = new int[heights.length-1];
			int ind[] = new int[heights.length-1];
			int count=0;
			for(int j=0; j<heights.length; j++)
			{
				if(i!=j)
				{
					arr[count]=heights[j];
					ind[count]=j;
					count++;
				}
			}
			linkedInsertionSort(arr, ind);
			int[] index = new int[heights.length];
			int[] array = new int[heights.length];
			index[0]=i;
			array[0]=heights[i];
			for(int k=1; k<heights.length; k++)
			{
				array[k]=arr[k-1];
				index[k]=ind[k-1];
			}
			int sum=0;
			for(int k=1; k<heights.length; k++)
			{
				sum+=Math.max(array[k],array[k-1]);
			}
			if(sum<minval)
			{
				minval=sum;
				mins = new ArrayList<String>();
				String res="";
				for(int l=0; l<index.length; l++)
					res = res + " "+index[l];
				mins.add(res.trim());
			}
			else if(sum==minval)
			{
				minval=sum;
				String res="";
				for(int l=0; l<index.length; l++)
					res = res + " "+index[l];
				mins.add(res.trim());
			}
		}
		Collections.sort(mins);
		for(int i=0; i<mins.size(); i++)
			System.out.println(mins.get(i));
		StringTokenizer st = new StringTokenizer(mins.get(0));
		int fin[] = new int[heights.length];
		for(int i=0; i<heights.length; i++)
			fin[i]=Integer.parseInt(st.nextToken());
		return fin;
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
}

