import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * class for item.
 */
class Item {
	/**
	 * name of the item.
	 */
	String nameOfItem;
	/**
	 * quantity of the item.
	 */
	int quantityOfItem;
	/**
	 * cost of one unit of item.
	 */
	float priceOfItem;
	/**
	 * constructor for "item" class.
	 * @param      name       name of the item.
	 * @param      quantity   quantity of the item.
	 * @param      priceOfItem  unit price of the item.
	 */
	Item(final String name, final String quantity, final String priceOfItem) {
		this.nameOfItem = name;
		this.quantityOfItem = Integer.parseInt(quantity);
		this.priceOfItem = Float.parseFloat(priceOfItem);
	}
	/**
	 * constructor for class "item".
	 * @param      name      name of the item.
	 * @param      quantity  quantity of the item.
	 */
	Item(String name, String quantity) {
		this.nameOfItem = name;
		this.quantityOfItem = Integer.parseInt(quantity);
	}
	/**
	 * Gets the name of item.
	 * @return returns the name of item.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nameOfItem + " ");
		sb.append(quantityOfItem + " ");
		sb.append(priceOfItem);
		return sb.toString();
	}

}
/**
 * Class named "shoppingcart".
 */
class ShoppingCart {
	Item[] catalog;
	Item[] cart;
	int sizeOfCatalog;
	int sizeOfCart;
	String[] validCoupons = {"IND10", "IND20", "IND30", "IND50"};
	static double discount = 0.0;
	static private boolean couponApplied = false;
	/**
	 * Constructs the object for Shopping cart
	 */
	ShoppingCart() {
		catalog = new Item[20];
		cart = new Item[20];
		sizeOfCatalog = 0;
		sizeOfCart = 0;
	}
	/**
	 * Adds the item to catalog.
	 *
	 * @param      item  The item
	 */
	public void addToCatalog(Item item) {
		catalog[sizeOfCatalog++] = item;
	}
	/**
	 * checks if item is in cart or not.
	 *
	 * @param      item  The item
	 *
	 * @return     returns a true if item in cart else false.
	 */
	public boolean inCart(Item item) {
		for (Item s : cart) {
			if (s != null) {
				if (s.nameOfItem.equals(item.nameOfItem)) {
					s.quantityOfItem += item.quantityOfItem;
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Adds item to cart.
	 *
	 * @param      item  The item
	 */
	public void addToCart(Item item) {
		if (!inCart(item)) {
			if (checkCatalog(item)) {
				cart[sizeOfCart++] = item;
			}
		}
	}
	/**
	 * checks for item in catalog.
	 *
	 * @param      item  The item
	 *
	 * @return     returns true if item is in catalog.
	 */
	private boolean checkCatalog(Item item) {
		for (Item i : catalog) {
			if (i != null) {
				if (i.nameOfItem.equals(item.nameOfItem)) {
					if (item.quantityOfItem <= item.quantityOfItem) {
						i.quantityOfItem -= item.quantityOfItem;
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Removes a item from cart.
	 *
	 * @param      item  The item
	 */
	public void removeFromCart(Item item) {
		for (int i = 0; i < sizeOfCart; i++) {
			if (cart[i].nameOfItem.equals(item.nameOfItem)) {
				cart[i].quantityOfItem -= item.quantityOfItem;
			}
		}
	}
	/**
	 * Shows the catalog.
	 */
	public void showCatalog() {
		for (int i = 0; i < sizeOfCatalog; i++) {
			System.out.println(catalog[i]);
		}
	}
	/**
	 * Shows the cart items.
	 */
	public void showCart() {
		for (int i = 0; i < sizeOfCart; i++) {
			if (cart[i].quantityOfItem != 0) {
				System.out.println(cart[i].nameOfItem + " " + cart[i].quantityOfItem);
			}
		}
	}
	/**
	 * Gets the total amount.
	 * @return     The total amount.
	 */
	public double getTotalAmount() {
		double totalAmount = 0;
		for (int i = 0; i < sizeOfCart; i++) {
			totalAmount  = totalAmount + cart[i].quantityOfItem * getPrice(cart[i]);
		}
		return totalAmount;
	}
	/**
	 * Gets the price.
	 * @param      givenAmount  The given amount
	 * @return     The price.
	 */
	double getPrice(final Item givenAmount) {
		for (Item i : catalog) {
			if (i != null) {
				if (i.nameOfItem.equals(givenAmount.nameOfItem)) {
					return i.priceOfItem;
				}
			}
		}
		return 0.0;
	}
	/**
	 * variable for 100.
	 */
	final int hundred = 100;
	/**
	 * variable for 15.
	 */
	final int fifteen = 15;
	/**
	 * applies a valid coupon.
	 * @param      coupon  The coupon
	 */
	void applyCoupon( final String coupon) {
		if (couponApplied) {
			return;
		}
		boolean variable = false;
		for (String s : validCoupons) {
			if (s.equals(coupon)) {
				int number = Integer.parseInt(coupon.substring(3));
				discount = getTotalAmount() * number / hundred;
				couponApplied = true;
				variable = true;
			}
		}
		if (!variable) {
			System.out.println("Invalid coupon");
			return;
		}
	}
	/**
	 * prints the invoice of the user.
	 */
	public void printInvoice() {
		for (Item i : cart) {
			if (i != null) {
				if (i.quantityOfItem != 0) {
					System.out.println(i.nameOfItem + " " + i.quantityOfItem + " " +  getPrice(i));
				}
			}
		}
		double amount;
		double amountAfterDiscount = getTotalAmount() - discount;
		double tax = (amountAfterDiscount * fifteen) / hundred;
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + discount);
		System.out.println("Tax:" + tax);
		System.out.println("Payable amount: " + getPayableAmount());
	}
	/**
	 * Gets the payable amount.
	 * @return     The payable amount.
	 */
	public double getPayableAmount() {
		double payableAmount;
		double amountAfterDiscount = getTotalAmount() - discount;
		double tax = (amountAfterDiscount * fifteen) / hundred;
		payableAmount = amountAfterDiscount + tax;
		return payableAmount;
	}
}
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
				System.out.println("Payable amount: " + shoppingObject.getPayableAmount());
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