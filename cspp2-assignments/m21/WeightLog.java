class WeightLog {
	String weight;
	String fat;
	String date;
	String time;
	WeightLog(String date, String time, String weight, String fat) {
		this.weight = weight;
		this.fat = fat;
		this.date = date;
		this.time = time;
	}
	public String getWeight() {
		return this.weight;
	}
	public String getFat() {
		return this.fat;
	}
	public String getDate() {
		return this.date;
	}
	public String getTime() {
		return this.time;
	}
	public String toString() {
		return "Weight" + "\n" + "Date:" + getDate() + "\n" + "Time:" + getTime() + "\n" + "Weight:" + getWeight() + "\n" + "Fat:" + getFat() + "\n";
	}
}