import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * class named "solution".
 */
public class Solution {
  /**
   * constructor for solution class.
   */
  protected Solution() {

  }
  /**
   * main method.
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    ShoppingCart shoppingObject = new ShoppingCart();
    Scanner sc = new Scanner(new BufferedInputStream(System.in));
    while (sc.hasNext()) {
      String line = sc.nextLine();
      String[] tokens = line.split(" ");
      switch (tokens[0]) {
      case "Item":
        String[] items = tokens[1].split(",");
        Item itemObject = new Item(items[0], items[1], items[2]);
        shoppingObject.addToCatalog(itemObject);
        break;
      case "add":
        String[] products = tokens[1].split(",");
        itemObject = new Item(products[0], products[1]);
        shoppingObject.addToCart(itemObject);
        break;
      case "remove":
        items = tokens[1].split(",");
        itemObject = new Item(items[0], items[1]);
        shoppingObject.removeFromCart(itemObject);
        break;
      case "catalog":
        shoppingObject.showCatalog();
        break;
      case "show":
        shoppingObject.showCart();
        break;
      case "totalAmount":
        System.out.println("totalAmount: " + shoppingObject.getTotalAmount());
        break;
      case "payableAmount":
        System.out.println("Payable amount: "
          + shoppingObject.getPayableAmount());
        break;
      case "print":
        System.out.println("Name" + "   " + "quantity" + "   " + "Price");
        shoppingObject.printInvoice();
        break;
      case "coupon":
        shoppingObject.applyCoupon(tokens[1]);
        break;
      default:
      }
    }
  }
}
