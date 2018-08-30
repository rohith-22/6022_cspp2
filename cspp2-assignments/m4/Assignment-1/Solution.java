
import java.util.*;
public class Solution
{/*
	Fill this main function to print maximum of given array
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int arr[] = new int[n];
		int temp = 0;
		for (int i = 0; i < n; i++){
			arr[i] = sc.nextInt();
			if (temp < arr[i]){
				temp = arr[i];
			}
		}
		System.out.println(temp);
	}
}
