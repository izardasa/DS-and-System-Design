import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class IDChanger {
	public static void main(String[] args) {
		File folder = new File("D:/testXml");
		File[] listOfFiles = folder.listFiles();
		final long OLD_ID = 5316537;
		final long NEW_ID = 15316537;

		for (int i = 0; i < listOfFiles.length; i++) 
		{
		  if (listOfFiles[i].isFile()) 
		  {
		    System.out.println("File " + listOfFiles[i].getName());
		    System.out.println(listOfFiles[i].getAbsolutePath());
		    replaceTextInFile(listOfFiles[i].getAbsolutePath(), OLD_ID, NEW_ID);
		  } 
		  else if (listOfFiles[i].isDirectory()) 
		  {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
	} 
	
	public static void replaceTextInFile(String filName, long oldId, long newId)
	{
		File log= new File(filName);
		String search = "<ID schemeAgencyID=\"PST\">"+oldId+"</ID>";  // <- changed to work with String.replaceAll()
		String replacement = "<ID schemeAgencyID=\"PST\">"+newId+"</ID>";
		//file reading
		FileReader fr=null;
		BufferedReader br=null;
		String s;
		try {
			fr = new FileReader(log);
		    br = new BufferedReader(fr);

		    while ((s = br.readLine()) != null) {
		        s.replaceAll(search, replacement);
		        // do something with the resulting line
		    }
		    br.close();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
