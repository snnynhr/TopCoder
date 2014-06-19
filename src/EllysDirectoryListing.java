
public class EllysDirectoryListing
{
	public String[] getFiles(String[] files)
	{
		if(( files[files.length-1].equals(".")&&files[files.length-2].equals("..") )||( files[files.length-1].equals("..")&&files[files.length-2].equals(".") ))
		{
			return files;
		}
		for(int i=0; i<files.length; i++)
		{
			if(files[i].equals(".")||files[i].equals(".."))
			{
				//index=i;
				String temp=files[files.length-1];
				files[files.length-1]=files[i];
				files[i]=temp;
				break;
			}
		}
		if(( files[files.length-1].equals(".")&&files[files.length-2].equals("..") )||( files[files.length-1].equals("..")&&files[files.length-2].equals(".") ))
		{
			return files;
		}
		for(int i=0; i<files.length; i++)
		{
			if(files[i].equals(".")||files[i].equals(".."))
			{
				String temp=files[files.length-2];
				files[files.length-2]=files[i];
				files[i]=temp;
				break;
			}
		}
		return files;
	}
	
}