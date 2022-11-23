/*
 * Frank Huang
 * 2022/10/09
 * For ICS3U7-01 Ms. Strelkovska
 * This file contains the code for Question 1. The code estimates pi with a series expansion
 */

import java.util.*;

public class Exercise1Pi {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Question 1
		//Declaration Block
		double pi = 0;
		int numOfTerms = 100000;
		double seriesExpansion = 0;
		
		//Calculation
		for (int i = 1; i <= numOfTerms; i++) {
			if (i % 2 == 1)
				seriesExpansion += 1.0/(2*i-1);
			else
				seriesExpansion -= 1.0/(2*i-1);
		}
		pi = 4 * seriesExpansion;
		
		//Rounded Output
		System.out.format("%.3f", pi);
		
		input.close();
	}
}
