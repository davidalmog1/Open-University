package OpenUTesting;
import java.util.*;
public class Main {

    //Binary Search
    public int recursiveBinarySearch(int []arr,int value){
        return recursiveBinarySearch(arr,0,arr.length,value);
    }
    private int recursiveBinarySearch(int []arr,int start,int end,int value){
        if(start >= end){
            System.out.println("\nDid not found element\n");
            return -1;
        }
        int mid = (start+end)/2;
        System.out.println("Mid = "+mid);
        if(arr[mid] == value){
            return mid;
        }else{
            if(arr[mid] > value)
                return recursiveBinarySearch(arr,start,mid,value);
            else
                return recursiveBinarySearch(arr,mid+1,end,value);
        }
    }
    public static void main(String[] args) {
    int []arr = {-10, -5, 1, 7, 15, 20, 22,45};
    try {



    }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("\nFinish\n");
        }

    }//end main
}
