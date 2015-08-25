package advancedSorting;

public class DArray {

	private long[] theArray;
	private int nElems;
	
	public DArray(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display() {
		System.out.println("theArray = ");
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
	
	public int size() {
		return nElems;
	}
	
//	public void shellSort() {
//		int inner, outer;
//		long temp;
//		
//		int h = 1;
//		while (h <= nElems/3) {
//			h  = h*3 + 1;
//		}
//		
//		while(h > 0) {
//			
//		}
//	}
	
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		
		while(true) {
			while (leftPtr < right && theArray[++leftPtr] < pivot) {
				//nop
			}
			
			while(rightPtr > left && theArray[--rightPtr] > pivot) {
				//nop
			}
			
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		return leftPtr;
	}
	
	private void swap(int left, int right) {
		long temp = theArray[left];
		theArray[left] = theArray[right];
		theArray[right] = temp;
	}
	
	public void quickSort() {
		recQuickSort(0, nElems - 1); 
	}
	
	private void recQuickSort(int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			long pivot = theArray[right];
			int partiotion = partitionItForQuickSort(left, right, pivot);
			recQuickSort(left, partiotion - 1);
			recQuickSort(partiotion + 1, right);
		}
	}
	
	public int partitionItForQuickSort(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		
		while(true) {
			while (theArray[++leftPtr] < pivot) {
				//nop
			}
			
			while(rightPtr > left && theArray[--rightPtr] > pivot) {
				//nop
			}
			
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap(leftPtr, rightPtr);
			}
		}
		swap(leftPtr, right);
		return leftPtr;
	}
}
