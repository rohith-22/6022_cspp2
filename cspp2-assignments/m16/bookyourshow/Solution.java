import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {
	private String nameOfTheMovie;
	private String dateAndTime;
	private String[] seatNumbers;
	/**
	 * Constructor for the class show.
	 *
	 * @param      m  moviename.
	 * @param      dt date and time.
	 * @param      s  seats string.
	 */
	Show(String m, String dt, String[] s) {
		this.nameOfTheMovie = m;
		this.dateAndTime = dt;
		this.seatNumbers = s;
	}
	/**
	 * Gets the movie name.
	 *
	 * @return returns the movie name.
	 */
	public String getMovieName() {
		return this.nameOfTheMovie;
	}
	/**
	 * Gets the date and time.
	 *
	 * @return returns date and time.
	 */
	public String getDateAndTime() {
		return this.dateAndTime;
	}
	/**
	 * Gets the seat numbers.
	 *
	 * @return returns the seat numbers.
	 */
	public String[] getSeatNumbers() {
		return this.seatNumbers;
	}
	/**
	 * Sets the seat.
	 *
	 * @param index the index variable.
	 * @param set the set variable to set the name of seat.
	 */
	public void setSeat(int index, String set) {
		seatNumbers[index] = set;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return returns string representation of the object.
	 */
	public String toString() {
		return this.nameOfTheMovie + "," + this.dateAndTime;
	}
}
/**
 * Class for user details.
 */
class Patron {
	/**
	 * username variable.
	 */
	private String patronName;
	/**
	 * mobile number variable.
	 */
	private String mobileNumber;
	/**
	 * constructor for patron class with the following aurguments.
	 *
	 * @param      name    The name
	 * @param      number  The number
	 */
	Patron(String n, String mbnum) {
		this.patronName = n;
		this.mobileNumber = mbnum;
	}
	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.patronName;
	}
	/**
	 * Gets the mobile number.
	 *
	 * @return     The mobile number.
	 */
	public String getMobileNumber() {
		return this.mobileNumber;
	}
}


class BookYourShow {
	List<Show> listObject;
	List<String> bookedTickets;
	public BookYourShow() {
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
	public Show getAShow(String movieName, String dateAndTime) {
		for (int i = 0; i < listObject.size(); i++) {
			if (listObject.get(i).getMovieName().equals(movieName) &&
			    listObject.get(i).getDateAndTime().equals(dateAndTime)) {
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
	public void bookAShow(String movieName, String dateAndTime,
	                      Patron obj, String[] seats) {
		Show movieData = getAShow(movieName, dateAndTime);
		if (movieData != null) {
			for (int i = 0; i < movieData.getSeatNumbers().length; i++) {
				for (int j = 0; j < seats.length; j++) {
					if (seats[j].equals(movieData.getSeatNumbers()[i])) {
						movieData.setSeat(i, "N/A");
						bookedTickets.add(obj.getMobileNumber() + " " +
						                  movieName + " " + dateAndTime);
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
	public void printTickets(String movieName, String dateAndTime,
	                         String mobileNumber) {
		for (int i = 0; i < bookedTickets.size(); i++) {
			if ((mobileNumber + " " + movieName + " " +
			     dateAndTime).equals(bookedTickets.get(i))) {
				System.out.println(mobileNumber + " " +
				                   movieName + " " + dateAndTime);
				return;
			}
		}
		System.out.println("Invalid");
		return;
	}
	/**
	 * Shows all prints all the movies.
	 */
	public void showAll() {
		for (int i = 0; i < listObject.size(); i++) {

			System.out.println(listObject.get(i).toString()
			                   + "," + Arrays.toString(listObject.get(i).
			                       getSeatNumbers()).replace(" ", ""));
		}
	}
}
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * main method for class solution.
	 *
	 * @param args  The arguments.
	 */
	public  static void main(final String[] args) {
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
				bys.printTickets(check[1], tokens[1], tokens[2]);
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

