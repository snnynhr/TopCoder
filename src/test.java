import java.util.StringTokenizer;
public class test {
	public static void main(String[] args)
	{
		/*String s = JOptionPane.showInputDialog(null,"Inputstream");
		WordCount(s,4);	*/
		int[] a = {37,3,9,5,10,5,3295,23,5,45};
		int[] b = {3,10,5,5,45,23,5,37,9,3295};
		System.out.println(check(a,b));
	}
	public static void WordCount(String s,int N)
	{
		int wordC=0;
		int wordN=0;
		StringTokenizer st  = new StringTokenizer(s);
		while(st.hasMoreTokens())
		{
			String t = st.nextToken();
			wordC++;
			if(t.length()>=N) 
				wordN++;
		}
		System.out.println("Words >="+N+": "+wordN);
		System.out.println(N+" density: "+((double)wordN)/wordC);
		System.out.println("Total count: "+wordC);
	}
	public static boolean check(int[] a1, int[] a2)
	{
		for(int i=-20; i<20; i++)
			for(int j=-20; j<20; j++)
				for(int k=-20; k<20; k++)
					if(i*i*j+j*j*k+k*k*i==2186) System.out.println(i+","+j+","+k);
		return false;
	}
}
