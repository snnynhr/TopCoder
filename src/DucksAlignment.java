import java.util.Arrays;


public class DucksAlignment {
	public int minimumTime(String[] grid)
	{
		int rows =grid.length;
		int columns=grid[0].length();
		int minTime=Integer.MAX_VALUE;
		String[] gridh = new String[grid[0].length()];
		for( int i=0; i<columns; i++)
		{
			String s="";
			for( int j=0; j<rows; j++)
			{
				s+=grid[j].charAt(i);
			}
			gridh[i]=s;
		}
				
		for( int i=0; i<columns; i++)
		{
			int val=0;
			String t="";
			for(int j=0; j<rows; j++)
			{
				val+=getDistance(grid[j],i);
				if(gridh[j].contains("o"))
					t+='o';
				else
					t+=".";
			}
			val+=minLateral(t);
			if(val<minTime) minTime=val;
		}
		for( int i=0; i<rows; i++)
		{
			int val=0;
			String t="";
			for(int j=0; j<columns; j++)
			{
				val+=getDistance(gridh[j],i);
				if(gridh[j].contains("o"))
				{
					t+='o';
				}
				else
					t+=".";
			}
			val+=minLateral(t);
			if(val<minTime) minTime=val;
		}
		System.out.println(Arrays.toString(grid));
		System.out.println("\n");
		System.out.println(Arrays.toString(gridh));
		return minTime;
	}
	public int getDistance( String find, int index)
	{
			int z=find.indexOf('o');
			if(z==-1) z=index;
			return Math.abs(z-index);
	}
	public int minLateral( String find)
	{
		int min=Integer.MAX_VALUE;
		for( int i=0; i<find.length(); i++)
		{
			int tmp=Integer.MAX_VALUE;
			if(find.charAt(i)=='o')
			{
				tmp=0;
				for( int j=0; j<find.length(); j++)
				{
					if(find.charAt(j)=='o')
					{
						if(i<j)
						tmp+=getNumOcc(find.substring(i,j+1));
						else
						tmp+=getNumOcc(find.substring(j,i+1));	
					}
					
				}
				//System.out.println("\n" +tmp+"  k0l ");
			}
			if(tmp<min) min=tmp;
			//System.out.println(min+":min");
		}
		if(min==Integer.MAX_VALUE) min=0;
		return min;
	}
	public int getNumOcc(String s)
	{
		//System.out.println(s);
		int count=0;
		for( int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='.') count++;
		}
		//System.out.print(count);
		return count;
	}
}
