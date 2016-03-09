/*======================================
Emma Vukelj
APCS2 pd5
HW09: Merge Sort
2016-03-04
======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) {
	int[] retAr = new int[a.length + b.length];
	int aStart = 0;
	int bStart = 0;
	while (aStart<a.length && bStart<b.length) {
	    if (a[aStart] < b[bStart]) {
		retAr[aStart+bStart] = a[aStart];
		aStart++;
	    } else {
		retAr[aStart+bStart] = b[bStart];
		bStart++;
	    }
	}
	for (; b.length+aStart<retAr.length; aStart++) {
	    retAr[b.length+aStart] = a[aStart];
	}
	for (; a.length+bStart<retAr.length; bStart++) {
	    retAr[a.length+bStart] = b[bStart];
	}
	return retAr;
    }//end merge()

    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) {
	if (arr.length==1) { return arr; } //base case
	//else
	int split = (arr.length)/2; //where to split
	int[] firstChild = new int[split]; //make to pass down these to kids
	int[] secondChild = new int[arr.length-split];
	//actually pass to kids
	for (int i=0; i<split; i++) { firstChild[i] = arr[i]; }
	for (int i=0; i<arr.length-split; i++) { secondChild[i] = arr[split+i]; }
	//merge what ur kids sort
	return merge( sort(firstChild), sort(secondChild));
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};
	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );
	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );
	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
		/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
