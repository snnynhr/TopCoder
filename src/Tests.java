
public class Tests {
	public static String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	static String[] num1 = {"zero","one","two","three","four","five","six","seven","eight","nine"};
	static String[] num2 = {"", "eleven", "twelve", "thirteen", "fourteen",
		"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] num3 = {"", "", "twenty", "thirty", "forty", "fifty",
		"sixty", "seventy", "eighty", "ninety"};
	public static String res(long l)
	{
		String s = l+"";
		int r =(int)s.charAt(0)-48;
		String res="";
		res += num[r] + "billion";

		r =(int)s.charAt(1)-48;
		if(r!=0)
			res += num[r] + "hundred";
		r =(int)s.charAt(2)-48;
		int t =(int)s.charAt(3)-48;
		if(r!=0){
			if(r!=1) {
				res += num3[r];
				res+= num1[t]; }
			else
				res+=num2[t];
			res+="million";
		}
		else if(t!=0)
		{
			res+=num1[t];
			res+="million";
		}
		
		r =(int)s.charAt(4)-48;
		if(r!=0)
			res += num[r] + "hundred";
		r =(int)s.charAt(5)-48;
		t =(int)s.charAt(6)-48;
		if(r!=0){
			if(r!=1) {
				res += num3[r];
				res+= num1[t]; }
			else
				res+=num2[t];
			res+="thousand";
		}
		else if(t!=0)
		{
			res+=num1[t];
			res+="thousand";
		}
		
		r =(int)s.charAt(7)-48;
		if(r!=0)
			res += num[r] + "hundred";
		r =(int)s.charAt(8)-48;
		t =(int)s.charAt(9)-48;
		if(r!=0){
			if(r!=1) {
				res += num3[r];
				res+= num1[t]; }
			else
				res+=num2[t];
		}
		else if(t!=0)
		{
			res+=num1[t];
		}


		return res;
	}
	public static void main(String args[])
	{
		String low="eightbillioneighthundredeighteenmillioneighteen";
		for(long i=8018018001l; i<9000000000l; i+=2)
		{
			String rr = res(i);
			if(rr.compareTo(low)<0)
			{
				low = rr;
				System.out.println(low+" "+i);
			}
		}
	}
}
