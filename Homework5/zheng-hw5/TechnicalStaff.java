
public class TechnicalStaff extends Employee {
	
	//default constructor that set everthing to null, "", or 0
	TechnicalStaff()
	{
		super("", 0);
	}
	
	//a constructor passes in name and base salary
	public TechnicalStaff(String n, double base)
	{
		super(n, base);
	}
	
	//check password criteria for technical staff, need 8+ characters, least 1 number, least 1 letter, and no special characters
	public boolean checkPassword(String s)
	{
		boolean pwdck = false;
		
		//find special characters, numbers, and letters in the string
		String get_special=s.replaceAll("[a-zA-Z0-9]", "");
		String get_number=s.replaceAll("[^0-9]", "");
		String get_letter=s.replaceAll("[^a-zA-Z]", "");
		
		//compare the results
		if (s.length() >= 8 && get_number.length() >= 1 && get_letter.length() >= 1  && get_special.length() == 0)
		{
			pwdck = true;
		}
		return pwdck;
	}
	
	//return base salary
	public double getSalary()
	{
		//System.out.print("get base Salary: ");
		//System.out.println(getBaseSalary());
		return getBaseSalary();
	}
}
