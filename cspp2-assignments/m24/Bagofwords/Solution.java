import java.util.*;
import java.io.*;
/**
 * Class for solution.
 */
public class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * main.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    BagOfWords objBow = new BagOfWords();
    Scanner sc = new Scanner(System.in);
    try {
      File file = new File(sc.next());
      File[] listOfFiles = file.listFiles();
      objBow.words(listOfFiles);
    } catch (NoSuchElementException e) {
      System.out.println("empty directory");
    }
  }
}
