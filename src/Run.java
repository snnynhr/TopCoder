import java.util.Arrays;

public class Run {
	public static void main(String args[])
	{
		int[] e=new int[50];
		for(int i=0; i<50; i++)
			e[i]=(int)(Math.random()*1000);
		System.out.println(Arrays.toString(e));
		Cut x = new Cut();
		long time=System.currentTimeMillis();
		System.out.println(x.getMaximum(e, 20)+": "+(System.currentTimeMillis()-time));
		
	}
}
