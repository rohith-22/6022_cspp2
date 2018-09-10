import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
class SortedSet extends Set {
  private int[] sortedSet;
  private int size;

  public SortedSet() {
    sortedSet = new int[10];
    size = 0;
  }
  public SortedSet(int[] items) {
    sortedSet = new int[10];
    size = 0;
    addAll(items);
  }
  public boolean contains(final int item) {
    for (int i = 0; i < size; i++) {
      if (sortedSet[i] == item) {
        return true;
      }
    }
    return false;
  }
  
  public void addAll(final int[] items) {
    if (size + items.length > sortedSet.length) {
      reSize();
    }
    for (int i = size; i < items.length; i++) {
      if (!contains(items[i])) {
        sortedSet[size++] = items[i];
      }
    }
    sorted();
  }
  private void reSize() {
    sortedSet = java.util.Arrays.copyOf(sortedSet, size * 2);
  }
  public void sorted() {
    sortedSet = Arrays.copyOf(sortedSet, size);
    Arrays.sort(sortedSet);
  }
  public String headSet(int toElement) {
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (sortedSet[i] < toElement) {
        count += 1;
      }
    }
    int[] temp = new int [count];
    int j = 0;
    for (int i = 0; i < size; i++) {
      if (sortedSet[i] < toElement) {
        temp[j++] = sortedSet[i];
      }
    }
    return temp.toString();
  }
  public int get(final int index) {
    if (index < 0 || index >= size) {
      return -1;
    } else {
      return sortedSet[index];
    }
  }
  public int last() {
    return sortedSet[size - 1];
  }
  public int[] subSet(final int start, final int end) {
    if (start > end) {
      System.out.println("Invalid Arguments to Subset Exception");
      return null;
    }
    int[] result = new int[size];
    int k = 0;
    for (int i = 0; i < size; i++) {
      if (sortedSet[i] >= start) {
        for (int j = i; j < size; j++) {
          if (sortedSet[j] < end) {
            result[k++] = sortedSet[i];
          }
          break;
        }
      }
    }
    return Arrays.copyOf(result, k);
  }
  public String toString() {
    String tempString = "{";
    if (size == 0) {
      return "{}";
    }
    for (int i = 0; i < size - 1; i++) {
      tempString += sortedSet[i] + ", ";
    }
    tempString += sortedSet[size - 1] + "}";
    return tempString;
  }
}
public class Solution {
  private Solution() {

  }
  public static int[] stringToArray(String item) {

    return Arrays.stream(item.split(",")).mapToInt(Integer::parseInt).toArray();
  }
  public static String toString(int[] items) {
    String tempString = "{";
    if (items.length == 0) {
      return "{}";
    }
    for (int i = 0; i < items.length - 1; i++) {
      tempString += items[i] + ", ";
    }
    tempString += items[items.length - 1] + "}";
    return tempString;
  }
  public static void main(String[] args) {
    // Set obj = new Set();
    SortedSet s = new SortedSet();
    Scanner numOfOperations = new Scanner(new BufferedInputStream(System.in));
    while (numOfOperations.hasNext()) {
      String line = numOfOperations.nextLine();
      String[] tokens = line.split(" ");
      switch (tokens[0]) {
      case "addAll":
        s.addAll(stringToArray(tokens[1]));
        // System.out.println(Arrays.toString(stringToArray(tokens[1])));
        break;
      case "print":
        System.out.println(s);
        break;
      case "headSet":
        s.headSet(Integer.parseInt(tokens[1]));
        break;
      case "last":
        System.out.println(s.last());
      case "subSet":
        int[] intArray = stringToArray(tokens[1]);
        s.subSet(intArray[1],intArray[2]);
      default:
      }
    }
  }
}