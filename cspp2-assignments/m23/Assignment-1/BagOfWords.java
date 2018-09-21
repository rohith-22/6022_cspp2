import java.util.*;
import java.io.*;
public class BagOfWords {
	BagOfWords() {
		
	}
	public void words(File[] list){
		Plagiarism objP = new Plagiarism();
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
			int temp = 0;
			String tempStrOne = "";
			String tempStrTwo = "";

			System.out.println();
			for (int i = 0; i < text.size(); i++) {
				System.out.print(listOfFiles[i].getName());
				for (int j = 0; j < text.size(); j++) {
					System.out.print("\t\t" + objP.cosineSimilarity(text.get(i), text.get(j)));
					if (objP.cosineSimilarity(text.get(i), text.get(j)) > temp
					        && objP.cosineSimilarity(text.get(i), text.get(j)) != 100) {
						temp = objP.cosineSimilarity(text.get(i), text.get(j));
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

}



// }
