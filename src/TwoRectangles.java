public class TwoRectangles
{
	public String describeIntersection(int[] A, int[] B)
	{
		int x1=A[0];
		int y1=A[1];
		int x2=A[2];
		int y2=A[3];
		
		int w1=B[0];
		int z1=B[1];
		int w2=B[2];
		int z2=B[3];

		if (x1<w2&&x2>w1&&y1<z2&&y2>z1) return "rectangle";
		if(x2==w1&&y1==z2&&w2>x2&&z1<y1) return "point";
		if(x1==w2&&y1==z2&&w1<x1&&z1<y1) return "point";
		if(x2==w1&&y2==z1&&w2>x2&&z2>y2) return "point";
		if(x1==w2&&y2==z1&&w1<x1&&z2>y2) return "point";
		if(x2==w1&&(!(z2<y1||z1>y2))) return "segment";
		if(x1==w2&&(!(z2<y1||z1>y2))) return "segment";
		if(y1==w2&&(!(x2<w1||x1>w2))) return "segment";
		if(y2==w1&&(!(x2<w1||x1>w2))) return "segment";
		return "none";
	}
}