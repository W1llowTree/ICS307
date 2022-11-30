import java.util.*;
import java.io.*;

public class SortingPractice {
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			
			int val = array[i];
			int j = i - 1;
			
			while (j >= 0 && val < array[j]) {
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = val;
		}
		for (int i: array) 
			System.out.print(i + " ");
	}
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("/D:/ICS3U7/20221018/SortingPractice/bin/Numbers.txt"));
		int[] array = new int[100];
		for (int i = 0; i < 100; i++) {
			array[i] = input.nextInt();
		}
		insertionSort(array);
		input.close();
	}
}
