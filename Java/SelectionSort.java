package sorting;

import static sorting.BubbleSort.printArray;
import static sorting.BubbleSort.swap;

/**
 *  name: david
 *  data: 2020
 *  in-place algorithm
 *  time complexity = O(n*n)
 *  Don't require as much Swapping as Bubble sort
 *  Unstable algorithm
 */

public class SelectionSort {
    public static void main(String[] args) {
        int [] arr = {20,35,-15,7,55,1,-22};
        try{

            System.out.println("\nBefore \n");
            printArray(arr);
            System.out.println("\nAfter \n");
            academySelectionSort(arr);
            printArray(arr);

        }catch(Exception e){
            System.out.println("\nError \n");
            e.printStackTrace();
        }finally {
            System.out.println("\nFinish \n");
        }
    }//end main

    public static void academySelectionSort(int[] intArray){
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
        }
    }


}//end class
