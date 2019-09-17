
public class MatrixTester
{
	public static void main(String args[])
	{
		System.out.println("Homework 3 test case results by Your Name");

		int testCount = 1;  // used to track test numbers
		double[] zzz = new double[0];
		Matrix a = new Matrix(0, 0, zzz);

		//1 test cases for default constructor
		if (a.getNumberRows() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//2
		if (a.getNumberColumns() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//3
		Matrix b = a.getTranspose();
		if (b.getNumberRows() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//4
		if (b.getNumberColumns() == 0)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//5
		// test 3 input constructor with no errors
		Matrix c = null;
		double[] aaa = {10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
		try
		{
			c = new Matrix(5, 3, aaa);
			System.out.println("Test Case " + testCount + " Passed");
		}
		catch(MatrixFormatException ee)
		{
			System.out.println("Test Case " + testCount + " Failed");
		}
		testCount++;
//6
		if (c.getNumberRows() == 5)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//7
		if (c.getNumberColumns() == 3)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//8
		Matrix d = c.getTranspose();
		if (d.getNumberRows() == 3)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//9
		if (d.getNumberColumns() == 5)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//10
		// test 3 input constructor with errors
		Matrix e = null;
		double[] bbb = {10,11,12,13,14,15,16,17,18,19,20,21,22,23};
		e = new Matrix(5, 3, bbb);
		
		try{
			e = new Matrix(5, 3, bbb);
			System.out.println("Test Case " + testCount + " Failed");
		}
		catch
		(MatrixFormatException ee)
		{
			System.out.println(ee);
			System.out.println("Test Case " + testCount + " Passed");
		}
		testCount++;
//11
		// test equals method
		double[] ccc = {10,11,12,13,14,15,16,17,18};
		Matrix f = new Matrix(3, 3, ccc);
		if (a.equals(a) == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (a.equals(b) == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		if (b.equals(a) == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//14
		if (c.equals(c) == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//15
		if (c.equals(d) == false)
		{	
			System.out.println("Test Case " + testCount + " Passed");
		}else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//16
		if (c.equals(a) == false)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//17
		if (c.equals(f) == false)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//18
		if (d.equals(f) == false)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//19
		if (f.equals(f) == true)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;
//20
		aaa[0] = 9;
		Matrix g = new Matrix(5, 3, aaa);
		System.out.println(g.getNumberRows());
		System.out.println(g.getNumberColumns());
		System.out.println(c.getNumberRows());
		System.out.println(c.getNumberColumns());
		if (g.equals(c) == false)
			System.out.println("Test Case " + testCount + " Passed");
		else
			System.out.println("Test Case " + testCount + " Failed");
		testCount++;

		double[] ddd = {10,13,16,19,22,11,14,17,20,23,12,15,18,21,24};
		Matrix h = new Matrix(3, 5, ddd);
		if (h.equals(d) == true)
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