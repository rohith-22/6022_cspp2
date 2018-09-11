import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

class List {
  /**
   * final int number.
   */
  private final int num = 10;
  /**
   * this is private list declaratiion.
   */
  private int[] list;
  /**
   * this is privaet size declaration.
   */
  private int size;

  /**
   * The purpose of the constructor is to initialize the class variables with.
   * some default values.
   */
  public List() {

    list = new int[num];
    size  = 0;

  }

  /**
   * The add method does what the name suggests. Add an int item to the list.
   * The assumption is to store the item at the end of the list What is the
   * end of the list? Is it the same as the end of the array? Think about how
   * you can use the size variable to add item to the list.
   *
   * The method returns void (nothing)
   *
   * @param      item  The item
   */
  public void add(final int item) {
    list[size] = item;
    size++;
  }

  /**
   * The size method returns the value of the size. The purpose of the method.
   * is to announce the size of the list to the objects outside the list
   *
   * The method returns an int. Empty list should return 0.
   *
   * @return     returns size.
   */
  public int size() {
    return size;
  }
  /**
   * this function removes the element from given index.
   *
   * @param      index      The index
   *
   * @throws     Exception  throws a invalid position exception.
   */
  public void remove(final int index) throws Exception {
    if (index >= size || index < 0) {
      throw new Exception("Invalid Position Exception");
    }
    for (int i = index; i < size; i++) {
      list[i] = list[i + 1];
    }
    size--;
  }
  /**
   * this is a getter function to get the last element from the list.
   *
   * @param      index  The index
   *
   * @return     this returns the last element from the list.
   */
  public int get(final int index) {
    return list[index];
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    if (size == 0) {
      return "[]";
    }

    String str = "[";
    for (int i = 0; i < size - 1; i++) {
      str += list[i] + ",";
    }
    str += list[size - 1] + "]";
    return str;
  }
  /**
   * Contains return true if the list has the item passed as an argument to.
   * the method So, iterate through the list and return true if the item
   * exists and otherwise false
   *
   * @param      item  The item
   *
   * @return     returns the boolean value.
   */
  public boolean contains(final int item) {
    for (int i = 0; i < size; i++) {
      if (list[i] == item) {
        return true;
      }
    }
    return false;
  }
  /**
   * Returns the index of the first occurrence of the specified element in.
   * this list, or -1 if this list does not contain the element.
   *
   * @param      item  The item
   *
   * @return     returns the index value.
   */
  public int indexOf(final int item) {
    for (int i = 0; i < size; i++) {
      if (list[i] == item) {
        return i;
      }
    }
    return -1;
  }
  /**
   * this method is called when the size of the arrray is full.
   * this method returns a array of double the size.
   * @return     returns the resize list.
   */
  public int[] resize() {
    int[] list2 = new int[size * 2];
    for (int i = 0; i < size; i++) {
      list2[i] = list[i];
    }
    return list2;
  }
  /**
  Inserts all the elements of specified int array to the end of list.

  @param      newArray  The new array
  */
  public void addAll(final int[] newArray) {
    for (int i = 0; i < newArray.length; i++) {
      list[size] = newArray[i];
      size++;
      if (size > list.length / 2) {
        list = resize();
      }
    }
  }
  /**
  *Removes all of its elements that are contained in the specified int array.
   @param      newArray  The new array
  */
  public void removeAll(final int[] newArray) throws Exception {
    for (int i = 0; i < newArray.length; i++) {
      for (int j = 0; j < size; j++) {
        if (newArray[i] == list[j]) {
          remove(j);
          j--;
        }
      }
    }
  }
  /**
  Returns a list object containing elements, including startIndex and.
  excluding endIndex. The first parameter indicates the startIndex and the
  second parameter indicates the endIndex. Returns null and print
  "Index Out of Bounds Exception" if any of values start and end are negative
  and also if start is greater than end.

  @param      start  The start
  @param      end    The end

  @return     returnd s dublidt from s given list
  */
  public List subList(final int start, final int end) throws Exception {
    List subList = new List();
    if (start < 0 || end <= 0 || start > end
        || start > size || end > size) {
      throw new Exception("Index Out of Bounds Exception");
    } else {
      for (int i = start; i < end; i++) {
        subList.add(list[i]);
      }
    }
    return subList;
  }
  /**
  Returns a boolean indicating whether the parameter i.e a List object is.
  exactly matching with the given list or not.

  @param      nlist  The nlist

  @return     returns a boolean value.
  */
  public boolean equals(final List nlist) {
    int[] a = nlist.list;
    int cnt = 0;
    if (nlist.size() == size) {
      for (int i = 0; i < size; i++) {
        if (list[i] == a[i]) {
          cnt++;
        }
      }
    }
    return (cnt == size);
  }
  /**
   * this a add function which enables user to add the elements to array.
   *this returns nothing.
   * @param      index  The index
   * @param      item   The item
   */
  public void add(final int index, final int item) {
    if (index >= 0) {
      int[] b = Arrays.copyOfRange(list, 0, list.length);
      // System.out.println(Arrays.toString(b));
      for (int i = index; i < size; i++) {
        // System.out.println(i);
        list[i + 1] = b[i];
        // System.out.println(Arrays.toString(a));
      }
      size++;
      list[index] = item;
    } else {
      System.out.println("Negative Index Exception");
    }
  }
  /**
   * Removes all the elements from list. Think about this case and make the.
   * method the simpler.
   */
  public void clear() {
    list = new int[num];
    size = 0;
  }
  /**
   * this function gives the count of the item.
   *
   * @param      item  The item
   *
   * @return     returns count.
   */
  public int count(final int item) {
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (item == list[i]) {
        count++;
      }
    }
    return count;
  }
}
/**
 * main function.
 *
 * @param      args  The arguments
 */
