import java.util.Scanner;
public class QuotientRemainder
{
	public static void main(String[] args) {
		int rem ,quo;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter numbers: ");
		int a = reader.nextInt();
		int b = reader.nextInt();
		rem = a % b;
		quo = a / b;
		System.out.println("rem is "+rem +" and "+ "quo is "+quo);
	}

}