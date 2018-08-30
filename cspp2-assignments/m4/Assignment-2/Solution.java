/**
 * import.
 */
import java.util.Scanner;
/**
 * public.
 */
public final class Solution {
    /**
     * private.
     */
    private Solution() {
        /**
         * unused.
         */

    }
    /**
     * input.
     */
    static Scanner sc = new Scanner(System.in);
    /**
     * main.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        /**
         * { var_description }.
         */
        int[][] arr1 = arr();
        int[][] arr2 = arr();
        int row1 = arr1.length;
        int column1 = arr1[0].length;
        int row2 = arr2.length;
        int column2 = arr2[0].length;
        if (row1 == row2 && column1 == column2) {
            int[][] addarray = add(arr1, arr2, row1, column1);
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column1 - 1; j++) {
                System.out.print(addarray[i][j] + " ");
                }
            System.out.println(addarray[i][column1 - 1]);
            }
        } else {
            System.out.println("not possible");
        }

    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    static int[][] arr() {
        /**
         * { var_description }.
         */
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // for (int i = 0; i < m; i++) {
        //  for (int j = 0; j < n; j++) {
        //      System.out.print(arr[i][j]);
        //  }
        //  System.out.println("");
        // }
        return arr;
    }
    /**
     * { function_description }.
     *
     * @param      arr1    The arr 1
     * @param      arr2    The arr 2
     * @param      row     The row
     * @param      column  The column
     *
     * @return     { description_of_the_return_value }
     */
    static int[][] add(final int[][] arr1, final int[][] arr2,
        final int row, final int column) {
        /**
         * { var_description }.
         */
        int[][] arr = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            return arr;
    }
}
