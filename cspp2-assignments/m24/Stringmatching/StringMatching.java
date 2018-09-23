import java.util.*;
import java.io.*;
public class StringMatching {
	StringMatching() {

	}
	public void words(File[] list) {
		ArrayList<String> text = new ArrayList<>();
		File[] listOfFiles = list;
		if (listOfFiles.length == 0) {
			System.out.println("empty directory");
		} else {
			Arrays.sort(listOfFiles);
			try {
				System.out.print("      \t\t");
				for (File eachFile : listOfFiles) {
					System.out.print("\t" + eachFile.getName());
					Scanner sc1 = new Scanner(eachFile);
					String str = "";
					while (sc1.hasNext()) {
						str += sc1.nextLine() + " ";
					}
					text.add(str);
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			double temp = 0;
			String tempStrOne = "";
			String tempStrTwo = "";

			System.out.println();
			for (int i = 0; i < text.size(); i++) {
				System.out.print(listOfFiles[i].getName());
				for (int j = 0; j < text.size(); j++) {
					System.out.print("\t\t" + findLCS(text.get(i), text.get(j)));
					if (findLCS(text.get(i), text.get(j)) > temp
					        && findLCS(text.get(i), text.get(j)) != 100) {
						temp = findLCS(text.get(i), text.get(j));
						tempStrOne = listOfFiles[i].getName();
						tempStrTwo = listOfFiles[j].getName();
					}
				}
				System.out.println();
			}
			System.out.println("Maximum similarity is between " + tempStrOne + " and " + tempStrTwo);
			// System.out.println(text.get(0));
		}
	}
	public double findLCS(String firstString, String secondString) {
		int[][] lcsMatrix = new int[firstString.length() + 1][secondString.length() + 1];
		double result = 0;
		double lcsValue = 0;
		if(firstString.length() == 0 && secondString.length() == 0) {
			return 100D;
		}
		for (int i = 0; i <= firstString.length(); i++) {
			for (int j = 0; j <= secondString.length(); j++) {
				if (i == 0 || j == 0) {
					lcsMatrix[i][j] = 0;
				} else if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
				} else {
					lcsMatrix[i][j] = 0;
				}
				if (result < lcsMatrix[i][j]) {
					result = lcsMatrix[i][j];
				}
			}
		}
		lcsValue = ((result * 2) / firstString.length() + secondString.length());
		// System.out.println((int)lcsValue);
		return Math.round(lcsValue * 100D) / 100;
	}

}



// }
