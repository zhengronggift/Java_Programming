import java.awt.*;

public class Card {

    private Image picture;
    private int value;
    private int suit;

    public Card(int s, int v, Image im) {
        suit = s;
        value = v;
        picture = im;
    }

    // Method return the image of the card
    public Image getImage() {
        return picture;
    }

    // method returns the value of the card
    public int getValue() {
        return value;
    }
    
    //method returns the suit of the card
    public int getSuit() {
        return suit;
    }
}
