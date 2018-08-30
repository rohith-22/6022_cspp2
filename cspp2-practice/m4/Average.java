import java.util.Scanner;
public class Average {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int temp = 0;
		for (int j = 0; j < n; j++){
			temp += arr[j];
		}
		System.out.println(temp / n);
	}
}