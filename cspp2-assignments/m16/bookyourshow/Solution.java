import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
/**
 * Class for show.
 * this enables the user to give the movie details.
 */
class Show {

	private String[] seatNumbers;
	private String nameOfMovie;
	private String showDateTime;
	/**
	 * Constructor for class show.
	 *
	 * @param      movie     The movie
	 * @param      dateTime  The date time
	 * @param      seats     The seats
	 */
	public Show(String movie, String dateTime, String[] seats) {
		seatNumbers = new String[seats.length];
		nameOfMovie = movie;
		showDateTime = dateTime;
	}
	/**
	 * getter method which gives the movie name.
	 *
	 * @return    returns  The movie name.
	 */
	public String getMovieName() {
		return nameOfMovie;
	}
	/**
	 * Gets the date time.
	 *
	 * @return    returns  The date time.
	 */
	public String getDateTime() {
		return showDateTime;
	}
	/**
	 * Gets the seats.
	 *
	 * @return    returns The seats.
	 */
	public String[] getSeats() {
		return seatNumbers;
	}
	/**
	 * Sets the seat.
	 *
	 * @param      index  The index
	 * @param      set    The set variable is used to change the seat name.
	 */
	public void setSeat(int index, String set) {
		seatNumbers[index] = set;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return nameOfMovie + "," + showDateTime;
	}
}
/**
 * Class for patron.
 * details of user.
 */
class Patron {
	/**
	 * variable to store username.
	 */
	private String nameOfUser;
	/**
	 * variable to store mobilenumber.
	 */
	private String mobileNumber;
	/**
	 * constructor for patron class with the following aurguments.
	 *
	 * @param      name    The name
	 * @param      number  The number
	 */
	Patron(String name, String number) {
		nameOfUser = name;
		mobileNumber = number;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return nameOfUser;
	}
	/**
	 * Gets the mobile number.
	 *
	 * @return     The mobile number.
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
}
/**
 * Class for book your show.
 */
class BookYourShow {
	List <Show> listObject;
	List<String> bookedTickets;
	/**
	 * Constructs the object.
	 */
	BookYourShow() {
		/**
		 * list to store Show object.
		 */
		listObject = new List<Show>();
		/**
		 * list to store booked tickets.
		 */
		bookedTickets = new List<String>();
	}
	/**
	 * Adds a show object to the list.
	 *
	 * @param      obj   The object
	 */
	public void addAShow(Show obj) {
		listObject.add(obj);

	}
	/**
	 * Gets a show from the list
	 *
	 * @param      movieName  The movie name
	 * @param      dateTime   The date time
	 *
	 * @return     A show.
	 */
	Show getAShow(String movieName, String dateTime) {
		for (int i = 0; i < listObject.size(); i++) {
			if (listObject.get(i).getMovieName().equals(movieName) &&
			    listObject.get(i).getDateTime().equals(dateTime)) {
				return listObject.get(i);
			}
		}
		return null;
	}
	/**
	 * bookAshow enables user to book his tickets.
	 *
	 * @param      movieName  The movie name
	 * @param      dateTime   The date time
	 * @param      obj        The object
	 * @param      seats      The seats
	 */
	public void bookAShow(String movieName, String dateTime, Patron obj, String[] seats) {
		Show objectShow = getAShow(movieName, dateTime);
		if (objectShow != null) {
			for (int i = 0; i < objectShow.getSeats().length; i++) {
				for (int j = 0; j < seats.length; j++) {
					if (objectShow.getSeats()[i].equals(seats[j])) {
						objectShow.setSeat(i, "N/A");
						bookedTickets.add(obj.getMobileNumber() + " " + movieName + " " + dateTime);

					}
				}
			}
		} else {
			System.out.println("No show");
		}
	}
	/**
	 * print ticket prints the ticket which is booked.
	 *
	 * @param      movieName     The movie name
	 * @param      dateTime      The date time
	 * @param      mobileNumber  The mobile number
	 */
	public void printTicket(String movieName, String dateTime, String mobileNumber) {
		for (int i = 0; i < bookedTickets.size(); i++) {
			if ((mobileNumber + " " + movieName + " " + dateTime).equals(bookedTickets.get(i))) {
				System.out.println(mobileNumber + " " + movieName + " " + dateTime);
				return;
			}
		}
		System.out.println("Invalid");
		return;
	}
	/**
	 * Shows all prints all the movies.
	 */
	void showAll() {
		for (int i = 0; i < listObject.size(); i++) {
			System.out.println(listObject.get(i).toString() + "," +
			                   Arrays.toString(listObject.get(i).getSeats()).replace(" ", ""));
		}
	}
}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * main method to drive program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		BookYourShow bys = new BookYourShow();
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] tokens = scan.nextLine().
			                  replace("[", "").replace("]", "").split(",");
			String[] check = tokens[0].split(" ");
			switch (check[0]) {
			case "add":
				int k = 2;
				String[] seats = new String[tokens.length - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.addAShow(new Show(check[1], tokens[1], seats));
				break;

			case "book":
				k = 2 + 2;
				seats = new String[tokens.length - 2 - 2];
				for (int j = 0; j < seats.length; j++) {
					seats[j] = tokens[k++];
				}
				bys.bookAShow(check[1], tokens[1],
				              new Patron(tokens[2], tokens[2 + 1]), seats);
				break;

			case "get":
				Show show = bys.getAShow(check[1], tokens[1]);
				if (show != null) {
					System.out.println(show);
				} else {
					System.out.println("No show");
				}
				break;

			case "print":
				bys.printTicket(check[1], tokens[1], tokens[2]);
				break;

			case "showAll":
				bys.showAll();
				break;

			default:
				break;
			}
		}
	}
}