import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
// This is the updated version 2
public class EmployeeTester
{

	public static void main(String args[ ])
	{
		System.out.println("Homework 5 test case results by Rong Zheng");

		int testCount = 1;  // used to track test numbers


		boolean result;

		Manager m = new Manager();

		if (m.getName().equals(""))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getBaseSalary() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getSalary() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		m = new Manager(1000, "Joe", 50000);

		if (m.getName().equals("Joe"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getBaseSalary() == 50000)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (m.getSalary() == 51000)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		TechnicalStaff t = new TechnicalStaff();

		if (t.getName().equals(""))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (t.getBaseSalary() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (t.getSalary() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		t = new TechnicalStaff("Joan", 60000);

		if (t.getName().equals("Joan"))
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (t.getBaseSalary() == 60000)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (t.getSalary() == 60000)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		if (m.isPasswordMatch("") == false)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (t.isPasswordMatch("") == false)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		// test the password setting for Manager
		try
		{
			m.setPW("Ab1^123456");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			m.setPW("Ab1123456");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			m.setPW("AB12345678");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			m.setPW("ab12345678");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			m.setPW("aB1234567");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			m.setPW("aB12345678");
			System.out.println("Test Case " + testCount + " Passed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Faileded");
		}
		testCount++;

		if (m.isPasswordMatch("aB12345678") == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;


		// test the password setting for TechnicalStaff
		try
		{
			t.setPW("Ab1^1234");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			t.setPW("12345678");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			t.setPW("ABCDEFGHI");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			t.setPW("ab12345");
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;

		try
		{
			t.setPW("aa1234567");
			System.out.println("Test Case " + testCount + " Passed");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Test Case " + testCount + " Failed");
		}
		testCount++;

		if (t.isPasswordMatch("aa1234567") == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
		
		// Tests for the MouseProcessing class
		MouseProcessing mp = new MouseProcessing(10, 10, 50, 50);
		MouseListener nmp = mp;

  		JFrame f = new JFrame("N");
		MouseEvent e = new MouseEvent(f, MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, 50, 50, 1, false, MouseEvent.BUTTON1);
		mp.mouseClicked(e);
		e = new MouseEvent(f, MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, 10, 10, 1, false, MouseEvent.BUTTON1);
		mp.mouseClicked(e);
		e = new MouseEvent(f, MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, 59, 59, 1, false, MouseEvent.BUTTON1);
		mp.mouseClicked(e);
		e = new MouseEvent(f, MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, 60, 59, 1, false, MouseEvent.BUTTON1);
		mp.mouseClicked(e);
		e = new MouseEvent(f, MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, 59, 60, 1, false, MouseEvent.BUTTON1);
		mp.mouseClicked(e);

		if (mp.getClicksInRegion() == 3)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (mp.getTotalClicks() == 5)
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

