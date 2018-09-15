import java.util.Scanner;
import java.util.Arrays;
class Quiz {
	private String questions;
	private String[] answers;
	private int correctChoice;
	private int scoreAwarded;
	private int penalityFined;
	Quiz() {

	}
	Quiz(String qsn, String ans, int choice, int score, int penality) {
		this.questions = qsn;
		this.answers = ans.split(",");
		this.correctChoice = choice;
		this.scoreAwarded = score;
		this.penalityFined = penality;
	}
	Quiz(String[] ans) {
		this.answers = ans;
	}
	String getQusetion() {
		return this.questions;
	}
	String getAnswers(int i) {
		String[] tokens = this.answers[i].split(" ");
		return tokens[1];
	}
	int getCorrectChoice() {
		return this.correctChoice;
	}
	int getScoreOfQuestion() {
		return this.scoreAwarded;
	}
	int getPenality() {
		return this.penalityFined;
	}
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	* Constructs the object.
	*/
	private Solution() {
		// leave this blank
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz q = new Quiz();
		QuizOperations quizOprtns = new QuizOperations();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":

				System.out.println("\n" + "|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				quizOprtns.loadQuestions(s, q, Integer.parseInt(tokens[1]));
				break;
			case "START_QUIZ":
				System.out.println("\n" + "|------------|");
				System.out.println("| Start Quiz |");
				System.out.println("|------------|");
				quizOprtns.startQuiz(s, q, Integer.parseInt(tokens[1]));
				break;
			case "SCORE_REPORT":
				System.out.println("\n" + "|--------------|");
				System.out.println("| Score Report |");
				System.out.println("|--------------|");
				quizOprtns.displayScore(q);
				break;
			default:
				break;
			}
		}
	}
}
/**
 * Loads questions.
 *
 * @param      s              The scanner object for user input
 * @param      quiz           The quiz object
 * @param      questionCount  The question count
 */
class QuizOperations {
	List<Quiz> listObject;
	String[] choices;
	QuizOperations() {

	}

	public void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		listObject = new List<Quiz>();
		String[] array = new String[questionCount];
		for (int i = 0; i < questionCount; i++ ) {
			String input = s.nextLine();
			array = input.split(":");
			listObject.add(new Quiz(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4])));
		}
		System.out.println(questionCount + " are added to the quiz");
	}

	/**
	 * Starts a quiz.
	 *
	 * @param      s            The scanner object for user input
	 * @param      quiz         The quiz object
	 * @param      answerCount  The answer count
	 */
	public void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		choices = new String[answerCount];
		for (int i = 0; i < answerCount; i++) {
			String input = s.nextLine();
			String[] arrayTemp = input.split(" ");
			choices[i] = arrayTemp[1];
		}
		Quiz answers = new Quiz (choices);
		for (int i = 0; i < answerCount; i++) {
			System.out.println("question text " + (i + 1) + "(" + listObject.get(i).getAnswers(i) + ")");
			System.out.println("choice 1" + "    choice 2" + "	choice 3" + "	choice 4");
		}

	}

	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public void displayScore(final Quiz quiz) {
		// write your code here to display the score report
		int temp = 0;
		for (int i = 0; i < listObject.size(); i++) {
			if (listObject.get(i).getCorrectChoice() == Integer.parseInt(choices[i])) {
				System.out.println("question text " + (i + 1));
				System.out.println("Correct Answer! - Marks Awarded: " + listObject.get(i).getScoreOfQuestion());
				temp += listObject.get(i).getScoreOfQuestion();
			} else {
				System.out.println("question text " + (i + 1));
				System.out.println("Wrong Answer! - Penalty: " + listObject.get(i).getPenality());
			}
		}
		System.out.println("Total Score: " + temp);
	}
}
