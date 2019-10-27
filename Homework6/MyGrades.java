package edu.fau.COT4930;
public class MyGrades
{
	// Constructors
	public MyGrades()
	{ // initialize the member variables
		finalExam = 0;
		midtermExam = 0;
		numberOfHomeworks = 0;
		hw = new int[DEFAULT_NUM_HW];
	}

	// mutators
	public void setFinalExam(int grade)
	{ // set the finalExam grade
		finalExam = grade;
	}
	public void setMidtermExam(int grade)
	{ // set the midtermExam grade
		midtermExam = grade;
	}
	public void setHomework(int grade)
	{
		if (numberOfHomeworks == hw.length)
		{ // if there is not enough capacity in the array then
			int[] temp = new int[hw.length * 2];
			for (int i = 0; i < numberOfHomeworks; i++)
			{ // copy the current hw grades to the temp array
				temp[i] = hw[i];
			}
			hw = temp; // reposition the new array
		}
		hw[numberOfHomeworks] = grade;
		numberOfHomeworks++;
	}

	// accessors
	public double getFinalGrade()
	{
		double ave;
		int sum = 0;
		for (int i = 0; i < numberOfHomeworks; i++)
		{ // get the homework sum
			sum = sum + hw[i];
		}
		if (numberOfHomeworks != 0)
		{ // if there are hw assignments then no divide by zero issue
			ave = (MIDTERM_EXAM_WEIGHT * midtermExam) + (FINAL_EXAM_WEIGHT * finalExam) + (HW_WEIGHT * (sum / (double)numberOfHomeworks));
		}
		else
		{ // else do not include HW average
			ave = (MIDTERM_EXAM_WEIGHT * midtermExam) + (FINAL_EXAM_WEIGHT * finalExam);
		}
		return ave;
	}
	public boolean equals(MyGrades g)
	{
		boolean rv = true; // default to true
		if ((finalExam != g.finalExam) || (midtermExam != g.midtermExam) || (numberOfHomeworks != g.numberOfHomeworks))
		{ // if exams and array length the same then check the homeworks
			rv = false;
		}
		for (int i = 0; i < numberOfHomeworks; i++)
		{ // check all the homeworks
			if (hw[i] != g.hw[i])
			{ // if any are not the same then not equal and stop
				rv = false;
				break; // once a homewotk is different then end
			}
		}
		return rv;
	}
	@Override
	public String toString()
	{
		return ("Final Exam = " + finalExam + " Midterm Exam = " + midtermExam + " Final Grade = " + getFinalGrade());
	}
	public static double getFinalGrade(int finalTest, int midtermTest, int[] hwGrades)
	{
		double sum = 0;
		for(int i = 0; i < hwGrades.length; i++)
		{ // sum the hw grades
			sum = sum + hwGrades[i];
		}
		double hwAve;
		if (hwGrades.length == 0)
		{ // if no hw grades then average is 0
			hwAve = 0;
		}
		else
		{ // otherwise find the average
			hwAve = sum/hwGrades.length;
		}
		return((finalTest * MyGrades.FINAL_EXAM_WEIGHT) + (midtermTest * MIDTERM_EXAM_WEIGHT) + (hwAve * HW_WEIGHT));
	}

	// member variables
	private final int DEFAULT_NUM_HW = 3;
	private int[] hw;
	private int finalExam;
	private int midtermExam;
	private int numberOfHomeworks;

	// static variables
	public final static double FINAL_EXAM_WEIGHT = .25;
	public final static double MIDTERM_EXAM_WEIGHT = .25;
	public final static double HW_WEIGHT = .5;
};
