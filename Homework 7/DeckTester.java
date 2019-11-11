
//package edu.fau.COT4930;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Insets;
import java.awt.Image;

public class DeckTester extends JPanel
{
	Thread thr;
	int sizeX = 800;
	int sizeY = 660;
	Image offscrImg;
	Graphics offscrGC;
	Card c;
	Deck d;

	public static void main(String[] args) 
	{

  		DeckTester dt = new DeckTester();
  		JFrame f = new JFrame("Rong Zheng");
 
  		dt.setSize(dt.sizeX, dt.sizeY);
  		f.add(dt);
 		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		Insets insets = f.getInsets();
		f.setSize(dt.sizeX + insets.left + insets.right, dt.sizeY + insets.top + insets.bottom);
		dt.init();
		f.setVisible(true);
  	}
	public void init()
	{
		d = new Deck(this, "cards.gif");
		offscrImg = this.createImage(sizeX, sizeY);
		offscrGC = offscrImg.getGraphics();
		for(int i = 0; i < 52; i++)
		{
			c = d.getNextCardInDeck();
			offscrGC.drawImage(c.getImage(), (i % 13) * 30, (i/13) * 30, this);
		}

		d.shuffle();
		int[] cards = new int[52];
		int randomCount = 0;
		for(int i = 0; i < 52; i++)
		{
			c = d.getNextCardInDeck();
			offscrGC.drawImage(c.getImage(), (i % 13) * 30, ((i/13) * 30) + 200, this);
			int cardNum = c.getSuit()*13 + c.getValue();
			System.out.println("cardnum for getsuit and getval " + cardNum);
			if ((cardNum >= 0) && (cardNum < 52))
			{
				cards[cardNum]++;
			}
			if (i == cardNum)
			{
				randomCount++;
			} 
		}
		repaint();

		// test cases start here
		int testCount = 1;

		// if shuffled cards were in order then
		if (randomCount < 52)
			System.out.println("Test case " + testCount + " Passed");
		else
			System.out.println("Test case " + testCount + " Failed");
		testCount++;

		// if shuffled cards were all accounted for then
		boolean fail = false;
		for(int i = 0; i < 52; i++)
		{
			System.out.println("cards i " + cards[i]);
			if(cards[i] != 1)
			{
				System.out.println("Test case " + testCount + " Failed");
				fail = true;
				break;
			} 
		}
		if (fail == false)
			System.out.println("Test case " + testCount + " Passed");
		testCount++;

		// test for 0 cards in deck
		if (d.getNumberLeftInDeck() == 0)
			System.out.println("Test case " + testCount + " Passed");
		else
			System.out.println("Test case " + testCount + " Failed");
		testCount++;

		// test for shuffled deck
		d.shuffle();
		if (d.getNumberLeftInDeck() == 52)
			System.out.println("Test case " + testCount + " Passed");
		else
			System.out.println("Test case " + testCount + " Failed");
		testCount++;

		// test for shuffled deck
		c = d.getNextCardInDeck();
		if (d.getNumberLeftInDeck() == 51)
			System.out.println("Test case " + testCount + " Passed");
		else
			System.out.println("Test case " + testCount + " Failed");
		testCount++;
	}
	@Override
  	public void paint(Graphics g)
   	{
		g.setColor(Color.white);
		g.fillRect(0, 0, sizeX, sizeY);
		g.drawImage(offscrImg, 0, 0, this);
    	}
	@Override
	public void update(Graphics g)
	{
		paint(g);
	}
}
