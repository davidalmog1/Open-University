package OpenUTesting;

public class Recursion {

    /**
     * Write a matching boolean recursive method that accepts two arrays. One array (a) contains
     * integers, and a second array (pattern) and check if the array contains the pattern.
     */
    public static boolean match (int [] a, int [] pattern){
        return match(a,pattern,0,0);
    }
    private static boolean match(int[] a,int[] p, int ia, int jp){
        if((ia >= a.length-1) ||( ia >= a.length-1 && jp >= p.length-1))
            return false;
        if(bool(a,p,ia,jp) == true)
            return true;
        else {
            ia = ia+1;
            jp = 0;
            return match(a, p, ia, jp);
        }
    }
    private static boolean bool(int[] a,int[] p,int ia, int jp){
        if(p.length == jp) {
            return true;
        }
        if(a[ia] == p[jp] && (a.length -ia >= p.length-jp-1) ){
            ia = ia+1;
            jp = jp+1;
            return bool(a, p, ia,jp);
        }
        return false;
    }

    /**
     * print |_
     *         |_
     *           |
     *   [] [] [] []
     *   [] [] [] []
     *   [] [] [] []
     *   [] [] [] []
     *
     *   [] [] []
     *   [] [] []
     *   [] [] []
     *
     *   [] []
     *   [] []
     *
     *   []
     */
    public void printTest(int mat[][]){
        printTest(mat,0,0);
    } // R = Right | D = down
    private void printTest(int mat[][],int r, int d){
        if(r >= (mat.length) || d >= (mat.length)){
            return;
        }
        int temp = r;
        while(temp != 0) {
            System.out.print(" ");
            temp--;
        }
        System.out.print("["+mat[r][d]+"]");
        printTest(mat,r+1,d+1);
    }


    public static void main(String[] args) {
    try {
//        int[] a= {2,3,6,23,57,2,3,7,2,5,2,3,57};
//        int[] p= {2,3,57};
        int [][] mat = {{1,2,3,4},
                        {4,3,2,1},
                        {1,2,3,4},
                        {4,3,2,1}};
        int [][] matOther = {{1,2,3},
                            {3,2,1},
                            {1,2,3}};
        Recursion r = new Recursion();
        r.printTest(matOther);

    }catch (Exception e){
        e.printStackTrace();
    }finally {
        System.out.println("\nFinish");
    }

    }//end main
}//end class
