/**
* impoting data from java utilities.
*/
import java.util.Scanner;
/**
*Class function.
*/
public final class Solution {
    /**
    Do not modify this main function.
    */
    private Solution() {
        /**
        *private solution empty constructor.
        */
    }
    /**
    *main function begins here.
    *@param args String
    */
    public static void main(final String[] args) {
        /**
        *input is taken here.
        *@param base
        *@param exponent
        */
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    Need to write the power function and print the output.
    */
    public static long power(final int base, final int exponent) {
        /**
        * power recursive is defined here.
        */
        if (exponent == 0) {
            return 1;
        }else {
            return base * power(base, exponent - 1);
        }
    }
}
