import java.util.*;
class BookYourShow {
  Patron patron = new Patron();
  List <Show> listObject;
  List<String> bookedTickets;
  BookYourShow() {
    listObject = new List<Show>();
  }
  public void addAShow(Show obj) {
    listObject.add(obj);

  }
  Show getAShow(String movieName, String dateTime) {
    for (int i = 0; i < listObject.size(); i++) {
      if (listObject.get(i).getMovieName().equals(movieName) &&
          listObject.get(i).getDateTime().equals(dateTime)) {
        return listObject.get(i);
      }
    }
    return null;
  }
  void bookAShow(String movieName, String dateTime, Patron obj, String[] seats) {
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

  void printTicket(String movieName, String dateTime, String mobileNumber) {
    for (int i = 0; i < bookedTickets.size(); i++) {
      if ((mobileNumber + " " + movieName + " " + dateTime).equals(bookedTickets.get(i))) {
        System.out.println(mobileNumber + " " + movieName + " " + dateTime);
        return;
      } 
    }
    System.out.println("Invalid");
    return;
  }
  void showAll() {
    for (int i = 0; i < listObject.size(); i++) {
      System.out.println(listObject.get(i).toString() + "," +
        Arrays.toString(listObject.get(i).getSeats()).replace(" ",""));
    }
  }
}