
public class Employee {
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
		return userName;
	}
	
	//return the salary
	public double getBaseSalary()
	{
		return base_salary;
	}
	
	protected void setPW(String p)
	{
		set_password = p;
	}
	
	public boolean isPasswordMatch(String s)
	{
		
		if (set_password.compareTo(s) == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	public boolean checkPassword(String s)
	{
		if (set_password.compareTo(s) == 0)
		{
			return true;
		}
		else
			return false;
	}
	
	public double getSalary()
	{
		return 0;
	}
}
