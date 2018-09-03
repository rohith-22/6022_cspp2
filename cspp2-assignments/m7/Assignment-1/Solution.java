/**
 * Importing Scannar for input.
 */
import java.util.Scanner;
/**
 * it is called from main function.
 * constructor for InputValidator.
 */
class InputValidator {
  /**
   * constructor class.
   */
  static String input;
  /**
   * Constructs the object here.
   *
   * @param      input  The input from main
   */
  public InputValidator(String input) {
    /**
     * this is key word for object creation here.
     */
    this.input = input;
  }
  /**
   * this returns a boolean value.
   * it returns either true or false.
   * @return   true or false  
   */
  public static boolean validateData() {
    /**
     * length is calculated here.
     */
    int length = input.length();
    if (length == 6) {
      return true;
    } else {
      return false;
    }
  }
}
/**
 * Main Class for solution.
 */
public class Solution {
  /**
   * main function is written here and prints out the output.
   */
  public static void main(String args[]) {
    /**
     * main function is written here and prints out the output.
     */
    Scanner s = new Scanner(System.in);
    String input = s.next();
    InputValidator i = new InputValidator(input);
    System.out.println(i.validateData());

  }

}
