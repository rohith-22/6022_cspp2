import java.util.Arrays;
class DataBase {
	private List<User> userDetails;
	DataBase() {
		userDetails = new List<User>();
	}
	public void addConnection(String user, String friend) {
		for (int i = 0; i < userDetails.size(); i++) {
			if (user.equals(userDetails.get(i).getUser())) {
				userDetails.get(i).addFollower(friend);
			}
		}
	}
	public void addConnection(User userObj) {
		userDetails.add(userObj);
	}
	public void getConnections(String user) {
		for (int i = 0; i < userDetails.size(); i++) {
			if (user.equals(userDetails.get(i).getUser())) {
				System.out.println(userDetails.get(i).print());
				return;
			}
		}
		System.out.println("Not a user in Network");
	}
	public void getCommonConnections(String userOne, String userTwo) {
		List<String> listA = new List<String>();
		List<String> listB = new List<String>();
		List<String> resultant = new List<String>();
		for (int i = 0; i < userDetails.size(); i++) {
			if (userOne.equals(userDetails.get(i).getUser())) {
				listA = userDetails.get(i).getList();
			}
		}
		for (int i = 0; i < userDetails.size(); i++) {
			if (userTwo.equals(userDetails.get(i).getUser())) {
				listB = userDetails.get(i).getList();
			}
		}
		for (int i = 0; i < listA.size(); i++) {
			if (listB.contains(listA.get(i))) {
				resultant.add(listA.get(i));
			}
		}
		System.out.println(resultant);
	}
	public void showAll() {
		String[] userNames = new String[userDetails.size()];
		for (int i = 0; i < userDetails.size(); i++) {
			userNames[i] = userDetails.get(i) +"";
		}
		Arrays.sort(userNames);
		String str = Arrays.toString(userNames);
		System.out.println(str.substring(1,str.length()-1));
	}
}