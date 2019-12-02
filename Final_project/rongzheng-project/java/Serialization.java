package edu.fau.COT4930;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.Serializable;
import java.lang.SecurityException;
import java.io.IOException;
import java.lang.ClassNotFoundException;

/**The Serialization is used to store user name and score.*/
public class Serialization implements Serializable
{
	private String name;
	private int score;

	/** Constructor to initialize the player */
	public Serialization()
	{
		name = "";
		score = 0;
	}
	/** Constructor to setup the player name and score */
	public Serialization(String n, int s)
	{
		name = n;
		score = s;
	}
	/** Method to get the player's name.
	    @return the name of the player.*/
	public String getName()
	{
		return name;
	}
	/** Method to get the player's score.
	    @return the score of the player.*/
	public int getScore()
	{
		return score;
	}
	/** Mutator */
	public void setName(String n)
	{
		name = n;
	}
	/** Mutator */
	public void setScore(int s)
	{
		score = s;
	}
	/** Mutator */
	public void display()
	{
		System.out.println("The Players name is " + getName() + " and the score is " + getScore());
		System.out.println("");
	}
}


