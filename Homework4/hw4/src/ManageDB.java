
import java.io.*;
public class ManageDB extends EmployeeDB {
	// Member variables
	private int number;
	private String fileName;
	private String[][]record;
	
	// Constructors
	ManageDB(int number, String fileName)
	{
		super();
		this.number = number;
		String readFileString = fileName;
		long fileLength;
		String fileString = "No information was read";
		BufferedReader in = null;
		record = new String [number][3];
		
		//initialize record array
		for (int i = 0; i < number; i++)
		{
			for( int u = 0; u < 3; u++)
			{
				record[i][u] = "bingo";
				//System.out.print(record[i][u]);
			}
		}
		
		try
		{
			File f = new File(readFileString);
			if (f.exists() == true)  // throws SecurityException checked exception
			{
				fileLength = f.length();  // throws SecurityException checked exception
				//System.out.println("There are " + fileLength + " characters in the file");
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
		//System.out.println(fileString);

		
		String [] lines = fileString.split("[\\^]");
		
        // Display result parts.
		String num = "";
    	//String record2[] = new String[20];
        for (String part : lines) {
          //  System.out.println(part);
            if(part.length() > 4)
            {
                num = part.substring(0, 4);
                //System.out.println(num);
                try 
                {
                    int res = Integer.parseInt(num);
                    //System.out.println(res);
                }
                catch (NumberFormatException | NullPointerException nfe)
                {
                	part = "";
                }
                
                int iend = part.indexOf("="); //this finds the first occurrence of "=" 
                String subString;
                if (iend != -1) 
                {
                	subString= part.substring(4 , iend); //this will give value before =
                	//System.out.println(subString);
                	if (subString.contentEquals("age"))
                	{
                        subString= part.substring((iend+1), part.length()); //this will give values after =
                        //System.out.println(subString);
                        try 
                        {
                            int res = Integer.parseInt(subString);
                            //System.out.println(res);
                        }
                        catch (NumberFormatException | NullPointerException nfe)
                        {
                        	part = "";
                        }
                	}
                	else if (subString.contentEquals("salary"))
                	{
                        subString= part.substring((iend+1), part.length()); //this will give values after =
                        //System.out.println(subString);
                        try 
                        {
                            double res = Double.parseDouble(subString);
                            //System.out.println(res);
                        }
                        catch (Exception e)
                        {
                        	part = "";
                        }                		
                	}

                }
                
                int k = 0;

                //Store the data into the array with 3 row 5 columns
                //if the index value is > number, it will be ignored 
                if (part != "") {
                	int res = Integer.parseInt(num);
                    while( k < 3 && res < number){
                    	
                    	if (record[res][k] == "bingo")
                    	{
                    		record[res][k] = part.substring(4, part.length());
                    		k = 5;
                    	}
                    	else
                    	{
                    		k++;
                    	}
                    }
                }

            }  
           // System.out.println(part);
        }
        
        // Loop through all rows to print values in the 2D array
      /*  for (String[] row : record) 
        {
            // Loop through all columns of current row 
            for (String x : row) 
            {
            	System.out.println(x); 
            }
        }*/
	}

	// returns the name of Employee at i index
	public String getName(int i) 
	{
			for (int num = 0; num < 3; num++)
			{
	            int iend = record[i][num].indexOf("="); //this finds the first occurrence of "=" 
	            String subString;
	            if (iend != -1) 
	            {
	            	subString= record[i][num].substring(0 , iend); //this will give value before =
	            	//System.out.println(subString);
	            	if (subString.contentEquals("name"))
	            	{
	                    subString= record[i][num].substring((iend+1), record[i][num].length()); //this will give values after =
	                    return subString;
	            	}
	            }
			}
			return "";
	}
	
	// returns the age of Employee at i index
	public int getAge(int i)    
	{
		int res = -1;
		for (int num = 0; num < 3; num++)
		{
            int iend = record[i][num].indexOf("="); //this finds the first occurrence of "=" 
            String subString;
            if (iend != -1) 
            {
            	subString= record[i][num].substring(0 , iend); //this will give value before =
            	//System.out.println(subString);
            	if (subString.contentEquals("age"))
            	{
                    subString= record[i][num].substring((iend+1), record[i][num].length()); //this will give values after =
                    res = Integer.parseInt(subString);
            	}
            }
		}		
		return res;
	}
	// returns the salary of Employee at i index
	public double getSalary(int i)   
	{
		double res = -1;
		for (int num = 0; num < 3; num++)
		{
            int iend = record[i][num].indexOf("="); //this finds the first occurrence of "=" 
            String subString;
            if (iend != -1) 
            {
            	subString= record[i][num].substring(0 , iend); //this will give value before =
            	//System.out.println(subString);
            	if (subString.contentEquals("salary"))
            	{
                    subString= record[i][num].substring((iend+1), record[i][num].length()); //this will give values after =
                    res = Double.parseDouble(subString);
                    
            	}
            }
		}		
		return res;
	}
}
