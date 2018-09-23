import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.Math;
import java.io.*;
/**
 * Class for document.
 */
class Document {
    /**
     * text 1.
     */
    private String text1;
    /**
     * text 2.
     */
    private String text2;
    /**
     * constructor for document class.
     */
    Document() {
        text1 = "";
        text2 = "";
    }
    /**
     * method to convert from file to string.
     *
     * @param      doc   The document
     *
     * @return  returns string format of a file.
     */
    public static String DocumentToString(final File doc) {
        String fileToString = "";
        try {
            Scanner s = new Scanner(new FileReader(doc));
            StringBuilder sb = new StringBuilder();
            while (s.hasNext()) {
                sb.append(s.next());
                sb.append(" ");
            }
            s.close();
            fileToString = sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("no file");
        }
        return fileToString;
    }
    /**
     * method to remove unnecessary characters.
     *
     * @param      text  The text
     *
     * @return  returns the cleaned up string.
     */
    public static Map removewords(final String text) {
        // text = text.toLowerCase();
        String word = "";
        Pattern p = Pattern.compile("[^0-9_.,]");
        Matcher match = p.matcher(text);
        while (match.find()) {
            word += match.group();
        }
        word = word.toLowerCase();
        String[] words = word.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i  < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }
        return map;
    }
    /**
     * method to compare two strings.
     *
     * @param      stringOne  The string one
     * @param      stringTwo  The string two
     *
     * @return  returns the plagiarism percentage of given strings.
     */
    public static int compare(
        final String stringOne,
         final String stringTwo) {
        float numerator = 0;
        double denominator = 0;
        float firstSum = 0;
        float secondSum = 0;
        Map<String, Integer> firstMap = removewords(stringOne);
        Map<String, Integer> secondMap = removewords(stringTwo);
        for (String inmapOne : firstMap.keySet()) {
            for (String inmapTwo : secondMap.keySet()) {
                if (inmapOne.equals(inmapTwo)) {
                    numerator += firstMap.get(inmapOne)
                     * secondMap.get(inmapTwo);
                }
            }
        }
        final int hundred = 100;
        for (String inmapOne : firstMap.keySet()) {
            firstSum += Math.pow(firstMap.get(inmapOne), 2);
        }
        for (String inmapTwo : secondMap.keySet()) {
            secondSum += Math.pow(secondMap.get(inmapTwo), 2);
        }
        denominator = Math.sqrt(firstSum) * Math.sqrt(secondSum);
        double output = (numerator / denominator) * hundred;
        return  (int) ((output * hundred) / hundred);
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * constructor fro solution class.
     */
    protected Solution() {

    }
    /**
     * main method for solution class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
        Document d = new Document();
        String path;
        Scanner scan = new Scanner(System.in);
        path = scan.nextLine();
        File folder = new File(path);
        File[] list = folder.listFiles();
        int length = list.length;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = Document.compare(
                Document.DocumentToString(list[i]),
                 Document.DocumentToString(list[j]));
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < list.length - 1; i++) {
            System.out.print("\t" + list[i].getName());
        }
        System.out.println("\t" + list[length - 1].getName());
        for (int i = 0; i < length; i++) {
            System.out.print(list[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
    System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    } catch (NoSuchElementException e) {
        System.out.println("empty directory");
    }
    }
}