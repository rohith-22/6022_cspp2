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
  private static final int SIX = 6;
  /**
   * private string input declared here.
   */
  private String input;
  /**
   * Constructs the object here.
   *
   * @param      inputt  The input from main
   */
  public InputValidator(final String inputt) {
    /**
     * this is key word for object creation here.
     */
    this.input = inputt;
  }
  /**
   * this returns a boolean value.
   * it returns either true or false.
   * @return   true or false.
   */
  public boolean validateData() {
    /**
     * length is calculated here.
     */
    int length = input.length();
    return length >= SIX;
  }
}
/**
 * Main Class for solution.
 */
public final class Solution {
  /**
   * private constructor.
   */
  private Solution() {
    /**
     * unused constructor.
     */
  }
  /**
   * main function is written here and prints out the output.
   * @param args string
   */
  public static void main(final String[] args) {
    /**
     * main function is written here and prints out the output.
     */
    Scanner s = new Scanner(System.in);
    String input = s.next();
    InputValidator i = new InputValidator(input);
    System.out.println(i.validateData());
  }
}
