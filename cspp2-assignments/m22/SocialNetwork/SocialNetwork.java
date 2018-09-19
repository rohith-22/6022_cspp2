import java.util.*;
public class SocialNetwork {
	SocialNetwork() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DataBase dataObject = new DataBase();
		while (sc.hasNext()) {
			// System.out.println("hi");
			String line = sc.nextLine();
			if (line.contains(" is connected to ")) {
				// System.out.println("abcd");
				String[] tokens = line.split(" is connected to ");
				String[] items = tokens[1].replace(".", "").split(", ");
				User userObj = new User(tokens[0]);
				userObj.addFollower(items);
				dataObject.addConnection(userObj);
			} else {
				String[] input = line.split(" ", 2);
				switch (input[0]) {
				case "addConnections":
					String[] connection = input[1].split(" ");
					dataObject.addConnection(connection[0], connection[1]);
					break;
				case "getConnections":
					dataObject.getConnections(input[1]);
					break;
				case "CommonConnections":
					String[] people = input[1].split(" ");
					dataObject.getCommonConnections(people[0], people[1]);
					break;
				case "Network":
					dataObject.showAll();
				default: break;
				}
			}
		}
	}
}