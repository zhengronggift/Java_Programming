package edu.fau.COT4930;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Insets;
import java.awt.Image;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.Component;
import java.util.Arrays;
public class Deck {
	//set up the variables
	int next_card = 0;
	int num_left = 52;	
	Image[] javaImage = new Image[52];
	Image[] row = new Image[4];
	Image[] column = new Image[13];
	Card[] card_deck = new Card[52];
    	public Deck(Component comp, String fileCards) {
		BufferedImage im = null;
		int image_num = 0;
		try
		{
			//open file and read the data
			File f = new File(fileCards);

			im = ImageIO.read(f);

			ImageFilter crop;
			int y = 0;
			int x = 0;
			int card_num = 0;
			BufferedImage croppedImage = null;
			//get the row and save it
			for (int i = 0; i < 4; i ++){
        			croppedImage = im.getSubimage(0, y, 923, 95);
				ImageIO.write(croppedImage, "jpg", new File("row[" + i +"].jpg"));
				y += 96;
			}
			//retrieve the row and crop it
			for (int row_file = 0; row_file < 4; row_file ++)
			{				
				f = new File("row[" + row_file +"].jpg");
				for (int cln = 0; cln < 13; cln ++)
				{
					// crop each card and save them into the deck
					crop = new CropImageFilter(x, 0, 70, 95);
					im = ImageIO.read(f);
					column[cln] = comp.createImage(new FilteredImageSource(im.getSource(), crop));// get the image
					javaImage[image_num] = column[cln]; 
					card_deck[card_num] = new Card(row_file, cln, javaImage[image_num]); // save to the deck
					//System.out.println("row: " + row_file + "cloumn: " + cln);
					//croppedImage = im.getSubimage(x, 0, 70, 95);
					//ImageIO.write(croppedImage, "jpg", new File("image/row[" + (row_file+1) +"]column[" + (cln+1) +"].jpg"));
					x += 71;
					image_num ++;
					card_num ++;
				}
				x = 0;
			}
		}
		catch(IOException e)
		{
			System.out.println("Cannot find the image file");
		}
	}

    //shuffle the card, every shuffle reset the card numbers 
    public void shuffle(){
        Random rand = new Random(); 
        num_left = 52;
	//random shuffle
        for (int i = 0; i < 52; i++) 
        { 
            // Random for remaining positions. 
            int r = i + rand.nextInt(52 - i);               
             //swapping the elements 
             Image temp = javaImage[r]; 
             javaImage[r] = javaImage[i]; 
             javaImage[i] = temp; 
	     Card temp_card = card_deck[r];
	     card_deck[r] = card_deck[i];
	     card_deck[i] = temp_card;
           
        } 
 
    }
  
    // copy a card and return this card. add the counter for the next card call
    Card getNextCardInDeck(){
	if (next_card == 52)
	{
		next_card = 0;
	}
	Card card_backup = card_deck[next_card];
	next_card++;
	num_left--;
	//System.out.println("left card: " + num_left);
	return card_backup;
    }

    // return the number of card left
    int getNumberLeftInDeck(){
	if (num_left < 0)
	{
		num_left = 0;
	}
    	return num_left;
    }
}
