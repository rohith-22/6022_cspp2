import java.util.*;

class StudentInformation {
	static String name, rollNumber;
	static float subOne, subTwo, subThree;

	public StudentInformation(String name, String rollNumber,
	                          float subOne, float subTwo, float subThree) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.subOne = subOne;
		this.subTwo = subTwo;
		this.subThree = subThree;
	}
	float gpa() {
		return (subOne + subTwo + subThree) / 3f ;
	}
}
public class StudentDetails {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();
		for (int i = 0; i < numberOfStudents; i++) {
			String name = sc.next();
			String rollNumber = sc.next();
			float subOne = sc.nextFloat();
			float subTwo = sc.nextFloat();
			float subThree = sc.nextFloat();
			StudentInformation info = new StudentInformation(name, rollNumber,
				subOne, subTwo, subThree);
			System.out.println(info.gpa());
		}
	}
}