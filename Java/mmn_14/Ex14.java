/* ******************** Test Question #1  - isTrance - Strart ********************

 if 
 if 
 if 
 if 
-- out --
else
ERROR - isTrance(abbcd, aaabbbccdd) = false expect = true
ERROR - Exception isTrance(abc, aaabbcbc) 
java.lang.StringIndexOutOfBoundsException: String index out of range: 4
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:47)
	at java.base/java.lang.String.charAt(String.java:702)
	at Ex14.isTrans(Ex14.java:22)
	at Mmn14Tester_454.main(Mmn14Tester_454.java:15)
ERROR - Exception isTrance(cab, ccccaaabb) 
java.lang.StringIndexOutOfBoundsException: String index out of range: 4
	at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:47)
	at java.base/java.lang.String.charAt(String.java:702)
	at Ex14.isTrans(Ex14.java:22)
	at Mmn14Tester_454.main(Mmn14Tester_454.java:15)

******************** Test Question #1  - isTrance - Finished ******************** 
*/


/* ******************* Test Question #2  - countPaths - Start ******************** 


******************* ERROR - Stack over flow for:
1	0	
22	22	


******************* ERROR - result=4 : expected=3 for:
1	2	3	
1	11	4	
2	1	5	


******************* ERROR - Stack over flow for:
1	10	
0	22	


******************** Test Question #2  - countPaths - Finished ******************* -25
*/

public class Ex14 {

	/*
	 * This method return true if string t 
	 * is transformation of string s.
	 * @param String s the origin 
	 * @param String t the transformation
	 * @return boolean 
	 */
	static int T = 0, S = 0;

	public static boolean isTrans(String s, String t) {
		if (s.charAt(0) != t.charAt(0) || s.length() > t.length()
				|| s.charAt(s.length() - 1) != t.charAt(t.length() - 1))
			return false;
		if ((t.length() - 1) >= (s.length() - 1) && (t.length() - 1) == T
				&& t.charAt(t.length() - 1) == s.charAt(s.length() - 1)) {
			System.out.println("-- out --");
			return true;
		}
		if (s.charAt(S) == t.charAt(T) & S < (s.length() - 1)) {
			S++;
			T++;
			System.out.println(" if ");
			return isTrans(s, t);
		} else if (S != 0 && (s.charAt(S - 1) == t.charAt(T) || s.charAt(S) == t.charAt(T))) {
			System.out.println("else if ");
			T++;
			return isTrans(s, t);
		} else {
			System.out.println("else");
			return false;
		}
	}

	/*
	 * this method return the number of possible paths in 2D array
     * @param mat the 2D array
     * @return int = the number of possible paths in 2D array.
	 */
	public static int countPaths(int[][] mat) {
		int result = cp(mat, 0, 0);
		return result;
	}

	private static int cp(int[][] mat, int row, int col) {
		if (row == mat.length - 1 && col == mat[0].length - 1) {
			return 1;
		}
		if (row < mat.length && col < mat[0].length)
			return cp(mat, row + mat[row][col] / 10, col + mat[row][col] % 10)
					+ cp(mat, mat[row][col] % 10 + row, mat[row][col] / 10 + col);
		return 0;
	}

}// end class
