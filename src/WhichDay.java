import java.util.ArrayList;


public class WhichDay {
	ArrayList<String> days = new ArrayList<String>(7);
	
	public String getDay(String[] notOnThisDay)
	{
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");
		days.add("Sunday");
		for(int i=0; i<notOnThisDay.length; i++)
			days.remove(notOnThisDay[i]);
		return (String) days.get(0);
	}
}
