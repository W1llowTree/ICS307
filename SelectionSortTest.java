import java.util.*;
import java.io.*;

public class SelectionSortTest {
	public static void selectionSort(String[] array) {
		String lowest = array[0];
		int index = 0;
		
		for (int i = 0; i < array.length; i++) {			
			lowest = array[i];
			index = i;
			
			for (int j = i; j < array.length; j++) {
				if (array[j].compareToIgnoreCase(lowest) < 0) {
					lowest = array[j];
					index = j;
				}
			}
			array[index] = array[i];
			array[i] = lowest;
		}
		for (String i: array)
			System.out.print(i + " ");
	}
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("/D:/ICS3U7/20221019/Sorting/src/Names.txt"));
		String[] array = input.nextLine().split(" ");
		selectionSort(array);
	}
}
