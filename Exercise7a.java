/*
 * Frank Huang
 * 9/25/2022
 * For ICS3U7 Ms.Strelkovska
 * 
 * CubesSum Exercise 7 pg93 Part A
 * Prompt the user for an integer and check if it is equal to the sum of the cubes of its digits.
 */

import java.util.Scanner;

public class Exercise7a {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num = 0;
		int sumOfCubeDigits = 0;
		
		System.out.print("\nEnter a positive integer: ");
		num = input.nextInt();
		
		while (num > 0) {
			sumOfCubeDigits += (int)Math.pow(num % 10, 3);
			num /= 10;
		}
		
		System.out.println(sumOfCubeDigits);
	}
}
