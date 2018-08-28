import java.util.*;
public class Swap
{
	public static void main(String[] args) 
	{
		int temp;
		Scanner reader = new Scanner(System.in);
		System.out.println("enter numbers :");
		int a = reader.nextInt();
		int b = reader.nextInt();
		temp = a;
		a = b;
		b = temp;
		System.out.println(a + " " + b);
	}
	
}