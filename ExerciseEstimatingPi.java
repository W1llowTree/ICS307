/*
 * Frank Huang
 * 2022/10/09
 * For ICS3U7-01 Ms. Strelkovska
 * This file contains the code for Question 5 Estimating Pi. It takes in an input
 * for n number of terms, and then the n terms and estimates the value of pi with those
 * values.
 */

import java.util.*;

public class ExerciseEstimatingPi {
	//Function taking 2 integers as parameters and returning if they are relatively prime
	static boolean isRelativelyPrime(int a, int b) {
		boolean isRelativelyPrimeBool = true;
		for (int i = 2; i <= a; i++) {
			if (a % i == 0 && b % i == 0) {
				isRelativelyPrimeBool = false;
				break;
			}
		}
		return isRelativelyPrimeBool;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Declaration Block
		int numOfTerms = 0;
		int primePairCounter = 0;
		int totalPairCounter = 0;
		int num = 0;
		double pi = 0;
		
		//Input
		System.out.print("Enter the number of terms: ");
		numOfTerms = input.nextInt();
		
		int[] array = new int[numOfTerms];
		
		System.out.print("Enter the terms: ");
		for (int i = 0; i < numOfTerms; i++) {
			num = input.nextInt();
			array[i] = num;
		}
		
		//Calculation
		totalPairCounter = numOfTerms * (numOfTerms - 1) / 2;
		
		for (int i = 0; i < numOfTerms - 1; i++) {;
			for (int j = i+1; j < numOfTerms; j++) {
				if (isRelativelyPrime(array[i], array[j]))
					primePairCounter++;
			}
		}
		
		pi = Math.sqrt(6.0 * totalPairCounter / primePairCounter);
		
		//Output
		System.out.println(pi);
		
		input.close();
	}
}
