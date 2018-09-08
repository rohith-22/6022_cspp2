import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Rohith kumar.
 */
class Set {
  //your code goes here...
  //Good luck :-)
  /**
  *private set.
  */
  private int[] set;
  /**
   * private size.
   */
  private int size;
  /**
   * Constructs the object.
   */
  public Set() {
    final int TEN = 10;
    set = new int[TEN];
    size = 0;
  }
  /**
   * overloaded constructor.
   */
  public Set(int sizeOFSet) {
    set = new int[sizeOFSet];
    size = 0;
  }
  /**
   * size of the set
   *
   * @return     returns size.
   */
  public int size() {
    return size;
  }

  /**
   * checks wheather given item is in set or not.
   *
   * @param      item  The item
   *
   * @return     returns boolean.
   */
  public boolean contains(final int item) {
    for (int i = 0; i < size; i++) {
      if (set[i] == item) {
        return true;
      }
    }
    return false;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    String tempString = "{";
    if (size == 0) {
      return "{}";
    }
    for (int i = 0; i < size - 1 ; i++) {
      tempString += set[i] + ", ";
    }
    tempString += set[size - 1] + "}";
    return tempString;
  }
  /**
   * adds item to set.
   *
   * @param      item  The item
   */
  public void add(final int item) {
    if (size == set.length) {
      set = reSize();
    }
    if (!contains(item)) {
      set[size++] = item;
    }
  }
  /**
   * rezies the set when it is full.
   *
   * @return   returns the resized set.
   */
  private int[] reSize() {
    return java.util.Arrays.copyOf(set, size * 2);
  }
  /**
   * adds the given set to set.
   *
   * @param      items  The items
   */
  public void add(final int[] items) {
    if (size + items.length > set.length) {
      set = reSize();
    }
    for (int i = size; i < items.length ; i++) {
      if (!contains(items[i])) {
        set[size++] = items[i];
      }
    }
  }
  /**
   * intersection function.
   *
   * @param      items  The items
   *
   * @return     returns a set.`
   */
  public Set intersection(final Set items) {
    Set temp = new Set(items.size());
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < items.size(); j++) {
        if (set[i] == items.set[j]) {
          temp.add(set[i]);
        }
      }

    }
    return temp;
  }
  /**
   * retain all function.
   *
   * @param      items  The items
   *
   * @return     returns a set
   */
  public Set retainAll(final int[] items ) {
    Set temp = new Set(items.length);
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < items.length; j++) {
        if (set[i] == items[j]) {
          temp.add(set[i]);
        }
      }

    }
    return temp;
  }
  /**
   * cartesian product.
   *
   * @param      items  The items
   *
   * @return     returns a set.
   */
  public int[][] cartesianProduct(final Set items) {
    int [][] temp = new int[size * items.size()][2];
    for (int i = 0; i < items.size(); i ++) {
      for (int j = 0; j < 2; j++) {
        temp[i][0] = set[i];
        temp[1][j] = items.set[j];
      }
    }
    return temp;
  }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {

  }
  /**
   * helper function to convert string input to int array.
   *
   * @param      s     { string input from test case file }
   *
   * @return     { int array from the given string }
   */
  public static int[] intArray(final String s) {
    String input = s;
    if (input.equals("[]")) {
      return new int[0];
    }
    if (s.contains("[")) {
      input = s.substring(1, s.length() - 1);
    }
    return Arrays.stream(input.split(","))
           .mapToInt(Integer::parseInt)
           .toArray();
  }
  /**
   * main function to execute test cases.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    // instantiate this set
    Set s = new Set();
    // code to read the test cases input file
    Scanner stdin = new Scanner(new BufferedInputStream(System.in));
    // check if there is one more line to process
    while (stdin.hasNext()) {
      // read the line
      String line = stdin.nextLine();
      // split the line using space
      String[] tokens = line.split(" ");
      // based on the list operation invoke the corresponding method
      switch (tokens[0]) {
      case "size":
        System.out.println(s.size());
        break;
      case "contains":
        System.out.println(s.contains(Integer.parseInt(tokens[1])));
        break;
      case "print":
        System.out.println(s);
        break;
      case "add":
        int[] intArray = intArray(tokens[1]);
        if (intArray.length == 1) {
          s.add(intArray[0]);
        } else {
          s.add(intArray);
        }
        break;
      case "intersection":
        s = new Set();
        Set t = new Set();
        intArray = intArray(tokens[1]);
        s.add(intArray);
        intArray = intArray(tokens[2]);
        t.add(intArray);
        System.out.println(s.intersection(t));
        break;
      case "retainAll":
        s = new Set();
        intArray = intArray(tokens[1]);
        s.add(intArray);
        intArray = intArray(tokens[2]);
        System.out.println(s.retainAll(intArray));
        break;
      case "cartesianProduct":
        s = new Set();
        t = new Set();
        intArray = intArray(tokens[1]);
        s.add(intArray);
        intArray = intArray(tokens[2]);
        t.add(intArray);
        System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
        break;
      default:
        break;
      }
    }
  }
}
