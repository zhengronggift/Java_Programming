
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

public class ImageDemo extends JPanel
{
	int sizeX = 950;
	int sizeY = 660;
	Image offscrImg;
	Image[] row = new Image[4];
	Image[] column = new Image[13];
	Graphics offscrGC;

	public static void main(String[] args) 
	{

  		ImageDemo id = new ImageDemo();
  		JFrame f = new JFrame("Showing Java Images");
 
  		id.setSize(id.sizeX, id.sizeY);
  		f.add(id);
 		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		Insets insets = f.getInsets();
		f.setSize(id.sizeX + insets.left + insets.right, id.sizeY + insets.top + insets.bottom);
		id.init();
		f.setVisible(true);
  	}
	public void init()
	{
		BufferedImage im = null;
		try
		{

			File f = new File("cards.gif");

			// get the image from the file
			im = ImageIO.read(f);

			ImageFilter crop;

			// crop a portion of the image
			/*for (int i = 0; i < 4; i ++)
			{
				crop = new CropImageFilter(0, y, 924, 95);
				row[i] = this.createImage(new FilteredImageSource(im.getSource(), crop));
				ImageIO.write(row[i],"jpg", "row1.jpg");
				y += 95;
			}
			int x = 0;*/
			//for (int k = 0; k < 12; k ++)
			//{
			/*	crop = new CropImageFilter(x, 0, 70, 95);
				column[0] = this.createImage(sizeX, sizeY);
				x += 70;*/
			//}
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
					column[cln] = this.createImage(new FilteredImageSource(im.getSource(), crop));
					croppedImage = im.getSubimage(x, 0, 70, 95);
					ImageIO.write(croppedImage, "jpg", new File("row[" + (row_file+1) +"]column[" + (cln+1) +"].jpg"));
					x += 71;
				}
				x = 0;
			}
		}
		catch(IOException e)
		{
			System.out.println("Cannot find the image file");
		}

		
		offscrImg = this.createImage(sizeX, sizeY);
		offscrGC = offscrImg.getGraphics();

		// write the image and text
		//offscrGC.drawImage(im, 10, 10, this);
		//offscrGC.drawString("This is the whole Image", 10, 590);

		// write the cropped image and text
		int y = 0;
		//for (int i = 0; i < 4; i++){
			
			//offscrGC.drawImage(row[i], 0, y, this);
			//offscrGC.drawString("This is a cropped Image of the same size", 370, 190);
			//y += 95;

			//offscrGC.drawImage(column[0], 0, y, this);
			//offscrGC.drawString("This is a cropped Image of the same size", 370, 190);
			//y += 95;
		//}

		repaint();


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
