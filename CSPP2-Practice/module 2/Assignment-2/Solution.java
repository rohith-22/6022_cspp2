/**
*importing java.
*/
import java.util.Scanner;
/**
*class fine name.
*/
public final class Solution {
    /**
    *Do not modify this main function.
    */
    private Solution() {
    /**
    *private constructor.
    */
    }
    /**
    *empty constructor.
    *@param args String
    */
    public static void main(final String[] args) {
        /**
        *input from scanner
        */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }
    /**
    *Need to write the rootsOfQuadraticEquation function and print the output.
    *@param a int
    *@param b int
    *@param c int
    */
    public static void roots(final int a, final int b, final int c) {
        /**
        *formula for Quadratic fuction
        */
        double r1 = (-b + Math.sqrt(b * b - 2 * 2 * a * c)) / (2 * a);
        double r2 = (-b - Math.sqrt(b * b - 2 * 2 * a * c)) / (2 * a);
        System.out.println(r1 + " " + r2);
    }
}
