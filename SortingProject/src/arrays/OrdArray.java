package arrays;

/**
 * @author Vojin Nikolic
 *
 */
public class OrdArray {

	private long[] a; // ref to array a
	private int nElems; // number of data items
	
	public OrdArray(int max){
		a = new long[max]; //create array
		nElems = 0;
	}
	
	public int size() {
		return nElems;
	}
	//binary search
	public int find(long serachKey) {
		int lowerBound = 0;
		int upperBound = nElems-1;
		int curIn;
		
		while(true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == serachKey) {
				return curIn;
			}
			else if(lowerBound > upperBound) {
				return nElems;//cant find
			}
			if (a[curIn] < serachKey) {
				//it is in upper range
				lowerBound = curIn + 1;
			} else {
				//it is in lower  range
				upperBound = curIn - 1;
			}
		}
	}
	
	public void insert(long value) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (a[i] > value){
				break;
			}
		}
		//shift bigger up to make a room for insert
		for (int k = nElems; k>i; k--) {
			a[k] = a [k - 1];
		}
		a[i] = value;
		nElems++; // increment size
	}
	
	public void insertRegular(long value) {
		a[nElems] = value; // insert it
		nElems++; // increment size
	}
	
	public boolean delete(long value) {
		int i = find(value);
		if (i == nElems) {
			return false;//cant find it
		} else {
			// shift bigger down
			for (int k = i; k < nElems - 1; k++) {
				a[k] = a[k + 1];
			}
			nElems--;
			return true;
		} 
	}
	
	public void bubbleSort() {
		int out,in;
		//outter loop for backwards
		for (out = nElems-1; out > 1; out--) {
			//inner loop for forward
			for (in = 0; in < out; in++) {
				if(a[in] > a[in + 1]) {
					swap(in, in+1);
				}
			}
		}
	}
	
	public void selectionSort() {
		int out, in, min;
		//outter loop for backwards
		for (out = 0; out < nElems - 1; out++) {
			//inner loop for forward
			min = out;
			for (in = out + 1; in < nElems; in++) {
				if(a[in] < a[min]) {
					min = in;
				}
			}
			swap(out, min);
		}
	}
	
	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	
	public void  insertionSort() {
		int in, out;
		for (out = 1; out < nElems; out++) {
			long temp = a[out];
			in=out;
			while (in>0 && a[in - 1] >= temp) {
				//shift longer 
				a[in] = a[in - 1];
				--in;
			}
			//insert temp saved one into right place
			a[in] = temp;
		}
	}
	
	public void display() {
		for(int j=0; j < nElems; j++) {
			System.out.print(a[j] + " "); // display it
		}
		System.out.println("");
	}
	
	
//	public void  shellSort() {
//		int in, out;
//		long temp;
//		int h = 1;
//		while (h <= nElems/3) {
//			h = h*3 + 1;
//		} 
//		
//		while (h > 0) {
//			temp = a[out];
//			
//		}
//		for (out = 1; out < nElems; out++) {
//			temp = a[out];
//			in=out;
//			while (in>0 && a[in - 1] >= temp) {
//				//shift longer 
//				a[in] = a[in - 1];
//				--in;
//			}
//			//insert temp saved one into right place
//			a[in] = temp;
//		}
//	}
	
	public void shellSort() {
		int inner, outer;
		long temp;

		int h = 1; // find initial value of h
		while (h <= nElems / 3) {
			h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
		}

		// decreasing h, until h=1
		while (h > 0) {
			// h-sort the file
			System.out.println("H = " + h);
			for (outer = h; outer < nElems; outer++) {
				temp = a[outer];
				inner = outer;
				System.out.println("Temp = " + temp + " at position = " + outer);
				// one subpass (eg 0, 4, 8)
				while (inner > h - 1 && a[inner - h] >= temp) {
					System.out.println("Shifted Inner = " + inner + " with value  = " + a[inner - h]);
					a[inner] = a[inner - h];
					inner -= h;
					System.out.println("New Inner = " + inner);
				}
				a[inner] = temp;
			} // end for
			h = (h - 1) / 3; // decrease h
			display();
		} // end while(h>0)
	}  // end shellSort()
	
	
	public int partitioning(int left, int right, long pivot) {
		
		int leftPart = left - 1;
		int rightPart = right + 1;
		
		while (true) {
			while ( leftPart < right && a[++leftPart] < pivot) {
				System.out.println("LEft "  + leftPart);
			}
			
			while (rightPart > left && a[--rightPart] > pivot) {
				System.out.println("RIGHT "  + rightPart);
			}
			
			if (leftPart >= rightPart) {
				break;
			} else {
				swap(leftPart, rightPart);
			}
		}
		return leftPart;
	}
}
