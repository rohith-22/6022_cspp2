import java.util.Scanner;
public class Factorial{
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int a = reader.nextInt();
		System.out.println(fact(a));
	}
	public static int fact(int n){
		if (n == 1)    return 1;
		else    return n * fact(n-1);
	}
}