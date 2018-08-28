import java.util.*;
public class DegreesToFahrenheit
{
	public static void main(String[] args)
	{
		double Faren;
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter Degree: ");
		float Degree = reader.nextInt();
		Faren = Degree * 1.8 + 32;
		System.out.println(Faren);
	}
}