/*
 * Name: Frank Huang
 * Date: 11/26/2022
 * For ICS3U7-01 Ms.Strelkovska
 * Class containing the information for the dealer.
 */

public class Dealer extends Player {

	public Dealer() {
		super("Dealer");
	}

	public int firstCardValue() {
		if (Deck.getValue(super.getHand().get(0)) == 0)
			return 11;
		return Deck.getValue(super.getHand().get(0));
	}

	public String finalHand() {
		String output = "";
		for (int card : super.getHand())
			output += Deck.getDesc(card) + " ";
		return output;
	}
	
	public boolean isHit() {
		calcTotal();
		if (getTotal() < 17)
			return true;
		return false;
	}
	
	public String toString() {
		String output = "";
		output += Deck.getDesc(super.getHand().get(0));
		for (int i = 1; i < super.getHand().size(); i++)
			output += " ?";
		return output;
	}
}
