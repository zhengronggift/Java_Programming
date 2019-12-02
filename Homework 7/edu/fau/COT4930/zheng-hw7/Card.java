package edu.fau.COT4930;
import java.awt.*;

public class Card {

    private Image picture;
    private int value;
    private int suit;
    
    // initialize the image and values
    public Card(int s, int v, Image im) {
        this.suit = s;
        this.value = v;
        this.picture = im;
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
