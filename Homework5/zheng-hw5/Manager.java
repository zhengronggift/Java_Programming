
public class Manager extends Employee {
	//Member variables
	private double bonus;
	
	//default constructor initialize variables as null, 0, and ""
	public Manager(){
		super("", 0);
		bonus = 0;
	}

	//constructor pass in values to set up variables
	public Manager(double b, String n, double base)
	{
		super(n, base);
		bonus = b;
	}
	
	//check password for manager, the criteria is same as employee, except it need length of 10, least 1 capital letter, and least 1 lower case letter
	public boolean checkPassword(String s)
	{
		boolean check = false;
		//get the special character
		String get_special=s.replaceAll("[a-zA-Z0-9]", "");
		//get numbers
		String get_number=s.replaceAll("[^0-9]", "");
		//get capital letters
		String get_cletter=s.replaceAll("[^a-z]", "");
		//get lower case letters
		String get_lletter=s.replaceAll("[^A-Z]", "");
		
		//compare the results, return true if all criteria meets
		if (s.length() >= 10 && get_number.length() >= 1 && get_cletter.length() >= 1 && get_lletter.length() >= 1 && get_special.length() == 0)
		{
			
			check = true;
			return check;
		}
		else
		{
			return check;
		}
	}
	
	//return salary of manager, they get bonus in addition to base salary
	public double getSalary()
	{
		//System.out.print("get base Salary + bonus: ");
		//System.out.println(getBaseSalary() + bonus);
		return bonus + getBaseSalary();
	}
}
