class Show {

	private String[] seatNumbers;
	private String nameOfMovie;
	private String showDateTime;
	Show() {

	}
	public Show(String movie, String dateTime, String[] seats) {
		seatNumbers = new String[seats.length];
		nameOfMovie = movie;
		showDateTime = dateTime;
	}
	public String getMovieName() {
		return nameOfMovie;
	}
	public String getDateTime() {
		return showDateTime;
	}
	public String[] getSeats() {
		return seatNumbers;
	}
	public void setSeat(int index, String set) {
		seatNumbers[index] = set;
	}
	public String toString() {
		return nameOfMovie+","+showDateTime;
	}
}