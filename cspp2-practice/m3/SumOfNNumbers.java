import java.util.Scanner;
class SumOfNNumbers{
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		int sum = 0;
		for(int i = 1; i <= n; i ++)
			sum += i;
		System.out.println(sum);
	}
}