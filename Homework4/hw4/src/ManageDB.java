import java.io.*;

public class ManageDB extends EmployeeDB {
	// Member variables
	private int number;
	private String fileName;
	
	// Constructors
	ManageDB(int number, String fileName)
	{
		super();
		this.number = number;
		String readFileString = fileName;
		long fileLength;
		String fileString = "No information was read";
		BufferedReader in = null;
		try
		{
			File f = new File(readFileString);
			if (f.exists() == true)  // throws SecurityException checked exception
			{
				fileLength = f.length();  // throws SecurityException checked exception
				System.out.println("There are " + fileLength + " characters in the file");
				char[] ch = new char[(int)fileLength];
				in = new BufferedReader(new FileReader(readFileString)); // throws FileNotFoundException checked exception
				in.read(ch, 0, (int)fileLength);  // throws IOException checked exception
				fileString = String.valueOf(ch, 0, (int)fileLength);
			}
			else
			{
				System.out.println("File does not exist");
			}
		}
		catch (SecurityException e)
		{
			System.out.println("SecurityException when reading the file " + e);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileNotFoundException when reading the file " + e);
		}
		catch (IOException e)
		{
			System.out.println("IOException when reading the file " + e);
		}
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			}
			catch (IOException e)
			{
				System.out.println("IOException when closing the read file " + e);
			}
		}
		System.out.println(fileString);

		
		String [] lines = fileString.split("[\\^]");
	/*	for(int i=0;i<lines.length;i++){
		    if(lines[i].startsWith("^")){
				System.out.println(lines[i]);
		        lines[i]="";
		    }
		}*/
        // Display result parts.
		String num = "";
        for (String part : lines) {
          //  System.out.println(part);
            if(part.length() > 4)
            {
                num = part.substring(0, 4);
                System.out.println(num);
                try 
                {
                    int res = Integer.parseInt(num);
                    System.out.println(res);
                }
                catch (NumberFormatException | NullPointerException nfe)
                {
                	part = "";
                }

            }
            System.out.println(part);

        }

	}
/*	
	// returns the name of Employee at i index
	public String getName(int i) 
	{
		
	}
	
	// returns the age of Employee at i index
	public int getAge(int i)    
	{
		
	}
	// returns the salary of Employee at i index
	public double getSalary(int i)   
	{
		
	}
	*/
	public static void main(String args[ ])
	{
		ManageDB m = new ManageDB(5, "EmployeeData.txt");
	}

}
