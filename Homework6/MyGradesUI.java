//package edu.fau.COT4930;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyGradesUI{

	public static void main(String args[ ])
	{
		final int FIELD_WIDTH = 20;
  		JFrame frame = new JFrame("Frame Test"); // a frame object is created

		// A textfiled object is created with initial text
		JTextField textField = new JTextField(FIELD_WIDTH);
		textField.setText("Click a button!");

		// A JButton is created with a text label
		JButton helloButton = new JButton("Say Hello");
		// An ActionListener object is added to the button using an anonymous class
		helloButton.addActionListener(new
   		ActionListener()
   		{
      			public void actionPerformed(ActionEvent event)
      			{
          			textField.setText("Hello World");
				System.out.println(event.getActionCommand() + "      " + event.paramString());
     			}
   		});

		JButton goodbyeButton = new JButton("Say Goodbye");
		goodbyeButton.addActionListener(new
   		ActionListener()
   		{
      			public void actionPerformed(ActionEvent event)
      			{
          			textField.setText("Goodbye World");
				System.out.println(event.getActionCommand() + "      " + event.paramString());
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

		// a layout for the frame object is selected
		frame.setLayout(new FlowLayout());

		// the button components and the textfield component is added to the frame
		frame.add(helloButton);
		frame.add(goodbyeButton);
		frame.add(textField);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();  // sizes the frames for the components contained
		frame.setVisible(true);


		//frame.remove(helloButton);  // this remove a component
		//frame.add(helloButton);     // adds to the end of the component list
		//frame.add(helloButton, 0);   // adds to the beginning
	}
}
