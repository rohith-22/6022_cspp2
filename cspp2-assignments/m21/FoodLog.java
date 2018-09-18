class FoodLog {
	String nameOfFood;
	String quantityOfFood;
	String date;
	String foodTime;
	FoodLog(String foodName, String foodQuantity, String date, String time) {
		this.nameOfFood = foodName;
		this.quantityOfFood = foodQuantity;
		this.date = date;
		this.foodTime = time;
	}
	public String getFoodName() {
		return this.nameOfFood;
	}
	public String getFoodQuantity() {
		return this.quantityOfFood;
	}
	public String getDate() {
		return this.date;
	}
	public String getFoodTime() {
		return this.foodTime;
	}
	public String toString() {
		return "Food" + "\n" + "Date:" + getDate() + "Time:" + getFoodTime() + "\n" + "Name:" +  getFoodName() +"\n" + "Quantity:" +  getFoodQuantity() + "\n";
	}
}