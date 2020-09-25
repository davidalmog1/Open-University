package sorting;

import static sorting.BubbleSort.printArray;
import static sorting.BubbleSort.swap;

/**
 *  name: david
 *  data: 2020
 *  in-place algorithm
 *  time complexity = O(n*n)
 *  Stable algorithm
 *
 */

public class InsertionSort {
    public static void main(String[] args) {
        int [] arr = {20,35,-15,7,55,1,-22};
        try{

            System.out.println("\nBefore \n");
            printArray(arr);
            System.out.println("\nAfter \n");
            myInsertionUsingRecursion(arr);
            printArray(arr);

        }catch(Exception e){
            System.out.println("\nError \n");
            e.printStackTrace();
        }finally {
            System.out.println("\nFinish \n");
        }
    }//end main

    public static void academyInsertionSort(int[] intArray){
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length;
             firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }
    }

    public static void myInsertionImplementation(int[] arr){
        for(int x =1; x<arr.length; x++){
            for(int i=0; i <=x ;i++){
                if(arr[i] >arr[x])
                    swap(arr,i,x);
            }
        }
    }

    public static void myInsertionUsingRecursion(int[] arr){
        myInsertionUsingRecursion(arr,0,0);
    }
    private static void myInsertionUsingRecursion(int[] arr, int i, int j){
        if( i >= arr.length-1 && j >= arr.length-1 ){
            System.out.println("_ finish_");
            return;
        }
        if(j >= arr.length-1){
            if(arr[j] > arr[i]) {
                swap(arr, j, i);
            }
            i = i+1;
            j = 0;
            System.out.println("I++\t i="+i+" j="+j);
            myInsertionUsingRecursion(arr,i,j);
        }else{
            if(arr[j] > arr[i]) {
                swap(arr, j, i);

            }
            j = j+1;
            System.out.println("j++\t i="+i+" j="+j);
            myInsertionUsingRecursion(arr,i,j);
        }
    }


}//end class
