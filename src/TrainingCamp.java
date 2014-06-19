
public class TrainingCamp {
	public String[] determineSolvers(String[] attendance, String[] problemTopics)
	{
		String[] solves= new String[attendance.length];
		for(int i=0; i<attendance.length; i++)
		{
			String temp="";
			for(int j=0; j<problemTopics.length; j++)
				temp+=calc(attendance[i],problemTopics[j]);
			solves[i]=temp;
		}
		return solves;
	}
	public String calc(String student, String problem)
	{
		for(int i=0; i<student.length(); i++)
			if(compare(student.charAt(i),problem.charAt(i))=="-") return "-";
		return "X";
	}
	public String compare(char a, char b)
	{
		if(a=='X' && b=='-') return "X";
		else if(a=='X' && b=='X') return "X";
		else if(a=='-' && b=='-') return "X";
		return "-";	
	}
}
