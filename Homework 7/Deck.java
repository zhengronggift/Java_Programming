
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
public class Deck {
	int sizeX = 800;
	int sizeY = 660;
	int next_card = 0;
	int num_left = 52;
	int card_num = 0;
	Image offscrImg;	
	Image[] javaImage = new Image[52];
	Graphics offscrGC;
	Image[] row = new Image[4];
	Image[] column = new Image[13];
	Card[] card_deck = new Card[52];
    	public Deck(Component comp, String fileCards) {
		BufferedImage im = null;
		int image_num = 0;
		try
		{
			File f = new File(fileCards);

			im = ImageIO.read(f);

			ImageFilter crop;
			int y = 0;
			int x = 0;

			BufferedImage croppedImage = null;
			for (int i = 0; i < 4; i ++){
        			croppedImage = im.getSubimage(0, y, 923, 95);
				ImageIO.write(croppedImage, "jpg", new File("row[" + i +"].jpg"));
				y += 96;
			}
			for (int row_file = 0; row_file < 4; row_file ++)
			{				
				f = new File("row[" + row_file +"].jpg");
				for (int cln = 0; cln < 13; cln ++)
				{
					crop = new CropImageFilter(x, 0, 70, 95);
					im = ImageIO.read(f);
					column[cln] = comp.createImage(new FilteredImageSource(im.getSource(), crop));
					javaImage[image_num] = column[cln];
					card_deck[card_num] = new Card(row_file, (cln+1), javaImage[image_num]);
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

    public void shuffle(){
        Random rand = new Random(); 
          
        for (int i = 0; i < 52; i++) 
        { 
            // Random for remaining positions. 
            int r = i + rand.nextInt(52 - i); 
              
             //swapping the elements 
             Image temp = javaImage[r]; 
             javaImage[r] = javaImage[i]; 
             javaImage[i] = temp; 
               
        } 
 
    }
  

    Card getNextCardInDeck(){
	if (next_card == 52)
	{
		next_card = 1;
	}
	Card deck = new Card(0, 0, javaImage[next_card]);
	//card_deck[next_card];
	
	//System.out.println(num_left);
		
	//card_deck[i];
	//if (next_card == 52)
	//{
	//	next_card = 0;
	//}
	//Card deck = card_deck[next_card];
	next_card++;
	//System.out.println(next_card);
	return deck;
    }

    int getNumberLeftInDeck(){
    	return num_left;
    }
}
