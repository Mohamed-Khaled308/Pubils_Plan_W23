import java.util.*;
import java.io.*;

public class Array {
	public static void main(String[] args) {

		// to create an array of any size you need to specify its size since it's
		// static (its size doesn't change once you create it)

		// these are the different types of arrays that you would use;

		int size = 3; // you can read it from user using scanner but it's 3 here for simplicity

		int[] arr_of_ints = new int[size]; // by default it will be filled by 0 [0, 0, 0,]

		double[] arr_of_doubles = new double[size]; // by default it will be filled by 0.0 [0.0, 0.0, 0.0]

		char[] arr_of_characters = new char[size]; // by default it will be filled by ' ' empty character [ , , ]

		// how to read an array from user
		// first of all you need a scanner

		Scanner sc = new Scanner(System.in);

		int sizeOfArray = sc.nextInt();

		int[] arr = new int[sizeOfArray];
		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = sc.nextInt();
		}

		// to print an array you should use Arrays.toString() method
		System.out.println(Arrays.toString(arr));

		//
		//
		// you can also create a 2d array
		int rows = 2, columns = 3;
		int[][] arr2d = new int[rows][columns];
		// it's an array of arrays. you can see it as a grid with 2 rows and 3 columns
		// [[0, 0, 0],
		// [0, 0, 0]]

		// to read 2d array from user we need nested loops
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				arr2d[i][j] = sc.nextInt();
			}
		}

	}
}
