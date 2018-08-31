/**
 * { item_description }.
 */
import java.util.Scanner;
public class Solution
{/*
	Do not modify the main function 
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse=reverseString(s);	
		System.out.println(reverse);
		
	}
	static String reverseString(final String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i ++) {
			temp = s.charAt(i) + temp;
		}
		return temp;
	}  
}
