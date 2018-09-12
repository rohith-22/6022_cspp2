class Patron {

	private String nameOfUser;
	private String mobileNumber;
	Patron() {

	}
	Patron(String name, String number) {
		nameOfUser = name;
		mobileNumber = number;
	}
	public String getName() {
		return nameOfUser;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
}