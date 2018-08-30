/**
 * import function.
 */
import java.util.*;
/**
 * Class for solution.
 */
public final class Solution {
/**
Fill this main function to print maximum of given array
*/
	private Solution() {
		/**
		 * unused.
		 */
	}
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		/**
		 * input taken.
		 */
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int arr[] = new int[n];
		int temp = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (temp < arr[i]) {
				temp = arr[i];
			}
		}
		System.out.println(temp);
	}
}
