
public class CutTheNumbers {
	public int maximumSum(String[] board)
	{
		int asum=0,bsum=0;
		int rows = board.length;
		int cols = board[0].length();
		for(int i=0; i<rows; i++)
		{
			asum+=Integer.parseInt(board[i]);
		}
		for(int i=0; i<cols; i++)
		{
			bsum+=returnSum(board,i);
		}
		if(bsum>asum) return bsum;
		return asum;
	}
	public int returnSum(String[] board,int index)
	{
		String s="";
		for(int i=0; i<board.length; i++)
		{
			s+=board[i].charAt(index);
		}
		return Integer.parseInt(s);
	}
}
