import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		BagOfWords objBow = new BagOfWords();
		Scanner sc = new Scanner(System.in);
		try {
			File file = new File(sc.next());
			File[] listOfFiles = file.listFiles();
			objBow.words(listOfFiles);
		}
		catch (NoSuchElementException e) {
			System.out.println("empty directory");
		} 
	}
}