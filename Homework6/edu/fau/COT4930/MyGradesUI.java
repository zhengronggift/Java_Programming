package edu.fau.COT4930;
import javax.swing.*;  
import java.awt.event.*;  

public class MyGradesUI{

	public static void main(String args[ ])
	{
		//Initalize MyGrades with constructor
		MyGrades myGrade = new MyGrades();
		final int FIELD_WIDTH = 30;
  		JFrame frame = new JFrame("Homework 6"); // a frame object is created
		
		//Set up JTextArea
       		JTextArea textArea=new JTextArea("Homework 6 by Rong Zheng");  
       	        textArea.setBounds(70,100,250,200);  

		// A textfiled object is created with initial text
		JTextField textField = new JTextField(FIELD_WIDTH);

    		JLabel l1=new JLabel();  
    		l1.setBounds(70,10,200,30); 
                l1.setText("Enter A Grade Here: ");   
		textField.setBounds(220,10,120,30);  
		textField.setText("");

		// A JButton is created with a text label
		JButton finalButton = new JButton("Set Final");
		finalButton.setBounds(70,50,120,30);  

		// An ActionListener object is added to the button using an anonymous class
		finalButton.addActionListener(new
   		ActionListener()
   		{
      			public void actionPerformed(ActionEvent event)
      			{
				//get text from the box and convert string to int
          			String fGrade = textField.getText();
				int finalGrade=Integer.parseInt(fGrade);  

				myGrade.setFinalExam(finalGrade);
				textArea.setText("set final exam grade to " + finalGrade);
				System.out.println(event.getActionCommand() + "set final exam grade to " + finalGrade + " " + event.paramString());
     			}
   		});

		JButton midtermButton = new JButton("Set Midterm");
		midtermButton.setBounds(200,50,120,30);  
		midtermButton.addActionListener(new
   		ActionListener()
   		{
      			public void actionPerformed(ActionEvent event)
      			{
				//get text from the box and convert string to int
          			String mGrade = textField.getText();
				int midtermGrade=Integer.parseInt(mGrade);  
				myGrade.setMidtermExam(midtermGrade);
				textArea.setText("set midterm exam grade to " + midtermGrade);
				System.out.println(event.getActionCommand() + "set midterm exam grade to " + midtermGrade + " " + event.paramString());
     			}
   		});

		JButton homeworkButton = new JButton("Set Homework");
		homeworkButton.setBounds(330,50,140,30); 
		homeworkButton.addActionListener(new
   		ActionListener()
   		{
      			public void actionPerformed(ActionEvent event)
      			{
				//get text from the box and convert string to int
          			String hGrade = textField.getText();
				int homeworkGrade=Integer.parseInt(hGrade);  
				myGrade.setHomework(homeworkGrade);
				textArea.setText("Added homework grade: " + homeworkGrade);
				System.out.println(event.getActionCommand() + "set homework grade to " + homeworkGrade + " " + event.paramString());
     			}
   		});

		// A JButton is created with a text label
		JButton getFgradeButton = new JButton("Get Final Grade");
		getFgradeButton.setBounds(100,300,120,30);  

		// An ActionListener object is added to the button using an anonymous class
		getFgradeButton.addActionListener(new
   		ActionListener()
   		{
      			public void actionPerformed(ActionEvent event)
      			{
				//get text from the box and convert string to int
				double gfinalGrade = myGrade.getFinalGrade();
				textArea.setText("The Final Grade is: " + gfinalGrade);
				System.out.println(event.getActionCommand() + "set final exam grade to " + gfinalGrade + " " + event.paramString());
     			}
   		});

		// add an action Listener to the textfield and print out text items to the console
		textField.addActionListener(new
   		ActionListener()
   		{
      			public void actionPerformed(ActionEvent event)
      			{
          			System.out.println(textField.getText());
				System.out.println(event.getActionCommand() + "      " + event.paramString());
     			}
   		});

		// a layout for the frame object is selected\

		// the button components and the textfield component is added to the frame 
		frame.add(finalButton);
		frame.add(l1);
		frame.add(midtermButton);
		frame.add(homeworkButton);
		frame.add(getFgradeButton);
		frame.add(textField);
		frame.add(textArea);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();  // sizes the frames for the components contained
		frame.setSize(550,450); 
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
