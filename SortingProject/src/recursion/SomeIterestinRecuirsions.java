package recursion;

public class SomeIterestinRecuirsions {

	/**
	 * @param args
	 * @see 
	 */
	public static void main(String[] args) {
		int x = 2;
		int y = 8;
		System.out.println("Multiplication of " + x + " and " + y + " = " + multiplicationWithAdd(x, y));
		System.out.println("Power of base " + x + " on exponent " + y + " = " + power(x, y));
	}
	
	public static int power(int x, int y) {
		if(y == 0) {
			return 1;
		} else  {
			return x * power(x, y - 1);
		}
	}
	
	public static int multiplicationWithAdd(int x, int y) {
		if (y == 1) {
			return x;
		} else {
			return x + multiplicationWithAdd(x, y-1);
		}
	}
	
	public static int squareRoot(int x) {
		if (x == 0 || x == 1) {
			return x;
		} else {
			return squareRoot(x - 1) ;
		}
	}

}
