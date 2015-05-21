package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleApp {

	public static int theNumber;
	/**
	 * @param args
	 * @see 
	 */
	public static void main(String[] args) throws IOException {
		//triangle recursion
//		System.out.print("Enter a number: ");
//		theNumber = getInt();
//		int theAnswer = triangleExplained(theNumber);
//		System.out.println("Triangle=" + theAnswer);
		
		//factorial recursion
		System.out.print("Enter a number: ");
		theNumber = getInt();
		int theAnswer = factorial(theNumber);
		System.out.println("Factorial = " + theAnswer);

	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
	
	public static int triangle(int n) {
		if (n==1) {
			return 1;
		} else {
			return (n + triangle(n - 1));
		}
	}
	
	public static int factorial(int n) {
		if (n==0) {
			return 1;
		} else {
			return (n * factorial(n - 1));
		}
	}
	
	public static int triangleExplained(int n) {
		System.out.println("Entering: n= " + n);
		if (n==1) {
			System.out.println("Returning 1");
			return 1;
		} else {
			int temp =  n + triangleExplained(n - 1);
			System.out.println("Returning " + temp);
			return temp;
		}
	}
}
