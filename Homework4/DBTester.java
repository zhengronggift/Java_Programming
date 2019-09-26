

public class DBTester
{

	public static void main(String args[ ])
	{
		System.out.println("Homework 4 test case results by Rong Zheng");

		ManageDB m = new ManageDB(5, "EmployeeData.txt");
		boolean result;

		int testCount = 1;  // used to track test numbers

		result = isSame(23, m.getAge(0));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getName(0).equals("Jane"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		result = isSame(1000000.98, m.getSalary(0));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		result = isSame(-1, m.getAge(1));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getName(1).equals("Jerry"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		result = isSame(100000, m.getSalary(1));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		result = isSame(29, m.getAge(2));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getName(2).equals("Joann"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		result = isSame(50000.8, m.getSalary(2));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		result = isSame(-1, m.getAge(3));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getName(3).equals(""))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		result = isSame(-1, m.getSalary(3));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		result = isSame(25, m.getAge(4));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getName(4).equals("John"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		result = isSame(1177.22, m.getSalary(4));
		if (result == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


	}
	private static boolean isSame(double x, double y)
	{
		double error = .00001;
		boolean rv = false;
		if (((x + error) >= y) && ((x - error) <= y))
		{
			rv = true;
		}
		return rv;
	}
}

