
public class PlatypusDuckAndBeaver
{
	public static int minimumAnimals(int webbedFeet, int duckBills, int beaverTails)
	{
		int y = (webbedFeet-2*duckBills)/2-beaverTails;
		int z = 2*beaverTails-(webbedFeet-2*duckBills)/2;
		int x =duckBills-z;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		return x+y+z;
	}
	public static void main(String args[])
	{
		System.out.println(minimumAnimals(112, 22, 23));
	}
}