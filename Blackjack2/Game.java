/*
 * Name: Frank Huang
 * Date: 11/26/2022
 * For ICS3U7-01 Ms.Strelkovska
 * Class containing basic game logic.
 */

import java.util.*;

public class Game {
	//Game Logic
	public static void run(Player player, Dealer dealer) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String isPlayAgain = "Y";
		int roundNum = 1;
		Player[] party = {player, dealer};
		
		Deck deck = new Deck();
		
		printDeckInfo(deck);
		
		while (isPlayAgain.equalsIgnoreCase("Y")) {

			// Resets hand and draws a new hand. Resets deck if fewer than 10 cards.
			if (deck.getSize() < 10) {
				deck.newDeck();
				deck.shuffle();
			}
			
			//Resetting Players
			for (Player i : party) {
				i.reset();
				i.setIsBust(false);
				i.setIsDone(false);
			}
			
			Game.round(player, dealer, deck, roundNum);
			isPlayAgain = sc.next().trim();
			roundNum++;
		}
	}
	
	//Printing Deck Info
	public static void printDeckInfo(Deck deck) {
		// Creating and printing the unshuffled deck
		System.out.println("Unshuffled Deck");
		deck.newDeck();
		System.out.println(deck);
		System.out.println();

		// Shuffling deck and printing shuffled deck
		System.out.println("Shuffled Deck");
		deck.shuffle();
		System.out.println(deck);
		System.out.println();
	}
	
	//Round Logic
	public static void round(Player player, Dealer dealer, Deck deck, int roundNum) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String response; // Player response for hit/stand
		
		for (int i = 0; i < 2; i++) {
			player.draw(deck.drawCard());
			dealer.draw(deck.drawCard());
		}
		
		// Displays hands
		System.out.println("=================== Round " + roundNum + " ===================");
		System.out.format("Dealer's hand: %s [sum: > %d]", dealer, dealer.firstCardValue());
		System.out.println();
		System.out.format("%s's hand: %s [sum: %d]", player.getName(), player, player.calcTotal());
		System.out.println();
		System.out.println();

		while (!player.getIsDone()) {
			// Hit or stand
			System.out.print("Hit or stand? ");
			response = sc.next().trim();

			// Player isHit
			if (response.equalsIgnoreCase("hit")) {
				player.draw(deck.drawCard());
				if (player.calcTotal() <= 21)
					System.out.format("%s's hand: %s [sum: %d]\n", player.getName(), player, player.calcTotal());
				else {
					System.out.format("%s's hand: %s. %s busted with %d\n", player.getName(), player, player.getName(), player.calcTotal());
					player.setIsBust(true);
					player.setIsDone(true);
				}
			}
			else
				player.setIsDone(true);
		}
		
		while (!dealer.getIsDone()) {
			// Dealer isHit
			if (dealer.isHit()) {
				dealer.draw(deck.drawCard());
				if (dealer.calcTotal() <= 21)
					System.out.format("Dealer's hand: %s [sum: > %d] Dealer hit!\n", dealer, dealer.firstCardValue());
				else {
					System.out.println("Dealer busts with " + dealer.calcTotal() + "!");
					dealer.setIsBust(true);
					dealer.setIsDone(true);
				}
			} 
			else {
				System.out.format("Dealer's hand: %s [sum: > %d] Dealer stands!\n", dealer, dealer.firstCardValue());
				dealer.setIsDone(true);
			}
		}

		// Tells a joke
		System.out.println("-----------------------------------------------");
		System.out.println("The dealer says " + Jokes.nextJoke());
		System.out.println("===============================================");

		// Results
		if (player.getIsBust())
			System.out.println("The dealer wins!");
		else if (dealer.getIsBust())
			System.out.println(player.getName() + " wins!");
		else {
			if (player.calcTotal() > dealer.calcTotal())
				System.out.println(player.getName() + " wins!");
			else if (player.calcTotal() == dealer.calcTotal())
				System.out.println("Push! Tie.");
			else
				System.out.println("The dealer wins!");

		}

		System.out.println();
		System.out.println("Results:");
		System.out.println();
		System.out.format("Dealer's hand: %s [sum: %d]", dealer.finalHand(), dealer.calcTotal());
		System.out.println();
		System.out.format("%s's hand: %s [sum: %d]", player.getName(), player, player.calcTotal());
		System.out.println();

		// Play again
		System.out.print("Play Again? [Y/N] ");

	}
}
