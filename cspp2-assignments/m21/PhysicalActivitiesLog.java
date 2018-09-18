class PhysicalActivitiesLog {
	String nameOfActivity;
	String startTime;
	String endTime;
	String notes;
	String date;
	PhysicalActivitiesLog(String nameOfActivity,  String notes, String date, String startTime, String endTime) {
	 this.nameOfActivity  = nameOfActivity;
	 this.startTime = startTime;
	 this.endTime = endTime;
	 this.notes = notes;
	 this.date = date;
	}
	public String getActivityName() {
		return this.nameOfActivity;
	}
	public String getStartTime() {
		return this.startTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String s) {
		notes = s;
	}
	public String getDate() {
		return this.date;
	}
	public String toString() {
		return "PhysicalActivity" + "\n" + "Name:" + getActivityName() + "\n" + "Notes:" + getNotes() + "\n" + "Date:" + getDate() + "\n" + "Starttime:" + getStartTime() + "\n" + "Endtime:" + getEndTime() + "\n";
	}
}