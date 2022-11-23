/*
Frank Huang
9/13/2022

For ICS3U7-3 class Ms.Strelkovska
*/

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//TimeConversion (Exercise #9 page 45)
		int timeMinutes = 0;
		int finalHours = 0;
		int finalMinutes = 0;
		
		System.out.print("Enter the time in minutes: ");
		timeMinutes = input.nextInt();
		
		finalHours = timeMinutes / 60;
		finalMinutes = timeMinutes - finalHours * 60;
		
		System.out.format("\nThe time is: %d:%02d\n\n", finalHours, finalMinutes);
		
		//Project (#12 page 46)
		double designTime = 0;
		double codeTime = 0;
		double debugTime = 0;
		double testTime = 0;
		double totalTime = 0;
		double designPercent = 0.0;
		double codePercent = 0.0;
		double debugPercent = 0.0;
		double testPercent = 0.0;
		
		//Obtaining input values
		System.out.println("Enter the number of minutes spent on each of the following project tasks:\n");
		System.out.print("Designing: ");
		designTime = input.nextInt();
		System.out.print("Coding: ");
		codeTime = input.nextInt();
		System.out.print("Debugging: ");
		debugTime = input.nextInt();
		System.out.print("Testing: ");
		testTime = input.nextInt();
		
		//Computation
		totalTime = designTime + codeTime + debugTime + testTime;
		
		designPercent = designTime / totalTime * 100;
		codePercent = codeTime / totalTime * 100;
		debugPercent = debugTime / totalTime * 100;
		testPercent = testTime / totalTime * 100;
		
		//Output
		System.out.format("\n%-15s %-10s %%\n", "Task", "% Time");
		System.out.format("%-15s %.2f %%\n", "Designing", designPercent);
		System.out.format("%-15s %.2f %%\n", "Coding", codePercent);
		System.out.format("%-15s %.2f %%\n", "Debugging", debugPercent);
		System.out.format("%-15s %.2f %%\n", "Testing", testPercent);
		
		//Printing (#1 page 64)
		int numberOfCopies = 0;
		double pricePerCopy = 0;
		double totalCost = 0;
		
		System.out.print("\nEnter the number of copies to be printed: ");
		numberOfCopies = input.nextInt();
		
		if (numberOfCopies >= 0) {
			if (numberOfCopies <= 99)
				pricePerCopy = 0.30;
			else if (numberOfCopies <= 499)
				pricePerCopy = 0.28;
			else if (numberOfCopies <= 749)
				pricePerCopy = 0.27;
			else if (numberOfCopies <= 1000)
				pricePerCopy = 0.26;
			else
				pricePerCopy = 0.25;
			
			System.out.println("Price per copy is: $" + pricePerCopy);
			totalCost = numberOfCopies * pricePerCopy;
			System.out.format("Total cost is: $%.2f", totalCost);
		}
		else { // Invalid number of copies entered
			System.out.println("Please enter a non-negative integer");
		}
		
		//MathTutor (#6 page 65)
		int num1 = (int)Math.round(Math.random() * 10 + 1);
		int num2 = (int)Math.round(Math.random() * 10 + 1);
		char operator = 'n';
		int operatorNum = (int)Math.round(Math.random() * 4);
		double userAnswer = 0;
		double correctAnswer = 0;
		
		//Randomize operator and calculate
		if (operatorNum == 0) {
			operator = '+';
			correctAnswer = num1 + num2;
		}
		else if (operatorNum == 1) {
			operator = '-';
			correctAnswer = num1 - num2;
		}
		else if (operatorNum == 2) {
			operator = 'x';
			correctAnswer = num1 * num2;
		}
		else { 
			operator = '/';
			correctAnswer = Math.round(num1 * 100.0 / num2) / 100.0;
		}
		
		//Output
		System.out.format("\n\nWhat is %d %s %d? Round to 2 decimals if necessary. Otherwise, answer in whole numbers. ", num1, operator, num2);
		userAnswer = input.nextDouble();
		
		if (userAnswer == correctAnswer)
			System.out.println("Correct!");
		else
			System.out.println("The correct answer is " + correctAnswer);
	}
}