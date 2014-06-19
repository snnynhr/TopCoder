import java.util.Arrays;

public class Zoo {
	public static long theCount(int[] answers)
	{
		Arrays.sort(answers);
		int max=answers[answers.length-1];
		int[] check = new int[max+1];
		for(int i=0; i<max+1; i++)
			check[i]=num(answers,i);
		for(int i=0; i<check.length; i++) System.out.print(check[i]+"\t");
		for(int i=0; i<=check.length-2; i++)
			if( (check[i]<check[i+1]) || (check[i]>2) ) return 0;
		return res(check);

	}	
	public static  int num(int[] arr, int i)
	{
		int c=0;
		for(int a=0; a<arr.length; a++)
			if(arr[a] == i) c++;
		return c;
	}
	public static int res(int[] arr)
	{
		int p=1;
		for(int i=0; i<arr.length; i++)
			p=p*arr[i];
		return p*2;
	}
	public static void main(String args[])
	{
		int[] a = {0,1,2,3,4};
		System.out.println("\t\t"+theCount(a));
	}
}