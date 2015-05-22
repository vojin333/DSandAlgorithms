package recursion;

public class MergeSort {

	public static void main(String[] args) {
		int[] arrayA = {23, 47, 81, 95};
		int[] arrayB = {7, 14, 39, 55, 62, 74};
		int[] arrayC = new int[10];
		
		mergeSort(arrayA, arrayA.length, arrayB, arrayB.length, arrayC);
		display(arrayC);
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
