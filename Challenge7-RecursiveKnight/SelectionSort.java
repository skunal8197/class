//UIUC CS125 FALL 2012 MP. File: SelectionSort.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2012-11-09T13:47:46-0600.831004000
/**
 * 
 * @author lzhou8
 */
public class SelectionSort {
	/**
	 * Sorts the entire array using selection sort
	 * This is just a wrapper method that calls the 
	 * recursive method with the correct parameter lo,hi values.
	 * @param data
	 */
	public static void sort(double[] data) {
		 sort(data,0,data.length - 1);
	}

	/** Recursively sorts the sub array lo...hi using selection sort algorithm.*/
	public static void sort(double[] data, int lo, int hi) {
        if (lo < hi) {
            swap(data, lo, findMin(data, lo, hi));
            sort(data, lo + 1, hi);
    }
	}

	/** Helper method for selection sort: Swaps values at indices i and j*/
	public static void swap(double[] data, int i, int j) {
		double tmp=data[i];
		data[i]=data[j];
		data[j]=tmp;
	}

	/**
	 * Recursively finds the position of the smallest value of the values lo...hi (inclusive). 
	 * @param data
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int findMin(double[] data, int lo, int hi) {
        if (lo > hi) return -1;
        if (lo == hi) return lo;
        if (data[lo] > data[hi]) return findMin(data, lo + 1, hi);
        else return findMin(data, lo, hi - 1);
	}

}
