/*
 * Name: Frank Huang
 * Date: 11/26/2022
 * For ICS3U7-01 Ms.Strelkovska
 * Main Class running the game logic and inital set-up. This version of the game involves the player
 * finishing their turn before the dealer starts their turn.
 */

import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String name;
		
		//Initial set-up information
		System.out.print("Enter your name: ");
		name = sc.nextLine();
		Player user = new Player(name);
		System.out.println();
		Dealer dealer = new Dealer();
		
		//Game
		Game.run(user, dealer);
		
		System.out.println();
		System.out.println("Thanks for playing!");
		sc.close();
	}
}
