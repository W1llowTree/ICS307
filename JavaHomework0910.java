/*
Frank Huang
09/10/2022
This program is for #4.
For ICS3U7-1 class Ms.Strelkovska
*/

class Main {
	public static void main(String[] args) {
		int money = 2040;
		int numOfTickets = (int)(money / 113.15f);
		float changeTotal = (float)(money - numOfTickets * 113.15f);
		int changeDollars = (int)(changeTotal);
		float changeCents = (changeTotal - changeDollars) * 100;
		System.out.format("With %d dollars you can buy %d tickets.\n", money, numOfTickets);
		System.out.format("The change is %d dollars and %.0f cents", changeDollars, changeCents);
	}
}	