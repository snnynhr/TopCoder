public class EllysCheckers
{
	String mboard;
	int count;
	public String getWinner(String board)
	{
		mboard=board;
		mboard=mboard.substring(0,mboard.length()-1)+".";
		boolean not=true;
		count=0;
		while(not)
		{
			not=makeMoveIfPossible();
			count=1-count;
		}
		if(count==0) return "YES";
		else return "NO";
	}
	public boolean makeMoveIfPossible()
	{
		mboard=mboard.substring(0,mboard.length()-1)+".";
		//System.out.println(mboard);
		for(int i=0; i<mboard.length()-1; i++)
		{
			if(mboard.charAt(i)=='o')
			{
				if(mboard.charAt(i+1)=='.')
				{
					mboard=setCharAt(mboard, i+1, "o");
					mboard=setCharAt(mboard, i, ".");
					return true;
				}
			}
		}
		for(int i=mboard.length()-4; i>=0; i--)
		{
			if(mboard.charAt(i)=='o')
			{
				if(mboard.charAt(i+1)=='o' && mboard.charAt(i+2)=='o' && mboard.charAt(i+3)=='.')
				{
					mboard=setCharAt(mboard, i+3, "o");
					mboard=setCharAt(mboard, i, ".");
					return true;
				}
			}
		}
		return false;
	}
	public String setCharAt(String str, int index, String chr) {
		if(index > str.length()-1) return str;
		return str.substring(0,index) + chr + str.substring(index+1);
	}
}