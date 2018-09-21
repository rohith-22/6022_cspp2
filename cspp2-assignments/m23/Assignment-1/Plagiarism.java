import java.util.*;
public class Plagiarism {

	Plagiarism() {

	}
	public Map cleanUp(String t) {
		String[] temp = t.replaceAll("[^a-zA-z0-9 ]", "").replace("^", "").toLowerCase().split(" ");
		Map<String, Integer> map = new HashMap<>();
		for (String eachWord : temp) {
			if (!map.containsKey(eachWord)) {
				map.put(eachWord, 1);
			} else {
				map.put(eachWord, map.get(eachWord) + 1);
			}
		}
		return map;
	}
	public int cosineSimilarity(String docOne, String docTwo) {
		int product = 0;
		int denominatorOne = 0;
		int denominatorTwo = 0;
		Map<String, Integer> mapOne = cleanUp(docOne);
		// System.out.println(mapOne);
		Map<String, Integer> mapTwo = cleanUp(docTwo);
		// System.out.println(mapTwo);
		for (String eachElement : mapOne.keySet()) {

			denominatorOne += Math.pow(mapOne.get(eachElement), 2);

			for (String eachItem : mapTwo.keySet()) {

				if (eachElement.equals(eachItem)) {
					product += mapOne.get(eachItem) * mapTwo.get(eachItem);
				}
			}
		}
		for (String eachItem : mapTwo.keySet()) {

			denominatorTwo += Math.pow(mapTwo.get(eachItem), 2);
		}
		double denominator = Math.sqrt(denominatorOne) * Math.sqrt(denominatorTwo);
		return (int) ((((product / denominator) * 100D) / 100D) * 100);
	}
}