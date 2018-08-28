import java.util.Scanner;
public class BiggerEqualSmaller{
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int varA = a.nextInt();
		int varB = a.nextInt();
		if (varA > varB)	System.out.println("bigger");
		if (varA < varB)	System.out.println("smaller");
		if (varA == varB) System.out.println("equal");

	}
}