
public class FoxAndGomoku {
	public String win(String[] board)
	{
		if(checkH(board)) 
			{			System.out.println("H");

			return "found";
			}
		if(checkV(board)) 
			{			System.out.println("V");

			return "found";
			}
		if(checkD(board))
			{
			System.out.println("D");
			return "found";
			}
		if(checkDR(board)) 
			{
			System.out.println("DR");
			return "found";
			}
		return "not found";
	}
	public boolean checkH(String [] board)
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board.length-5+1; j++)
			{
				boolean f = true;
				for(int k=j; k<j+5; k++)
				{
					if(board[i].charAt(k)!='o')
					{
						f = false;
						break;
					}
					
				}
				if(f) return true;
			}
		}
		return false;
	}
	public boolean checkV(String [] board)
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board.length-5+1; j++)
			{
				boolean f = true;
				for(int k=j; k<j+5; k++)
				{
					if(board[k].charAt(i)!='o')
					{
						f = false;
						break;
					}
					
				}
				if(f) return true;
			}
		}
		return false;
	}
	public boolean checkD(String[] board)
	{
		for(int i=0; i<board.length-5+1; i++)
		{
			for(int j=0; j<board.length-5+1; j++)
			{
				int a = i;
				int b = j;
				boolean c = true;
				for(int k=0; k<5; k++)
				{
					
					if(board[a].charAt(b)!='o')
					{
						c = false;
						break;
						
					}
					a++; b++;
				}
				if(c) return true;
			}
		}
		return false;
	}
	public boolean checkDR(String[] board)
	{
		for(int i=0; i<board.length-5+1; i++)
		{
			for(int j=0; j<board.length-5+1; j++)
			{
				int a = board.length - i -1;
				int b = board.length - j -1;
				boolean c = true;
				for(int k=0; k<5; k++)
				{
					
					if(board[a].charAt(b)!='o')
					{
						c = false;
						break;
						
					}
					a--; b--;
				}
				if(c) return true;
			}
		}
		return false;
	}
}
