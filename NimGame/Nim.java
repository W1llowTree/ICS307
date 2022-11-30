/*
 * Frank Huang
 * For ICS3U7 Ms.Strelkovska
 * 10/25/2022
 * Nim game in which a number of stones is generated and the player and computer
 * alternate taking stones. The player taking the last stone loses.
 */
import java.util.*;

public class Nim {
	static Scanner input = new Scanner(System.in);
	static int stones; //Creates a global variable stones
	
	public static void main(String[] args) { 
		String playAgain = "";
		int compWin = 0;
		int playWin = 0;
		int gamesPlayed = 0;
		do {
			if (gamesPlayed > 0) //Allows for spacing after each game
				System.out.println();
			
			stones = genNum();
			while (stones > 0) {
				userTurn();
				if (stones < 1) {
					System.out.println("The computer beats the player!");
					compWin++;
					break;
				}
				compTurn();
				if (stones < 1) {
					System.out.println("The player beats the computer!");
					playWin++;
				}
			}
			gamesPlayed++;
			
			System.out.format("\nGames Played: %d\nPlayer Wins: %d\nComputer Wins %d\n", gamesPlayed, playWin, compWin);
			System.out.print("Do you want to play again?: ");
			playAgain = input.next().trim().toLowerCase();
		} while (playAgain.equals("yes"));
		
		System.out.println("Good Game!");
	}
	
	//Generates the number of starting stones
	public static int genNum() {
		return (int)(Math.random() * 16) + 15;
	}
	
	//Generates the number of stones the computer takes
	public static void compTurn() {
		int compStones = 0;
		int temp = stones;
		
		/*Determines ideal value. If the user makes a mistake, the computer plays optimally. Otherwise
		it takes away a random number.*/
		if (stones > 4) {
			if ((stones - 1) % 4 == 0)
				compStones = (int)(Math.random() * 3) + 1;
			else {
				while ((temp - 1) % 4 != 0) {
					compStones ++;
					temp--;
				}
			}
		}
		else {
			switch (stones) {
				case 1: compStones = 1; break;
				case 2: compStones = 1; break;
				case 3: compStones = 2; break;
				case 4: compStones = 3; break;
			}
		}
		System.out.println("There are " + stones + " stones. The computer takes " + compStones + " stones.");
		stones -= compStones;
	}
	
	//Manages user turn
	public static void userTurn() {		
		int userStones = 0;
		
		System.out.print("There are " + stones + " stones. How many would you like? ");
		userStones = input.nextInt();
		while ((userStones < 1 || userStones > 3) || userStones > stones) {
			System.out.print("Please enter a value of either 1-3 and more than or equal to the number of stones: ");
			userStones = input.nextInt();
		}
		stones -= userStones;
	}
	
	//checks for valid entry
}
