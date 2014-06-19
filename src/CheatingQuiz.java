import java.util.Arrays;


public class CheatingQuiz {
	public int[] howMany(String answers)
	{
		char[] abc=answers.toCharArray();
		Arrays.sort(abc);
		String s="";
		for( int i=0 ;i<abc.length; i++)
			s+=abc[i];
		int[] tmp = new int[answers.length()];
		for( int i=0; i<answers.length(); i++)
		tmp[i]=countDiff(s.substring(i));
		return tmp;
	}
	public int countDiff(String a)
	{
		int countA=0, countB=0, countC=0;
		for(int i=0; i<a.length(); i++)
		{
			if(a.charAt(i)=='A') countA++;
			else if(a.charAt(i)=='B') countB++;
			else if(a.charAt(i)=='C') countC++;
		}
		int count=0;
		if(countA!=0) count++;
		if(countB!=0) count++;
		if(countC!=0) count++;
		return count;
	}
}
