/*
 * Name: Frank Huang
 * Date: 11/26/2022
 * For ICS3U7-01 Ms.Strelkovska
 * Class containing the information for the player.
 */

import java.util.*;

public class Player {
	private int total;
	private String name;
	private boolean isBust;
	private boolean isDone;
	private ArrayList<Integer> hand = new ArrayList<Integer>();

	public Player(String name) {
		total = 0;
		this.name = name;
		isBust = false;
		isDone = false;
	}

	public String getName() {
		return name;
	}

	public void draw(int card) {
		hand.add(card);
	}

	public int calcTotal() {
		total = 0;

		// Goes through all non-ace Cards
		for (int card : hand)
			if (Deck.getValue(card) != 0)
				total += Deck.getValue(card);
		// Goes through all aces at the end to make sure that the total does not bust
		// accidentally
		for (int card : hand)
			if (Deck.getValue(card) == 0) {
				if (total + 11 > 21)
					total++;
				else
					total += 11;
			}
		return total;
	}

	/*
	 * Checks if Dealer wants to hit. Allows implementation of computer players if
	 * necessary. Method not used for the player class.
	 */

	public ArrayList<Integer> getHand() {
		return hand;
	}

	public void reset() {
		hand.clear();
	}
	
	public int getTotal() {
		return total;
	}
	
	public boolean getIsBust() {
		return isBust;
	}
	
	public void setIsBust(boolean bool) {
		isBust = bool;
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(boolean bool) {
		isDone = bool;
	}
	
	public String toString() {
		String output = "";
		for (int card : getHand())
			output += Deck.getDesc(card) + " ";
		return output;
	}

}
