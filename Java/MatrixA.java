package Challenge;

/**
 * Name: David
 * Data: 2020
 *
 * in this class i will answer questions
 * from Open University.
 * Matrix problems:
 */
public class MatrixA {

    /**
     * Data: 2020 B
     *
     * נתון מערך דו-ממדי mat, בגודל n×m (יש n שורות ו- m עמודות) שערכיו הם מספרים שלמים חיוביים ממש.
     * נגדיר מסלול-נחש (snake-path) במערך אם הוא מקיים את התנאים הבאים:
     * המסלול מתחיל בתא הראשון במערך – שורה ראשונה ועמודה ראשונה.
     * אפשר לעבור מתא אחד לשני רק אם הוא שכן שלו באלכסון. לא בשום תא אחר.
     * אפשר ללכת מתא לתא רק אם ההפרש בין הערכים שנמצאים בשני התאים הוא לכל היותר 1.  למשל, מתא שערכו הוא 4 אפשר ללכת לתא שערכו הוא 3 או 4 או 5.
     * המסלול לא יכול לחזור לתא בו הוא היה כבר!
     * המסלול מסתיים רק כשמגיעים למבוי סתום (dead end), כלומר כשנתקעים ואין לאן להמשיך לפי התנאים של מסלול-נחש.
     * מסלול שהוא חלק ממסלול נחש ארוך יותר לא נחשב למסלול נחש.
     * עליכם לכתוב שיטה סטטית רקורסיבית המקבלת מערך דו-ממדי, מלא במספרים שלמים חיוביים ממש. השיטה צריכה להחזיר את אורכו של מסלול הנחש הקצר ביותר שיש במערך (מבחינת מספר התאים בהם הוא עובר).
     * אם אי אפשר להתקדם מהתא הראשון לאף אחד משכניו, השיטה תחזיר 1.
     */
    public static int minDiagDeadEndSnake(int[][] mat){
        if( mat[0][0] != mat[1][1] && mat[0][0] != (mat[1][1]-1) && mat[0][0] != (mat[1][1]+1) ){
            return 1;
        }
        return minDiagDeadEndSnake(mat,0,0);
    }
    private static int minDiagDeadEndSnake(int[][] mat,int l,int c){
        System.out.println("l = "+l+"\tc = "+c+"\tval = "+mat[l][c]);
        if(l >= (mat.length-1) || c >= (mat.length-1) ){
            System.out.println("in");
            return 0;
        }// right down
        if(mat[l][c] == mat[l+1][c+1] || mat[l][c] == (mat[l+1][c+1]+1) || mat[l][c] ==(mat[l+1][c+1])-1){
            return 1+ minDiagDeadEndSnake(mat,l+1,c+1);
        } //left down
         if((c > 0) && mat[l][c] == mat[l+1][c-1] || mat[l][c] == (mat[l+1][c-1]+1) || mat[l][c] ==(mat[l+1][c-1])-1){
            return 1+ minDiagDeadEndSnake(mat,l+1,c-1);
        } //right up
         if((l > 0) && mat[l][c] == mat[l-1][c+1] || mat[l][c] == (mat[l-1][c+1]+1) || mat[l][c] ==(mat[l-1][c+1])-1){
        return 1+ minDiagDeadEndSnake(mat,l-1,c+1);
        }
        return 0;
    }

    /**
     *  data : 2017
     *  type : B
     *  Q: 1
     */
    public static int cntTrueReg (int [][]mat){
        return cntTrueReg(mat,0,0,0);
    }
    private static int cntTrueReg(int [][]mat,int r,int c,int counter){
        if(r == mat.length)
            return counter;
        if(c == mat.length){
            return cntTrueReg(mat,r+1,0,counter);
        }
        if(mat[r][c] == 1){
            counter++;
            disable(mat,r,c);
        }
        return cntTrueReg(mat,r,c+1,counter);

    }
    private static boolean isLegal(int [][]mat,int r,int c){
        return r >=0 && r<(mat.length) && c >=0 && c <(mat.length);
    }
    private static void disable(int [][]mat,int r,int c){
        if( !isLegal(mat,r,c) || mat[r][c] == 0) {
            return;
        }
        mat[r][c] =0;
        disable(mat,r+1,c); //down
        disable(mat,r-1,c); //up
        disable(mat,r,c+1);//right
        disable(mat,r,c-1);//left
    }

    /**
     * data : 2012
     * type : A
     * Q: 2
     */
    public static void fillHadamard (int mat[][])
    {
        fillHadamard(mat, 0,0,mat.length, 1);
    }
    private static void fillHadamard (int [][] mat, int top, int left, int size, int sign) {
        if (size == 1)
            mat[top][left] = sign;
        else {
            fillHadamard(mat, top, left, size / 2, sign);
            fillHadamard(mat, top + size / 2, left, size / 2, sign);
            fillHadamard(mat, top, left + size / 2, size / 2, sign);
            fillHadamard(mat, top + size / 2, left + size / 2, size / 2, (-1) * sign);
        }
    }

    /**
     * data : 2018
     * type : A
     * Q: 2
     */
//    public static int howManySorted(int n, int max){
//        return howManySorted(n,max,0,1);
//    }
//    private static int howManySorted(int n,int max,int i,int x){
//       if(i >= n && max >= x ){
//           return 0;
//       }
//        System.out.println(" "+i+" "+x+" ");
//       if()
//    }


    /**====================== MAIN ==========================*/

    public static void main(String[] args) {
        int [][]mat = { {4,7,6,3,1},
                        {3,4,1,4,4},
                        {1,5,5,6,8},
                        {3,4,5,6,9},
                        {5,2,5,7,8} };

        int [][]matOne = { {0,0,0,0,1},
                            {0,1,1,1,0},
                            {0,0,1,1,0},
                            {1,0,0,0,0},
                            {1,1,0,0,0} };

        try {

        }catch(Exception e){
            System.out.println("\n\nError");
            e.printStackTrace();
        }finally {
            System.out.println("\n\nFinish");
        }
    }
}
