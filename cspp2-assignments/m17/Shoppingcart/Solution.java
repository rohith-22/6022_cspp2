import java.util.Scanner;
import java.util.Arrays;
class Item {
  private String itemName;
  private int quantityOfItem;
  private double priceOfItem;
  public Item(String item, int quantity, double price) {
    itemName = item;
    quantityOfItem = quantity;
    priceOfItem = price;
  }
  Item(String item, int quantity) {
    itemName = item;
    quantityOfItem = quantity;
  }
  public String getItemName() {
    return itemName;
  }
  public int getQuantity() {
    return quantityOfItem;
  }
  public double getPrice() {
    return priceOfItem;
  }
  public void reduceQuantity(int value) {
    quantityOfItem -= value;
  }
  public void increaseQuantity(int value) {
    quantityOfItem += value;
  }
  public String toString() {
    return itemName + " " + quantityOfItem + " " + priceOfItem;
  }
}
class ShoppingCart {
  private List<Item> listObject;
  private List<Item> cartItems;
  private double totalAmount;
  private double amount;
  private List<String> validCoupons;
  private boolean isCouponValid;
  ShoppingCart() {
    listObject = new List<Item>();
    cartItems = new List<Item>();
    // payableAmount = 0;
  }
  void addToCatalog(final Item details) {
    listObject.add(details);
  }
  void addToCart(Item item) {
    // for (int i = 0; i < cartItems.size(); i++) {
    //   if (item.getQuantity() != 0) {
    //     cartItems.get(i).increaseQuantity(item.getQuantity());
    //     listObject.get(i).reduceQuantity(item.getQuantity());

    //     return;
    //   }
    // }
    for (int i = 0; i < listObject.size(); i++) {
      if (listObject.get(i).getItemName().equals(item.getItemName()) && listObject.get(i).getQuantity() >= item.getQuantity()) {
        cartItems.add(item);
        listObject.get(i).reduceQuantity(item.getQuantity());
      }
    }
    getTotalAmount();
  }
  void removeFromCart(Item item) {
    for (int i = 0; i < cartItems.size(); i++) {
      if (cartItems.get(i).getItemName().equals(item.getItemName()) && cartItems.get(i).getQuantity() >= item.getQuantity()) {
        // System.out.println("enterd");
        if (cartItems.get(i).getQuantity() == item.getQuantity()) {
          cartItems.remove(i);
          // listObject.get(i).increaseQuantity(item.getQuantity());
          return;
        }
        cartItems.get(i).reduceQuantity(item.getQuantity());
        // listObject.get(i).increaseQuantity(item.getQuantity());
      }
    }
    getTotalAmount();
  }
  void showCatalog() {
    for (int i = 0; i < listObject.size(); i++) {
      System.out.println(listObject.get(i));
    }
  }
  void showCart() {
    for (int i = 0; i < cartItems.size(); i++) {
      System.out.println(cartItems.get(i).getItemName() + " " + cartItems.get(i).getQuantity());
    }
  }
  double getTotalAmount() {
    totalAmount = 0;
    for (int i = 0; i < cartItems.size(); i++) {
      for (int j = 0; j < listObject.size(); j++) {
        if (listObject.get(j).getItemName().equals(cartItems.get(i).getItemName()))
          totalAmount += listObject.get(j).getPrice() * cartItems.get(i).getQuantity();
      }
    }
    return totalAmount;
  }
  double getPayableAmount() {
    if (amount == 0) {
      amount = totalAmount;
    }
    return amount + amount * 0.15;

  }
  void applyCoupon(String coupon) {
    amount = totalAmount;
    if (coupon.equals("IND50")) {
      amount -= totalAmount * 50 / 100;
      isCouponValid = true;

    }
    if (coupon.equals("IND10")) {
      amount -= totalAmount * 10 / 100;
      isCouponValid = true;

    }
    if (coupon.equals("IND20")) {
      amount -= totalAmount * 20 / 100;
      isCouponValid = true;

    }
    if (coupon.equals("IND30")) {
      amount -= totalAmount * 30 / 100;
      isCouponValid = true;

    } else {
      System.out.println("Invalid coupon");
      isCouponValid = false;
    }
  }
  void printInvoice() {
    System.out.println("Name   quantity   Price");
    for (int i = 0; i < cartItems.size(); i++) {
      for (int j = 0; j < listObject.size(); j++) {
        if (listObject.get(j).getItemName().equals(cartItems.get(i).getItemName())) {
          System.out.println(cartItems.get(i).getItemName() + " " + cartItems.get(i).getQuantity() + " " + listObject.get(j).getPrice());
        }
      }
    }
    System.out.println("Total:" + totalAmount);
    if (isCouponValid == false) {
      System.out.println("Disc%:" + "0.0");

    } else {
      System.out.println("Disc%:" + amount);
    }
    System.out.println("Tax:" + amount * 0.15);
    System.out.println("Payable amount: " + getPayableAmount());
  }
}
public class Solution {
  private Solution() {

  }
  public static void main(String[] args) {
    ShoppingCart obj = new ShoppingCart();
    Scanner sc = new Scanner(System.in);
    int input = sc.nextInt();
    for (int i = 0; i <= input; i++) {
      String[] tokens = sc.nextLine().split(" ");
      switch (tokens[0]) {
      case "add":
        String[] addArray = tokens[1].split(",");
        obj.addToCart(new Item(addArray[0], Integer.parseInt(addArray[1])));
        break;
      case "Item":
        // System.out.println("items added");
        String[] itemArray = tokens[1].split(",");
        obj.addToCatalog(new Item(itemArray[0], Integer.parseInt(itemArray[1]), Integer.parseInt(itemArray[2])));
        break;
      case "catalog":
        // System.out.println("entered");
        obj.showCatalog();
        break;
      case "show":
        obj.showCart();
        break;
      case "remove":
        String[] removeArray = tokens[1].split(",");
        obj.removeFromCart(new Item(removeArray[0], Integer.parseInt(removeArray[1])));
        break;
      case "totalAmount":
        System.out.println("totalAmount: " + obj.getTotalAmount());
        break;
      case "payableAmount":
        System.out.println(("Payable amount: " + obj.getPayableAmount()));
        break;
      case "coupon":
        obj.applyCoupon(tokens[1]);
        break;
      case "print":
        obj.printInvoice();
        break;
      default:
      }

    }
  }

}