/* ******************* Question #1 - Started ********************


====================================

Testing Question 1.a
------------------------------------


Test 1.a.1:
Input s = "", c = 'c'
Expected result is: 0	Student result is: -2
FAILED!!!

Test 1.a.2:
Input s = "a", c = 'c'
Expected result is: 0	Student result is: -2
FAILED!!!

Test 1.a.3:
Input s = "c", c = 'c'
Expected result is: 0	Student result is: -1
FAILED!!!
Passed.
Passed.
Passed.

=======================================

Testing Question 1.b
---------------------------------------

Passed.
Passed.
Passed.
Passed.
Passed.

Test 2.b.complexity measure:
The result is: 49995000	Student result is: 49995000
Passed.
The expected time is : 1 The student run time is : 2

******************** Test Question #1  - Finished ******************** -7 */ 



/* ******************* Question #2 - Started ********************

should Be O(n)   -10
Testing zeroDistance Successfully passed.

******************** Test Question #2  - Finished ******************* */ 



public class Ex12 {

	/**
	 * this method gets String and character, and return how many sub-String 
	 * there is in String that starts and ends with the character parameter.
	 * @param s the String to check for the Sub-String within.
	 * @param c the character to check the Sub-String according to.
	 * @return the number of the valid Sub-String.
	 * @timeComplaxity O(n) n - String length.
	 * @SpaceComplaxity O(1)
	 */
	public static int subStrC(String s, char c) {
		int count_num_of_c = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count_num_of_c++;
			} else
				continue;
		}
		count_num_of_c = (count_num_of_c - 2);
		return count_num_of_c;
	}// end method

	
	
	/**
	 * this method check how many Sub-Strings are within a given String that starts
	 * and ends with a given character and also has that character inside the
	 * Sub-String maximum a given amount of times.
	 * @param s the String to check for the Sub-String within.
	 * @param c the character to check the Sub-String according to.
	 * @param k the amount of time that the given character 
	 * has to be within every Sub-String.
	 * @return the number of the valid Sub-Strings.
	 * @timeComplexity O(n) n - String length.
	 * @SpaceComplexity O(1)
	 */
	public static int subStrMaxC(String s, char c, int k) {
		int result = 0, count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				result += Math.min(k + 1, count);
				count++;
			}
		}

		return result;
	}

	
	
	/**
	 * this method gets an array of numbers (1 or 0) and replaces any value in
	 * an array that is zero in the distance From the nearest zero point (right or
	 * left).
	 * @param a array of numbers ( 1 or 0 )
	 * @timeComplexity O(n*n)
	 * @SpaceComplexity O(1)
	 */
	public static void zeroDistance(int[] a) {
		int N = -1;
		for (int i = 0; i < a.length; i++)
			if (a[i] == 0)
				N = 0;
			else {
				if (N == -1)
					a[i] = Integer.MAX_VALUE;
				else {
					N++;
					a[i] = N;
				}
			}
		N = -1;
		for (int i = a.length - 1; i >= 0; i--)
			if (a[i] == 0)
				N = 0;
			else if (N != -1 && a[i] > ++N)
				a[i] = N;
	}

}// end class
