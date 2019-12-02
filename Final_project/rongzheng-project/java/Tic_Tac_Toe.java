package edu.fau.COT4930;
import javax.swing.*;  
import java.awt.event.*;  
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.SecurityException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

/**The Tic_Tac_Toe is used to create the template and start the game.*/
@SuppressWarnings("serial")
public class Tic_Tac_Toe extends JFrame  implements ActionListener{
   // Named-constants for the game board
   public static final int ROWS = 3;  // ROWS by COLS cells
   public static final int COLS = 3;
 
   // Named-constants of the various dimensions used for graphics drawing
   public static final int CELL_SIZE = 180; // cell width and height (square)
   public static final int CANVAS_WIDTH = CELL_SIZE * COLS;  // the drawing canvas
   public static final int CANVAS_HEIGHT = CELL_SIZE * ROWS;
   public static final int GRID_WIDTH = 8;                   // Grid-line's width
   public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2; // Grid-line's half-width
   // Symbols (cross/nought) are displayed inside a cell, with padding from border
   public static final int CELL_PADDING = CELL_SIZE / 6;
   public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2; // width/height
   public static final int SYMBOL_STROKE_WIDTH = 8; // pen's stroke width
   
   // Store Player's name
   Player YourName = new Player();
   Player YourOpponentName = new Player();  

   // Store Player's score
   Serialization p1 = new Serialization();
   Serialization p2 = new Serialization();
   Serialization p3 = null;
   Serialization p4 = null;
   private int score1 = 0;
   private int score2 = 0;
   // Method use an enumeration (inner class) to represent the various states of the game 
   public enum GameState {
      PLAYING, DRAW, CROSS_WON, NOUGHT_WON
   }
   private GameState currentState;  // the current game state
 
   // Use an enumeration (inner class) to represent the seeds and cell contents
   public enum Seed {
      EMPTY, CROSS, NOUGHT
   }
   private Seed currentPlayer;  // the current player
 
