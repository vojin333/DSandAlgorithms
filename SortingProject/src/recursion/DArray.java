package recursion;

public class DArray {

	private long[] theArray;
	private int nElems;
	
	public DArray(int sizeMax) {
		theArray = new long[sizeMax];
		nElems = 0;
	}
	
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
	
	public void mergeSort() {
		long[] workspace = new long[nElems];
		recMergeSort(workspace, 0, nElems - 1);
	}
	
	private void recMergeSort(long[] workspace, int lowwerBound, int upperBound) {
		if (lowwerBound == upperBound) {
			return;
		} else {
			int mid  = (upperBound + lowwerBound) / 2;
			
			recMergeSort(workspace, lowwerBound, mid);
			recMergeSort(workspace, mid + 1, upperBound);
			
			merge(workspace, lowwerBound, mid + 1, upperBound);
		}
	}
	
	private void merge(long[] workspace, int lowPart, int highPart, int upperBound) {
		int j = 0;
		int lowerBound = lowPart;
		int mid = highPart - 1;
		int n = upperBound - lowerBound + 1;
		
		while (lowPart <= mid && highPart <= upperBound) {
			if (theArray[lowPart] < theArray[highPart]) {
				workspace[j++] = theArray[lowPart++];
			} else {
				workspace[j++] = theArray[highPart++];
			}
		}
		
		while (lowPart <= mid) {
			workspace[j++] = theArray[lowPart++];
		}
		
		while (highPart <= upperBound) {
			workspace[j++] = theArray[highPart++];
		}
		
		for (int i = 0; i < n; i++) {
			theArray[lowerBound + i] = workspace[i];
		}
	}
}
