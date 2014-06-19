public class P8XMatrixTransformation
{
	public String solve(String[] original, String[] target)
	{
		int count0=0;
		for(int i=0; i<original.length; i++)
			for(int j=0; j<original[i].length(); j++)
				if(original[i].charAt(j)=='0') count0++;
		int count00=0;
		for(int i=0; i<target.length; i++)
			for(int j=0; j<target[i].length(); j++)
				if(target[i].charAt(j)=='0') count00++;		
		if(count00==count0) return "YES";
		else
			return "NO";
	}
}