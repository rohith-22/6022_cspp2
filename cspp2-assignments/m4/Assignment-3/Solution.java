
/**
*Given an String, Write a java method that returns the decimal value for the given binary string.
*/
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	Do not modify this main function.
	*/
	private Solution() {
		/**
		 * unused.
		 */
	}
	/**
	 * main.
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		/**
		 * input Scanner.
		 */
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i <= n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	/**
	 * { function_description }.
	 * @param      s     { parameter_description }
	 * @return     { description_of_the_return_value }
	 */
	static String binaryToDecimal(final String s) {
		/**
		 * { var_description }.
		 */
		int temp = 0;
		int k = s.length();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			//System.out.println(ch);
			if (ch == '1') {
				temp += pow(2, k - 1);
				//System.out.println(temp);
			}
			k -= 1;
		}
		String b = Integer.toString(temp);
		return b;
	}
	/**
	 * { function_description }.
	 *
	 * @param      base   The base
	 * @param      power  The power
	 *
	 * @return     { description_of_the_return_value }
	 */
	static int pow(final int base, final int power) {
		/**
		 * { item_description }.
		 */
		if (power == 0) {
			return 1;
		} else {
			return 2 * pow(base, power - 1);
		}
	}

}
