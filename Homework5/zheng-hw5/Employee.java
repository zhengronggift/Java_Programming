
abstract class Employee {
	// Member variables
	private double base_salary;
	private String userName;
	private String set_password;
	
	//default constructor set name to "" and base salary to 0
	Employee()
	{
		userName = "";
		base_salary = 0;
		set_password = "";
	}
	
	//set the salary and name to the variables passed in
	Employee(String n, double s)
	{
		base_salary = s;
		userName = n;
	}
	
	//return the name
	public String getName()
	{	
		//System.out.print("user name: ");	
		//System.out.println(userName);
		return userName;
	}
	
	//return the salary
	public double getBaseSalary()
	{
		//System.out.print("base salary: ");
		//System.out.println(base_salary);
		return base_salary;
	}
	
	//call checkpassword method first, if true, set password, else throw exception
	protected void setPW(String p)
	{
		boolean check = checkPassword(p);
		if (check == true)
		{
			set_password = p;
		}
		else
		{
			throw new IllegalArgumentException("Password not right");
		}
	}
	
	//check the password to match employee's password
	public boolean isPasswordMatch(String s)
	{
		try {
			//System.out.print("pasword match: ");
			//System.out.println(set_password.compareTo(s));
			if (set_password.compareTo(s) == 0)
			{
				return true;
			}
			else
				return false;
	        } catch (NullPointerException e) {
			return false;
  		}


	}
	
	//check the password, length > 8, least 1 number, least 1 letter, and no special character
	public boolean checkPassword(String s)
	{
		String get_special=s.replaceAll("[a-zA-Z0-9]", "");
		String get_number=s.replaceAll("[^0-9]", "");
		String get_letter=s.replaceAll("[^a-zA-Z]", "");

		if (s.length() >= 8 && get_number.length() >= 1 && get_letter.length() >= 1 && get_special.length() == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//abstract method for child class to add
	abstract public double getSalary();
}
