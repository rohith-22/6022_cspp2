import java.util.Scanner;
public class FirstLast6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		if (arr[0] == 6 || arr[n-1] == 6) {
			System.out.println("true");
		} else{
			System.out.println("false");
		}
		System.out.println(arr.toString());
	}
}
