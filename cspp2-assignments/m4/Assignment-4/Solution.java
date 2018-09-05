/**
*importing scanner.
*/
import java.util.Scanner;
/**
* Class for solution.
*/
public final class Solution {
    /**
    * empty constructor.
    */
    private Solution() {
        /**
        * unused.
        */
    }
    /**
    * main function.
    *to reverse the string.
    * @param      args  The arguments
    */
    public static void main(final String[] args) {
        /**
        * scanner for input and  alling reverseString function.
        */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
    * function.
    * @param      s     string type.
    *
    * @return    returns a reverse string.
    */
    static String reverseString(final String s) {
        /**
        * function to return a string.
         * temp is a empty temporary string.
        */
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i) + temp;
        }
        return temp;
    }
}