public class Solution {
  public static void main(final String[] args) {
    // create an object of the list to invoke methods on it
    List l = new List();

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
      case "add":
        if ((tokens.length) == 2) {
          String[] t = tokens[1].split(",");
          if (t.length == 1) {
            l.add(Integer.parseInt(tokens[1]));
          } else {
            if (t.length > 1) {
              l.add(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
            }
          }
        }
        break;
      case "size":
        System.out.println(l.size());
        break;
      case "print":
        System.out.println(l);
        break;
      case "remove":
        try {
          if (tokens.length == 2) {
            l.remove(Integer.parseInt(tokens[1]));
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        break;
      case "indexOf":
        if (tokens.length == 2) {
          System.out.println(l.indexOf(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "count":
        System.out.println(l.count(Integer.parseInt(tokens[1])));
        break;
      case "get":
        if (tokens.length == 2) {
          System.out.println(l.get(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "contains":
        if (tokens.length == 2) {
          System.out.println(l.contains(
                               Integer.parseInt(tokens[1])));
        }
        break;
      case "addAll":
        if (tokens.length == 2) {
          String[] t1 = tokens[1].split(",");
          int[] temp = new int[t1.length];
          for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.parseInt(t1[i]);
          }
          l.addAll(temp);
        }
        break;
      case "removeAll":
        try {
          if (tokens.length == 2) {
            String[] t2 = tokens[1].split(",");
            int[] a = new int[t2.length];
            for (int i = 0; i < t2.length; i++) {
              a[i] = Integer.parseInt(t2[i]);
            }
            l.removeAll(a);
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        break;
      case "subList":
        if (tokens.length != 2) {
          break;
        }
        try {
          String[] arrstring3 = tokens[1].split(",");
          List object = l.subList(Integer.parseInt(arrstring3[0]),
                                  Integer.parseInt(arrstring3[1]));
          if (object != null) {
            System.out.println(object);
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        break;

      case "equals":
        if (tokens.length == 2) {
          String[] lt = tokens[1].split(",");
          List l2 = new List();
          for (int k = 0; k < lt.length; k++) {
            l2.add(Integer.parseInt(lt[k]));
          }
          System.out.println(l.equals(l2));
        }
        break;
      case "clear":
        l.clear();
        break;
      default:
        break;
      }
    }
  }
}

