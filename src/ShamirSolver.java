import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class ShamirSolver {
	
	
	
	private static final BigInteger prime = new BigInteger( 
			"5992830235524142758386850633773258681119"); 
	
	public static void solve(String[] args, boolean force) throws IOException 
	{ 
		
		HashMap<Integer, BigInteger> map = new HashMap<Integer, BigInteger>();
		for(int i=0; i<50; i++)
			map.put(TestingTest.keys[i][0].intValue(), TestingTest.keys[i][1]);
		
			String value = new Shamir(prime).join(map).toString(); 
			System.out.println(value); 
			System.out.println(value.length());
			System.out.println(decode(value)); 
		
	} 
	public static void main (String [] args) throws IOException
	{
		// WELCOME TO THE PLAYGROUND!!!! 
		System.out.println("Welcome to playground."); 
		Random random = new Random(); 
		Scanner scanner = new Scanner(System.in); 
		while (true) { 
			System.out.print(">"); 
			String in = scanner.nextLine(); 
			if (in.equals("exit")) 
				break; 
			else if (in.matches("decode.+")) 
				System.out.println(decode(in.substring("decode ".length()))); 
			else if (in.matches("encode.+")) 
				System.out.println(encode(in.substring("encode ".length()))); 
			else if (in.matches("prime.+")) 
				System.out.println(BigInteger.probablePrime( 
						Integer.parseInt(in.substring("prime ".length())), 
						random)); 
			else if (in.matches("join.+")) { 
				HashMap<Integer, BigInteger> map = new HashMap<Integer, BigInteger>(); 
				String[] sets = in.substring("join ".length()) 
						.replaceAll("\\s+", "").split(","); 
				BigInteger prime = new BigInteger(sets[0]); 
				for (int a = 1; a < sets.length; a += 2) 
					map.put(Integer.parseInt(sets[a]), new BigInteger( 
							sets[a + 1])); 
				String value = new Shamir(prime).join(map).toString(); 
				System.out.println(value); 
			} else if (in.matches("split.+")) { 
				String[] sets = in.substring("split ".length()) 
						.replaceAll("\\s+", "").split(","); 
				HashMap<Integer, BigInteger> map = new Shamir(new BigInteger(
						sets[0])).split(new BigInteger(sets[1]),
								Integer.parseInt(sets[2]), Integer.parseInt(sets[3]));
				for (int key : map.keySet()) 
					System.out.println(key + ", " + map.get(key)); 
			} else if (in.matches("solve")) 
				solve(args, false); 
			else if (in.matches("fsolve")) 
				solve(args, true); 
		} 
		scanner.close(); 
	}
	/** 
	 * @author Rahul 
	 * @param number 
	 *            The BigInteger secret number 
	 * @return the string answer to the question 
	 * 
	 * Currently all to lower case because that seems to be what the problem says it will be
	 */
	public static String decode(String number) { 
		String string = ""; 
		for (int a = 0; a < number.length(); a += 2) 
			string += Character.toLowerCase(Character.toChars(87 + Integer.parseInt(number.substring( 
					a, a + 2))/* % 26 + 11/*Enable this if you need to*/ )[0]); 

		return string; 
	} 

	/** 
	 * @author Rahul 
	 * @param string 
	 *            A string text 
	 * @return the secret number 
	 */
	public static String encode(String string) { 
		String number = ""; 
		for (int a = 0; a < string.length(); a++) 
			number += (Character.getNumericValue(string.charAt(a)) + 1); 
		return number; 
	} 
}