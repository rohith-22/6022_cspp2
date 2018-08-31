/**
* { item_description }.
*/
import java.util.Scanner;
/**
* Class for solution.
*/
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        /**
        * unused.
        */
    }
    /**
    * { function_description }.
    *
    * @param      args  The arguments
    */
    public static void main(final String[] args) {
        /**
        * { var_description }.
        */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
    * function.
    * @param      s     { parameter_description }
    *
    * @return     { description_of_the_return_value }
    */
    static String reverseString(final String s) {
        /**
        * { var_description }.
        */
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i) + temp;
        }
        return temp;
    }
}
