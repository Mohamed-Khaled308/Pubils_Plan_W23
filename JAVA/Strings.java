import java.util.*;
import java.io.*;

public class Strings {
	public static void main(String[] args) {

		String s = "aBcDe";

		// these are some predefined methods in String class that you would use;

		int length = s.length(); // the length of the String (the number of characters) length = 5
		String uppercase = s.toUpperCase(); // it returns a new String with all characters in uppercase : "ABCDE"
		String lowercase = s.toLowerCase(); // it returns a new String with all characters in lowercase : "abcde"

		// you can create an array of characters from Strings
		char[] charArr = s.toCharArray(); // charArr = ['a', 'B', 'c', 'D', 'e' ]

		// you can also access any character by its index (0 indexed)
		char firstCharacter = s.charAt(0); // first character 'a'
		char lastCharacter = s.charAt(s.length() - 1); // last character 'e'

		// you can loop over the string and do whatever you want
		for (int i = 0; i < s.length(); i++) {
			System.out.println("Character at index " + i + " = " + s.charAt(i));
		}
		System.out.println();

		// to check whether 2 strings are equal or not we cann't use == .
		// we should use equals method
		String s2 = "abc";
		System.out.println("Does s equal s2 ? " + s.equals(s2));
		System.out.println();
		
		// to read string from user we need a scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("please enter a String : ");
		String myString = sc.next();

		// to print the string you can just print it
		System.out.println("myString is : " + myString);
		System.out.println();

		
		
		
		
		// String is not static so we can append more characters to it but the
		// complexity is O(n) per character
		// so if we want to append m characters the total complexity will be O(n * m)
		// which is very bad

		// there is another datatype that we can append to it in O(1) complexity per
		// Character. it's StringBuilder

		StringBuilder sb = new StringBuilder(); // initially this is empty
		StringBuilder sb2 = new StringBuilder("abc"); // initially this has 3 character "abc"

		sb.append('M'); // O(1)
		sb.append('o');
		System.out.println("sb = " + sb);
		System.out.println();
		
		
		// to compare a StringBuilder with a String you need to change the StringBuilder
		// to String first using sb.toString()

		System.out.println("Does s equal sb ? " + sb.toString().equals(s));
	}
}
