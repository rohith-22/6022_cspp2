/**
*importing java.
*/
import java.util.Scanner;
/**
*class fine name.
*/
public class Solution {
    /**
    *Do not modify this main function.
    */
    private Solution() {
    /**
    *private constructor
    */
    }
    /**
    *empty constructor
    */
    public static void main(final String[] args) {
        /**
        *input from scanner
        */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /*
    *Need to write the rootsOfQuadraticEquation function and print the output.
    */
    public static void rootsOfQuadraticEquation(final int a,final int b,final int c) {
        /**
        *formula for Quadratic fuction
        */
        double r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        System.out.println(r1 + " " + r2);
    }
}   
