package sorting;

import static sorting.BubbleSort.printArray;

/**
 *  name: david
 *  data: 2020
 *  not-place algorithm
 *  time complexity = O(n log n)
 *  Stable algorithm
 */
public class MargeSort {
    public static void main(String[] args) {
        int [] arr = {20,35,-15,7,55,1,-22};
        try{

            System.out.println("\nBefore \n");
            printArray(arr);
            System.out.println("\nAfter \n");
            mergeSort(arr);
            printArray(arr);

        }catch(Exception e){
            System.out.println("\nError \n");
            e.printStackTrace();
        }finally {
            System.out.println("\nFinish \n");
        }
    }//end main

    /**
     * @param arr
     * Merge Sort:
     * Divide and conquer algorithm
     * Recursive algorithm
     * Two phases: Splitting and Merging
     * Splitting phase leads to faster sorting during the Merging phase
     * Splitting is logical. we don't create new arrays
     */
    public static void myMergeSortImplementation(int[] arr){
        myMergeSortImplementation(arr,0,arr.length-1);
    }
    private static void myMergeSortImplementation(int[] arr,int start,int end){
        int midpoint = (start+end)/2;
        if(end - start < 2){
            System.out.println("Done Here");
            return ;
        }
        myMergeSortImplementation(arr,start,midpoint);
        myMergeSortImplementation(arr,midpoint,end);
    }

    /** ========================= Academy Implementation =============================== */
    public static void mergeSort(int[] input) {
        mergeSort(input,0, input.length);
    }

    private static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);


    }
}//end class
