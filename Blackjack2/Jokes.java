/*
 * Name: Frank Huang
 * Date: 11/26/2022
 * For ICS3U7-01 Ms.Strelkovska
 * Class inputting jokes and returning them.
 */

import java.util.*;
import java.io.*;

public class Jokes {
	private static ArrayList<String> jokesList = new ArrayList<String>();
	
	//Adds jokes from file into the ArrayList
	public static void loadJokes() throws Exception {
		Scanner sc = new Scanner(new File("Jokes.txt"));
		while (sc.hasNextLine())
				jokesList.add(sc.nextLine());
		Collections.shuffle(jokesList);
    sc.close();
	}
	
	public static String nextJoke() throws Exception {
		if (jokesList.isEmpty())
			loadJokes();
		return jokesList.remove(0);
	}
}
