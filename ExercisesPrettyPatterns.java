/*
 * Frank Huang
 * 2022/10/09
 * For ICS3U7-01 Ms. Strelkovska
 * This file contains the code for Question 2-4. The file prompts the user for the number
 * of rows, and then creates a pattern with the input given.
 */

import java.util.*;

public class ExercisesPrettyPatterns {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numOfRows = 0;
		
		System.out.print("Enter the number of rows: ");
		numOfRows = input.nextInt();
		
		//Question 2
		for (int row = 0; row < numOfRows; row++) {
			for (int col = 1; col <= numOfRows - row; col++) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		System.out.println("");
		
		//Question 3
		for (int row = numOfRows; row > 0; row--) {
			System.out.print("  ");
			for (int col = numOfRows; col > 0; col--) {
				if (col <= row)
					System.out.print(col + " ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println("");
		
		//Question 4
		int width = 0;
		System.out.print("Enter the triangle width: ");
		width = input.nextInt();
		
		//Pyramid
		for (int row = 1; row <= width; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//Inverted Pyramid
		for (int row = width - 1; row > 0; row--) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		input.close();
	}
}
