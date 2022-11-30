/*
 * Name: Frank Huang
 * Date: 11/26/2022
 * For ICS3U7-01 Ms.Strelkovska
 * Class containing the information for the deck.
 */

import java.util.*;

public class Deck {
	private ArrayList<Integer> deck;
	
	public Deck() {
		deck = new ArrayList<Integer>();
		deck.clear();
	}
	
	//Clears and fills deck
	public void newDeck() {
		deck.clear();
		for (int i = 0; i < 52; i++)
			deck.add(i);
	}
	
	// Shuffles the deck
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public int drawCard() {
		return deck.remove(0);
	}
	
	public int getSize() {
		return deck.size();
	}
	public String toString() {
		String output = "";
		
		for (int card : deck)
			output += getDesc(card) + " ";
		return output;
	}
	
	//Takes a card id and returns the card value
	public static int getValue(int id) {
		if (id % 13 == 1) // Identifies aces
			return 0;
		else if (id % 13 >= 1 && id % 13 <= 10)
			return id % 13;
		else
			return 10;
	}
	
	// Takes a card id and returns the description
	public static String getDesc(int id) {
		int suitNum = 0;
		int cardNum = 0;
		String desc = "";
		
		suitNum = id / 13;
		cardNum = id % 13;
		
		switch (suitNum) {
			case 0:
				desc = (char)3 + ""; break;
			case 1:
				desc = (char)4 + ""; break;
			case 2:
				desc = (char)5 + ""; break;
			case 3:
				desc = (char)6 + ""; break;
		}
		
		if (cardNum >= 2 && cardNum <= 10)
			desc = cardNum + desc;
		else {
			switch (cardNum) {
				case 0:
					desc = "K" + desc; break;
				case 1:
					desc = "A" + desc; break;
				case 11:
					desc = "J" + desc; break;
				case 12:
					desc = "Q" + desc; break;
			}
		}
		
		return desc;
	}
}