   private Seed[][] board   ; // Game board of ROWS-by-COLS cells
   private DrawCanvas canvas; // Drawing canvas (JPanel) for the game board
   private JLabel statusBar;  // Status Bar
   private JButton newGameBar;  // New Game Butoon
   private JButton helpBar;  // Help Button
   /** Constructor to setup the game and the GUI components */
   public Tic_Tac_Toe() {
      canvas = new DrawCanvas();  // Construct a drawing canvas (a JPanel)
      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
 
      // The canvas (JPanel) fires a MouseEvent upon mouse-click
      canvas.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {  // mouse-clicked handler
            int mouseX = e.getX();
            int mouseY = e.getY();
            // Get the row and column clicked
            int rowSelected = mouseY / CELL_SIZE;
            int colSelected = mouseX / CELL_SIZE;
 
            if (currentState == GameState.PLAYING) {
               if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0
                     && colSelected < COLS && board[rowSelected][colSelected] == Seed.EMPTY) {
                  board[rowSelected][colSelected] = currentPlayer; // Make a move
                  updateGame(currentPlayer, rowSelected, colSelected); // update state
                  // Switch player
                  currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
               }
            } else {       // game over
               initGame(); // restart the game
            }
            // Refresh the drawing canvas
            repaint();  // Call-back paintComponent().
         }
      });
 
      // Setup the status bar (JLabel) to display status message
      statusBar = new JLabel("  ");
      statusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
      statusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
      
      newGameBar = new JButton("Start A New Game");
      newGameBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
      newGameBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
      newGameBar.addActionListener(this); // Add listener for the click
      
      helpBar = new JButton("Help Menu");
      helpBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
      helpBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
      helpBar.addActionListener(this); // Add listener for the click
      
      Container cp = getContentPane();
      cp.setLayout(new BorderLayout());
      cp.add(canvas, BorderLayout.SOUTH);
      cp.add(statusBar, BorderLayout.EAST); // same as SOUTH
      cp.add(newGameBar, BorderLayout.WEST); 
      cp.add(helpBar, BorderLayout.CENTER); 
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();  // pack all the components in this JFrame
      setTitle("Tic Tac Toe");
      setVisible(true);  // show this JFrame
 
      board = new Seed[ROWS][COLS]; // allocate array
      initGame(); // initialize the game board contents and game variables
   }
  
  /** Method listen for click event */
  public void actionPerformed(ActionEvent e){
	  if(e.getSource() == helpBar) {
		 // create a jframe
    		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    
    		// show a joptionpane dialog using showMessageDialog
    		JOptionPane.showMessageDialog(frame,
        		"Game Rule: \n  Each Player takes a turn\n  Start off with Red player\n  Winner gets a score of 10\nCurrent status:\n"
		+ "  Player: " + p1.getName() + " Score: " + p1.getScore() + "\n  Player: " + p2.getName() + " Score: " + p2.getScore());
	  }
	  if(e.getSource() == newGameBar) {
		//statusBar.setText("New Game");  
                String name = JOptionPane.showInputDialog(
                        "What is your name?", null);
		YourName.setName(name);
		p1.setName(name);
		p1.setScore(0);
		score1 = 0;
		statusBar.setForeground(Color.RED);
	        String your_turn = "Player: " + YourName.getName() + " Score: " + p1.getScore();
                statusBar.setText(your_turn);
		String name2 = JOptionPane.showInputDialog(
                        "What is your opponent's name?", null);
		YourOpponentName.setName(name2);
		p2.setName(name2);
		p2.setScore(0);
		score2 = 0;
		saveData();
	  }
	   
   }  
   
   /** Initialize the game-board contents and the status */
   public void initGame() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            board[row][col] = Seed.EMPTY; // all cells empty
         }
      }
      currentState = GameState.PLAYING; // ready to play
      currentPlayer = Seed.CROSS;       // cross plays first
   }
 
   /** Update the currentState after the player with "theSeed" has placed on
       (rowSelected, colSelected). */
   public void updateGame(Seed theSeed, int rowSelected, int colSelected) {
      if (hasWon(theSeed, rowSelected, colSelected)) {  // check for win
         currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
      } else if (isDraw()) {  // check for draw
         currentState = GameState.DRAW;
      }
      // Otherwise, no change to current state (still GameState.PLAYING).
   }
 
   /**  Method determines if the game end in draw.
	@return true if it is a draw (i.e., no more empty cell). */
   public boolean isDraw() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLS; ++col) {
            if (board[row][col] == Seed.EMPTY) {
               return false; // an empty cell found, not draw, exit
            }
         }
      }
      return true;  // no more empty cell, it's a draw
   }
 
   /**  Method determines if the player is won.
	@return true if the player with "theSeed" has won after placing at
       (rowSelected, colSelected) */
   public boolean hasWon(Seed theSeed, int rowSelected, int colSelected) {
      return (board[rowSelected][0] == theSeed  // 3-in-the-row
            && board[rowSelected][1] == theSeed
            && board[rowSelected][2] == theSeed
       || board[0][colSelected] == theSeed      // 3-in-the-column
            && board[1][colSelected] == theSeed
            && board[2][colSelected] == theSeed
       || rowSelected == colSelected            // 3-in-the-diagonal
            && board[0][0] == theSeed
            && board[1][1] == theSeed
            && board[2][2] == theSeed
       || rowSelected + colSelected == 2  // 3-in-the-opposite-diagonal
            && board[0][2] == theSeed
            && board[1][1] == theSeed
            && board[2][0] == theSeed);
   }
 
   /**
    *  Inner class DrawCanvas (extends JPanel) used for custom graphics drawing.
    */
   class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {  // invoke via repaint()
         super.paintComponent(g);    // fill background
         setBackground(Color.WHITE); // set its background color
 
         // Draw the grid-lines
         g.setColor(Color.LIGHT_GRAY);
         for (int row = 1; row < ROWS; ++row) {
            g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF,
                  CANVAS_WIDTH-1, GRID_WIDTH, GRID_WIDTH, GRID_WIDTH);
         }
         for (int col = 1; col < COLS; ++col) {
            g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0,
                  GRID_WIDTH, CANVAS_HEIGHT-1, GRID_WIDTH, GRID_WIDTH);
         }
 
         // Draw the Seeds of all the cells if they are not empty
         // Use Graphics2D which allows us to set the pen's stroke
         Graphics2D g2d = (Graphics2D)g;
         g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND,
               BasicStroke.JOIN_ROUND));  // Graphics2D only
         for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
               int x1 = col * CELL_SIZE + CELL_PADDING;
               int y1 = row * CELL_SIZE + CELL_PADDING;
               if (board[row][col] == Seed.CROSS) {
                  g2d.setColor(Color.RED);
                  int x2 = (col + 1) * CELL_SIZE - CELL_PADDING;
                  int y2 = (row + 1) * CELL_SIZE - CELL_PADDING;
                  g2d.drawLine(x1, y1, x2, y2);
                  g2d.drawLine(x2, y1, x1, y2);
               } else if (board[row][col] == Seed.NOUGHT) {
                  g2d.setColor(Color.BLUE);
                  g2d.drawOval(x1, y1, SYMBOL_SIZE, SYMBOL_SIZE);
               }
            }
         }
         // Print status-bar and menu message 
         if (currentState == GameState.PLAYING) {
            statusBar.setForeground(Color.BLACK);
	    readData();
		YourName.setName(p4.getName());
		p1.setName(p4.getName());
		p1.setScore(p4.getScore());
		score1 = p4.getScore();
		YourOpponentName.setName(p3.getName());
		p2.setName(p3.getName());
		p2.setScore(p3.getScore());
		score2 = p3.getScore();
            if (currentPlayer == Seed.CROSS) {
	       statusBar.setForeground(Color.RED);
	       String your_turn = "Player: " + YourName.getName() + " Score: " + score1;
               statusBar.setText(your_turn);
            } else {
	       statusBar.setForeground(Color.BLUE);
	       String opponent_turn= "Player: " + YourOpponentName.getName() + " Score: " + score2;
               statusBar.setText(opponent_turn);
            }
         } else if (currentState == GameState.DRAW) {
            statusBar.setForeground(Color.ORANGE);
            statusBar.setText("It's a Draw! Click to play again.");
         } else if (currentState == GameState.CROSS_WON) {
            statusBar.setForeground(Color.RED);
	    String you_won = YourName.getName() + " Won! Score: " + p1.getScore() + " (+10)";
            statusBar.setText(you_won);
	    score1 += 10;
	    p1.setScore(score1);
	    saveData();
         } else if (currentState == GameState.NOUGHT_WON) {
            statusBar.setForeground(Color.BLUE);
	    String oppo_won = YourOpponentName.getName() + " Won! Score: " + p2.getScore() + " (+10)";
            statusBar.setText(oppo_won);
	    score2 += 10;
	    p2.setScore(score2);
	    saveData();
         }
      }
   }
   /** Method to save the players data and output to Player.dat.*/
   public void saveData(){
     		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Player.dat"));
			out.writeObject(p1);
			out.writeObject(p2);
			out.close();
		}
		catch (SecurityException e)
		{
			System.out.println("Serialization save error 1");
		}
		catch (IOException e)
		{
			System.out.println("Serialization save error 2");
		}
   }
   /** Method to read the players data and stored as p3 and p4.*/
   public void readData(){
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Player.dat"));
			// objects are read out in the order they were read in
			p3 = (Serialization) in.readObject();
			p4 = (Serialization) in.readObject();
			in.close();
		}
		catch (SecurityException e)
		{
			System.out.println("Serialization restore error 1");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Serialization restore error 2");
		}
		catch (IOException e)
		{
			System.out.println("Serialization restore error 3");
		}

   }

   /** The entry main() method */
   public static void main(String[] args) {
      // Run GUI codes in the Event-Dispatching thread for thread safety
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Tic_Tac_Toe(); // Let the constructor do the job
         }
      });
   }
}
