import java.awt.*;  
import java.awt.event.*; 
import javax.swing.*; 

public class MouseProcessing extends Frame implements MouseListener {
	
	//Member variables   
	private int click;
	private int clickreg;
	private int xlbound = 0;
	private int xubound = 0;
	private int ylbound = 0;
	private int yubound = 0;
	
	//constructor set up the region where clicks are going to be
	public MouseProcessing(int x, int y, int w, int h){  
		click = 0;
		clickreg = 0;
		addMouseListener(this);   
		xlbound = x+w-1;
		xubound = x;
		ylbound = y+h-1;
		yubound = y;
    	}  
	
	//increment the click (total clicks) and if is within the rectangle regoin, increment clickreg
	public void mouseClicked(MouseEvent e) {  	
		click ++;

		//compare the current click position (x and y) to the rectangle region, if clicks is within lower bound and upper bound, increment clickreg
		if (e.getX() <= xlbound && e.getX() >= xubound && e.getY() <= ylbound && e.getY() >= yubound)
		{
			clickreg++;
		}
    	}  
	
	//4 methods that not going to do anything
	public void mouseEntered(MouseEvent e) {  
	}
	public void mouseExited(MouseEvent e) {          
    	}
	public void mousePressed(MouseEvent e) {  
	}  
	public void mouseReleased(MouseEvent e) {  
        }   
	
	//return clicks in rectangle region
	public int getClicksInRegion()
	{
		return clickreg;
	}
	
	//return total clicks
	public double getTotalClicks()
	{
		return click;
	}
}  
