import java.util.StringTokenizer;


public class ThreeTeleports {
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports)
	{
		//int minHomeD= distance(xMe,yMe, xHome, yHome);
		int[][] startTel = new int[3][2];
		int[][] endTel = new int[3][2];
		
		int[] startToTele = new int[6];
		int[] teleToHome = new int[6];
	//	int[][] teleToTele = new int[6][4];
		
		for(int i=0; i<teleports.length; i++)
		{
			StringTokenizer z = new StringTokenizer(teleports[i]);
			int tx1=Integer.parseInt(z.nextToken());
			int ty1=Integer.parseInt(z.nextToken());
			int tx2=Integer.parseInt(z.nextToken());
			int ty2=Integer.parseInt(z.nextToken());
			startTel[i][0] = tx1;
			startTel[i][1] = ty1;
			endTel[i][0] = tx2;
			endTel[i][1] = ty2;
			startToTele[2*i]=distance(tx1,ty1,xMe,yMe);
			startToTele[2*i-1]=distance(tx2,ty2,xMe,yMe);
			teleToHome[2*i]=distance(tx1,ty1,xHome,yHome);
			teleToHome[2*i-1]=distance(tx2,ty2,xHome,yHome);
		}
		
		
		return 0;
	}
	public int distance(int x1, int y1, int x2, int y2)
	{
		return Math.abs(x1-x2)+Math.abs(y1-y2);	
	}
}
