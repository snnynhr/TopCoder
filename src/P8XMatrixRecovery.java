import java.util.ArrayList;
import java.util.Arrays;


public class P8XMatrixRecovery {
	ArrayList<String> cols= new ArrayList<String>();
	public String[] solve(String[] rows, String[] columns)
	{
		for(int i=0; i<columns.length; i++)
			cols.add(columns[i]);
		for(int i=0; i<rows[0].length(); i++)
		{

			System.out.println(Arrays.toString(rows));
			String c=getCol(rows,i);
			int max=0;
			String best="";
			for(int j=0; j<cols.size(); j++)
			{
				int x=comp(cols.get(j),c);
				if(x>=max)
				{
					best=cols.get(j);
					max=x;
				}
			}
			cols.remove(best);
			System.out.println(best);
			//match
			for(int j=0; j<best.length(); j++)
			{
				if(rows[j].charAt(i)=='?')
				{
					if(best.charAt(j)=='?')
						rows[j]=rows[j].substring(0,i)+"0"+rows[j].substring(i+1);
					else
						rows[j]=rows[j].substring(0,i)+best.charAt(j)+rows[j].substring(i+1);
				}
			}
		}
		return rows;
	}
	public int comp(String a, String b)
	{
		int val=0;
		for(int i=0; i<a.length(); i++)
		{
			char A=a.charAt(i);
			char B=b.charAt(i);
			if((A==B && A!='?')) val+=2;
			else if(A=='0'&&B=='1' || A=='1'&&B=='0') return -1;
			else if(!(A=='?'&&B=='?')) val++;
		}
		return val;
	}
	public String getCol(String[] rows, int col)
	{
		String s="";
		for(int i=0; i<rows.length; i++)
			s+=rows[i].charAt(col);
		return s;
	}
}
