/* ************************* START MAMAN 13 TESTER *********************

/* ************************* START Q1  *********************

/* ************************* Finish Q1 *********************

/* ************************* START Q2  *********************

/* ************************* Finish Q2 *********************

/* ************************* START Q3  *********************

f(abaa) = 
abaa
aa

f(plka) = 

f(plk) = 
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: begin 3, end 4, length 3
	at java.base/java.lang.String.checkBoundsBeginEnd(String.java:3410)
	at java.base/java.lang.String.substring(String.java:1883)
	at Ex13.f(Ex13.java:61)
	at Mmn13Tester_454.testF_Q3(Mmn13Tester_454.java:25)
	at Mmn13Tester_454.main(Mmn13Tester_454.java:12)
//package mm12;
*/ //  ========================== -10
public class Ex13 {

	/*
	 * this method Gets an number and returns true if the number digits Arranged
	 * in ascending else returns false
	 * 
	 * @param n - the number 
	 * 
	 * @return boolean return true if digits Arranged in ascending else return false
	 */
	public static boolean ascendingNum(int a) {
		if(a % 10 ==0) {
			return true;
		}
		int temp = a%10;
		if(temp > ((a/10)%10)) {
			return ascendingNum(a/10);
		}
		else {
			return false;
			}
		}
	
	/*
	 * this method Calculating the The greatest common divisor of two integers m and n
	 * 
	 * @param m 
	 * 
	 * @param n
	 * 
	 * @return int - return the maximum greatest common divisor
	 */
	private static int oddGCD(int m, int n) {
		if (n == m)
			return n;
		if (m > n)
			return oddGCD(n, m - n);
		return oddGCD(m, n - m);
	}

	public static int generalGCD(int m, int n) {
		if (m != 0 || n != 0)
			return oddGCD(m, n);
		else
			return 2 * generalGCD(m / 2, n / 2);
	}

	/*
	 * this method Prints all the different sub-strings of s, beginning with a 'a'
	 * and ending with s.
	 * 
	 * @param s
	 */
	private static int point = 0;

	public static void f(String s) {
		if (point == s.length() - 1)
			return;
		if (s.substring(point, point + 1).equals("a")) {
			System.out.println(s.substring(point));
			point++;
		} else
			point++;
		f(s);
	}

}// end class
