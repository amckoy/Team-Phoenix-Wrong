
      /*
Team Phoenix Wrong: Emma, Adam, Owen
APCS2 pd5
HW11
2016-03-09
 */
 import java.util.Random;
/*======================================
  class MergeSortTester
  ALGORITHM:
  1. If input length==1, return because its sorted.
  2. Make two new arrays, each taking half of the values from the original.
  3. Sort these two arrays with recursive calls, and merge them.

  BIG-OH CLASSIFICATION OF ALGORITHM: O(nlogn)
  Mean execution times for dataset of size n:
  Batch size: 10
  
  n=10^0  time: ~0.0 ms 
  n=10^1  time: ~0.0 ms 
  n=10^2  time: ~0.0 ms
  n=10^3  time: ~0.0 ms
  n=10^4  time: ~0.0 ms
  n=10^5  time: ~16.0 ms
  n=10^6  time: ~215.0 ms
  n=10^7  time: ~2721 ms
  n=10^8  time: <Java heap space error>
  
  ANALYSIS: The results from our testing apparatus show that as the dataset gest much bigger, so does the runtime,
  ======================================*/

public class MergeSortTester {

    /******************************
     * execution time analysis 
     * For 10^0 to 10^10:
     * Run MergeSort 10 times, and average the times it takes for each one
     * Print results.
     ******************************/
     public static int[] genArray(int size) {
       int[] retArr = new int[size];
       Random rand = new Random();
       for (; size>0; size--) { retArr[size-1] = rand.nextInt(); }
       return retArr;
     }
    
    public static void main( String[] args ) 
    {
      double average = 0;
      for (int exponent = 0; exponent < 8; exponent++){
        for (int repeat = 0; repeat < 10; repeat++){
        
            int[] arr = genArray((int)(Math.pow(10,exponent)));
            double begin = System.currentTimeMillis();
            MergeSort.sort(arr);
            double end = System.currentTimeMillis();
          average = end - begin;
        }
        System.out.println("Average time for n=10^" + exponent + ": " + average);
        average = 0;// we good?
      }
    }//end main
}//end class
