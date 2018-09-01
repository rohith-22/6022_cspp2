/**
 * import.
 */
import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers.
 * between 2 and n where n is given as an input.
 */
public final class Solution {
	/**
	* Empty constructor.
	*/
	private Solution() {
		/**
		 * notused.
		 */

	}
	/**
	 * Prints the odd composite numbers between 2 and n.
	 *
	 * @param      n     n value
	 */
	static void oddComposites(final int n) {
		/**
		 * code.
		 */
		for ( int i = 8; i < n; i++) {
			if (i % 2 != 0) {
				if (i % 3 == 0 || i %5 == 0 || i % 7 == 0 ) {
				System.out.println(i);

			}
			
			}
		}
	}
	/**
	* main method as driver program.
	* @param args is the parameter for this method
	*/
	public static void main(final String[] args) {
		/**
		 * main.
		 */
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		oddComposites(n);
	}
}

