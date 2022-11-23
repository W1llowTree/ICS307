/*
 * Frank Huang
 * 9/25/2022
 * For ICS3U7 Ms.Strelkovska
 * 
 * CubesSum Exercise 7 pg93 Part B
 * Determine the 2, 3, and 4-digit integers that are equal to the sum of the cubes of its digits.
 */

import java.util.Scanner;

public class Exercise7b {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int index = 10;
		int num = 0;
		int sumOfCubeDigits = 0;
		
		while (index < 10000) {
			num = index;
			sumOfCubeDigits = 0;
			while (num > 0) {
				sumOfCubeDigits += (int)Math.pow(num % 10, 3);
				num /= 10;
			}
			
			if (index == sumOfCubeDigits)
				System.out.println(index + " is equal to the sum of the cubes of its digits.");
			
			index++;
		}
	}
}	
