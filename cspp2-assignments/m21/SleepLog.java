class SleepLog {
	String startTime;
	String endTime;
	String date;
	SleepLog(String date, String startTime, String endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.date = date;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public String getDate() {
		return this.date;
	}
	public String toString() {
		return "Sleep" + "\n" + "Date:" + getDate() + "\n" + "Starttime:" + getStartTime() + "\n" + "Endtime:" + getEndTime() + "\n";
	}
}
