
public class MonochromaticBoard {
	int cols,rows,max;
	public int theMin(String[] board)
	{
		rows = board.length;
		cols = board[0].length();
		max = Math.max(rows, cols);
		//int count=0; 
		return -1;
	}
	public String[] paintRow(String[] board, int row)
	{
		String s = "";
		for(int i=0; i<cols; i++) s+="W";
		board[row]=s;
		return board;
	}
	public String[] paintCol(String[] board, int col)
	{
		String s = "";
		for(int i=0; i<rows; i++) 
		{
			s=board[i];
			String s1=s.substring(0, i);
			String s2=s.substring(i+1);
			board[i]=s1+"W"+s2;
		}
		return board;
	}
	public int maxRow(String[] board)
	{
		int max=0;
		for(int i=1; i<rows; i++)
		{
			if(contain(board[max])<contain(board[i])) max=i;
		}
		return max;
	}
	public int maxCol(String[] board)
	{
		String s="";
		int max=0;
		int maxrow=0;
		for(int i=0; i<cols; i++)
		{
			for(int j=0; j<rows; j++)
			{
				s+=board[j].charAt(i);
			}
			if(max<contain(s))
			{
				max = contain(s);
				maxrow=i;
			}
		}
		return maxrow;
	}
	public int contain(String s)
	{
		int count=0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='B') count ++;
		}
		return count;
	}
}
