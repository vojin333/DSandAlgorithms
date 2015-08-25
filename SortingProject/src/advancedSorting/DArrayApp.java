package advancedSorting;

public class DArrayApp {

	/**
	 * @param args
	 * @see 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int max = 16;
		DArray array = new DArray(max);
		
		for (int i = 0; i < max; i++) {
			long n = (int)(java.lang.Math.random()*199);
			array.insert(n);
		}
		
		array.display();
		
		long pivot = 99;
		System.out.println("Pivot is "+ pivot);
		
//		array.partitionIt(0, array.size() - 1, pivot);
		
		array.quickSort();
		
		array.display();
		
		
	}

}
