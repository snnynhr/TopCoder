import java.util.ArrayList;


public class ColorfulBricks
{
	ArrayList<String> g = new ArrayList<String>();
	public int countLayouts(String bricks)
	{
		for(int i=0; i<bricks.length(); i++)
			if(!g.contains(bricks.charAt(i)+"")) g.add(bricks.charAt(i)+"");
		if(g.size()>2) return 0;
		else if(g.size()==1) return 1;
		else return 2;
	}
}