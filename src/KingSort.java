import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class KingSort {
	public String[] getSortedList(String[] kings)
	{
		ArrayList<String> k = new ArrayList<String>();
		for(int i=0; i<kings.length; i++)
		{
			k.add(kings[i]);
		}
		Comparator<String> comp = new Comparator<String>() {
			
			public int compare(String a, String b) {
				StringTokenizer z_a = new StringTokenizer(a);
				StringTokenizer z_b = new StringTokenizer(b);
				String name_a=z_a.nextToken();
				String ord_a=z_a.nextToken();
				String name_b=z_b.nextToken();
				String ord_b=z_b.nextToken();
				if(!(name_a.equals(name_b)))
				{
					return name_a.compareTo(name_b);
				}
				else
				{
					int aa = toDecimal(ord_a);
					int bb= toDecimal(ord_b);

					//System.out.println(ord_a+" "+ ord_b);
					if(aa<bb) return -1;
					if(aa>bb) return 1;
				}
				return 0;
			}};
		
		Collections.sort(k,comp);
		
		String[] king = new String[kings.length];
		for(int i=0; i<king.length; i++)
		{
			king[i]=k.get(i);
		}
		return king;
	}
	public int toDecimal(String roman)
	{
		String[] r = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L"};
		for(int i=0; i<50; i++)
		{
			if(r[i].equals(roman)) return i+1;
		}
		return -1;
	}
}
