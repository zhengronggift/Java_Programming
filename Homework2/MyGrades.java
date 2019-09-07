
public class MyGrades {
	//Private member variables
	private int DEFAULT_NUM_HW; // The default size of the hw array which is 3, it cannot be changed
	private int[] hw;   // An array the holds the homework grades
	private int finalExam;  // holds the final exam grade (or final project)
	private int midtermExam; // holds the midterm exam grade
	private int numberOfHomeworks; // holds the number of homework grades in the hw array

	//public class variables that cannot be changed
	public static double FINAL_EXAM_WEIGHT;  // the weight of the final exam is 25%
	public static double MIDTERM_EXAM_WEIGHT; // the weight of the midterm exam is 25%
	public static double HW_WEIGHT; // the weight of the homework avreage is 50%

	public MyGrades() {
		DEFAULT_NUM_HW = 3; // The default size of the hw array which is 3, it cannot be changed
		hw = new int[DEFAULT_NUM_HW];   // An array the holds the homework grades
		finalExam = 0;  // holds the final exam grade (or final project)
		midtermExam = 0; // holds the midterm exam grade
		numberOfHomeworks = 0; // holds the number of homework grades in the hw array

		//public class variables that cannot be changed
		FINAL_EXAM_WEIGHT = .25;  // the weight of the final exam is 25%
		MIDTERM_EXAM_WEIGHT = .25; // the weight of the midterm exam is 25%
		HW_WEIGHT = .5; // the weight of the homework avreage is 50%
		
	}
	// This member function sets the final exam grade.
	public void setFinalExam(int grade) 
	{
		finalExam = grade;
	}

	// This member function sets the midterm exam grade.
	public void setMidtermExam(int grade)
	{
		midtermExam = grade;
	}

	/*
	 * add a homework grade to the hw array. If the current homework grade overruns the array 
	 * capacity, then allocate a larger array to accomodate the new homework grade. 
	 */
	public void setHomework(int grade) 
	{
		if (numberOfHomeworks >= hw.length)
		{
		    int [] newArray = new int [hw.length + 1];
		    for(int i = 0; i < hw.length; i++)
		    {
		    	newArray[i] = hw[i];
		    }
		    hw = newArray;
		}
		
		for (int i = 0; i < hw.length; i++)
		{
			if (hw[i] == 0)
			{
				hw[i] = grade;
				numberOfHomeworks++;
			//	System.out.println(numberOfHomeworks);
			//	System.out.println(hw[i]);
				return;
			}	
		}
	}

	/*
	 * return the weighted average grade using the weights defined. If a test is not taken, that test 
	 * is considered a 0. If there are no homework assignments, then the homework assignment average 
	 * is considered a 0.
	 */
	public double getFinalGrade()
	{
		double hw_g = 0;
		for (int i= 0; i < numberOfHomeworks; i++)
		{
			hw_g += hw[i];
		}
		
		if (numberOfHomeworks != 0)
		{
			hw_g = hw_g / numberOfHomeworks;
		}
		
		if (numberOfHomeworks == 0)
		{
			hw_g = 0;
		}
		
		if (midtermExam != 0 || numberOfHomeworks != 0 || finalExam != 0)
		{
			double f_grade = FINAL_EXAM_WEIGHT * finalExam + hw_g * HW_WEIGHT + MIDTERM_EXAM_WEIGHT * midtermExam;
			return f_grade;
		}
		else
		{
			return 0;
		}
	}

	/*The equals function will return a true if the objects are equal and a false if not equal. Two objects are 
	 * considered equal if the midterm, final exam, and all homeworks (number of homeworks and the
	 * grades) are all equal.*/
	public boolean equals(MyGrades g)
	{
		boolean rv = false;
		if ((finalExam == g.finalExam) && (midtermExam == g.midtermExam) && (numberOfHomeworks == g.numberOfHomeworks))
		{
			rv = true;
		}
		if ((finalExam != g.finalExam) || (midtermExam != g.midtermExam) || (numberOfHomeworks != g.numberOfHomeworks))
		{
			rv = false;
		}
		return rv;
	}

	/*
	 * This will return a String with the Final Exam grade, the Midterm Exam grade, and the Final
	 * Grade. An example of how the string should look is as follows: "Final Exam = 81 Midterm Exam 
	 * = 80 Final Grade = 86.5"
	 */
	public String toString()  
	{
		return "Final Exam = " + finalExam + " Midterm Exam = " + midtermExam + " Final Grade = " + getFinalGrade();
	}

	/*
	 * finalTest is a final exam grade, midtermTest is a midterm Exam grade, and hwGrades is an 
	 * array of homework grades. Assume that the number of valid homework grades in the array is
	 * the size of the array. Return final grade using the weighted values defined.
	 */
	public static double getFinalGrade(int finalTest, int midtermTest, int[] hwGrades) 
	{
		double hw_g = 0;
		for (int i= 0; i < hwGrades.length; i++)
		{
			hw_g += hwGrades[i];
		}
		
		if (hwGrades.length != 0)
		{
			hw_g = hw_g / hwGrades.length;
		}
		
		if (hwGrades.length == 0)
		{
			hw_g = 0;
		}
		
		if (midtermTest != 0 || hwGrades.length != 0 || finalTest != 0)
		{
			double f_grade = FINAL_EXAM_WEIGHT * finalTest + hw_g * HW_WEIGHT + MIDTERM_EXAM_WEIGHT * midtermTest;
			return f_grade;
		}
		else
		{
			return 0;
		}
	}

}
