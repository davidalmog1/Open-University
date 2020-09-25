package sorting;

/**
 *  name: david
 *  data: 2020
 *  in-place algoritem
 *  time complexity = O(n*n)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {20,35,-15,7,55,1,-22};
        try{

            System.out.println("\nBefore \n");
            printArray(arr);
            System.out.println("\nAfter \n");
            academyBubbleSort(arr);
            printArray(arr);

        }catch(Exception e){
            System.out.println("\nError \n");
            e.printStackTrace();
        }finally {
            System.out.println("\nFinish \n");
        }
    }//end main

    public static void academyBubbleSort(int[] intArray){
        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
             lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }
    }

    public static void myBubbleImplementation(int[] arr) {
      for(int x = arr.length; x > 0; x--){
          for(int i=0,j=1; j < x; i++,j++){
                if(arr[i] > arr[j])
                    swap(arr,i,j);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void printArray(int []arr){
        for(int i=0; i <arr.length; i++){
            System.out.print(arr[i] +" ");
        }
   }

}//end class
