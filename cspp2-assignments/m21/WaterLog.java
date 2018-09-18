import java.util.Scanner;

class WaterLog {
	String quantityOfWater;
	String date;
	String time;
	WaterLog(String waterQuantity, String date, String time) {
		this.quantityOfWater = waterQuantity;
		this.date = date;
	}
	public String getWaterQuantity() {
		return this.quantityOfWater;
	}
	public String getDate() {
		return this.date;
	}
	public String toString() {
		return "Water" + "\n" + "Date:" +  getDate() + "\n" + "Quantity:" + getWaterQuantity() + "\n";
	}
}