package recursion;

public class MergeSort {

	public static void main(String[] args) {
		//merge sort
//		int[] arrayA = {23, 47, 81, 95};
//		int[] arrayB = {7, 14, 39, 55, 62, 74};
//		int[] arrayC = new int[10];
//		
//		mergeSort(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
//		display(arrayC);
		
		// Merge sort using recursion
		int maxSize = 100; // array size
		DArray arr; // reference to array
		arr = new DArray(maxSize); // create the array
		arr.insert(64); // insert items
		arr.insert(21);
		arr.insert(33);
		arr.insert(70);
		arr.insert(12);
		arr.insert(85);
		arr.insert(44);
		arr.insert(3);
		arr.insert(99);
		arr.insert(0);
		arr.insert(108);
		arr.insert(36);
		arr.display(); // display items
		arr.mergeSort(); // merge sort the array
		arr.display(); // display items again
	}
	
	public static void mergeSort(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
		int aDex = 0;
		int bDex = 0;
		int cDex = 0;
		
		while (aDex < sizeA && bDex < sizeB) {
			if (arrayA[aDex] < arrayB[bDex]) {
				arrayC[cDex++] = arrayA[aDex++];
			} else {
				arrayC[cDex++] = arrayB[bDex++];
			}
		}
		
		while (aDex < sizeA) {
			arrayC[cDex++] = arrayA[aDex++];
		}
		
		while (bDex < sizeB) {
			arrayC[cDex++] = arrayB[bDex++];
		}
	}
	
	public static void display(int[] arrayToDisplay) {
		for (int i = 0; i < arrayToDisplay.length; i++) {
			System.out.print(arrayToDisplay[i] + " ");
		}
	}
}
