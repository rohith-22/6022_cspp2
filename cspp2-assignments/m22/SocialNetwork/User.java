class User {
	private String user;
	private List<String> followers;
	User(String user) {
		this.user = user;
		followers = new List<String>();
	}
	public String getUser() {
		return this.user;
	}
	public void addFollower(String[] follower) {
		followers.addAll(follower);
	}
	public void addFollower(String follower) {
		followers.add(follower);
	}
	public List<String> getList() {
		return followers;
	}
	public String toString() {
		return this.user+": "+followers;
	}
	public String print() {
		return this.followers + "";
	}
}
