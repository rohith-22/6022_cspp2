import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for question.
 */
class Question {
  /**
   * { var_description }.
   */
  private String questiontext;
  /**
   * { var_description }.
   */
  private String[] choices;
  /**
   * { var_description }.
   */
  private int correctAnswer;
  /**
   * { var_description }.
   */
  private int maxMarks;
  /**
   * { var_description }.
   */
  private int penalty;
  /**
   * { var_description }.
   */
  private String response;
  /**
   * Constructs the object.
   */
  private int k = 1;
  Question() {

  }
  /**
   * Constructs the object.
   *
   * @param      question1       The question 1
   * @param      choices1        The choices 1
   * @param      correctAnswer1  The correct answer 1
   * @param      maxMarks1       The maximum marks 1
   * @param      penalty1        The penalty 1
   */
  Question(final String question1, final String[] choices1,
           final int correctAnswer1, final int maxMarks1, final int penalty1) {
    questiontext = question1;
    choices = choices1;
    correctAnswer = correctAnswer1;
    maxMarks = maxMarks1;
    penalty = penalty1;
  }
  /**
   * { function_description }.
   *
   * @param      choice  The choice
   *
   * @return     { description_of_the_return_value }
   */
  public boolean evaluateResponse(final String choice) {
    if (choices[correctAnswer - 1].equals(choice)) {
      return true;
    }
    return false;
  }
  /**
   * Gets the correct answer.
   *
   * @return     The correct answer.
   */
  public int getCorrectAnswer() {
    return correctAnswer;
  }
  /**
   * Gets the question text.
   *
   * @return     The question text.
   */
  public String getQuestionText() {
    return questiontext;
  }
  /**
   * Gets the choice.
   *
   * @return     The choice.
   */
  public String[] getChoice() {
    return choices;
  }
  /**
   * Gets the maximum marks.
   *
   * @return     The maximum marks.
   */
  public int getMaxMarks() {
    return maxMarks;
  }
  /**
   * Gets the penalty.
   *
   * @return     The penalty.
   */
  public int getPenalty() {
    return penalty;
  }
  /**
   * Sets the response.
   *
   * @param      answer  The answer
   */
  public void setResponse(final String answer) {
    response = answer;
  }
  /**
   * Gets the response.
   *
   * @return     The response.
   */
  public String getResponse() {
    return response;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return questiontext + "(" + maxMarks + ")" + "\n" + Arrays.
           toString(choices).replace("[", "").replace(", ", "\t").replace("]", "") + "\n";
  }
}
/**
 * Class for quiz.
 */
class Quiz {
  /**
   * { var_description }.
   */
  private final int onehundred = 100;
  /**
   * { var_description }.
   */
  private Question[] questions;
  /**
   * { var_description }.
   */
  private int size;
  /**
   * Constructs the object.
   */
  Quiz() {
    questions = new Question[100];
    size = 0;
  }
  /**
   * Adds a question.
   *
   * @param      q     The question
   */
  public void addQuestion(final Question q) {
    questions[size++] = q;
  }
  /**
   * Gets the question.
   *
   * @param      index  The index
   *
   * @return     The question.
   */
  public Question getQuestion(final int index) {
    return questions[index];
  }
  /**
   * Shows the report.
   *
   * @return     { description_of_the_return_value }
   */
  public int getSize() {
    return size;
  }
  public String showReport() {
    String s = "" ;
    return s;
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
    Question obj = new Question();
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
        System.out.println("|----------------|");
        System.out.println("| Load Questions |");
        System.out.println("|----------------|");
        try {
          loadQuestions(s, q, Integer.parseInt(tokens[1]));
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        break;
      case "START_QUIZ":
        System.out.println("|------------|");
        System.out.println("| Start Quiz |");
        System.out.println("|------------|");
        startQuiz(s, q, Integer.parseInt(tokens[1]));
        break;
      case "SCORE_REPORT":
        System.out.println("|--------------|");
        System.out.println("| Score Report |");
        System.out.println("|--------------|");
        displayScore(q);
        break;
      default:
        break;
      }
    }
  }
  /**
   * Loads questions.
   *
   * @param      scan       The scan
   * @param      quiz       The quiz
   * @param      q          The question count
   *
   */
  public static void loadQuestions(final Scanner scan,
                                   final Quiz quiz, final int q) throws Exception {
    // write your code here to read the questions from the console
    // tokenize the question line and create the question object
    // add the question objects to the quiz class.
    if (q == 0) {
      throw new Exception("Quiz does not have questions");
    } else {
      for (int i = 0; i < q; i++) {
        String[] inputQuiz = scan.nextLine().split(":");
        if (inputQuiz.length < 5 || inputQuiz[0].length() <= 0 || inputQuiz[1].length() <= 0 ||
            inputQuiz[2].length() <= 0 || inputQuiz[3].length() <= 0 || inputQuiz[4].length() <= 0) {
          throw new Exception("Error! Malformed question");
        }
        if (inputQuiz[1].split(",").length < 2) {
          throw new Exception(inputQuiz[0] + " does not have enough answer choices");
        }
        if (Integer.parseInt(inputQuiz[2]) < 0 || Integer.parseInt(inputQuiz[2]) > inputQuiz[1].split(",").length) {

          throw new Exception("Error! Correct answer choice number is out of range for " + inputQuiz[0]);
        }
        if (Integer.parseInt(inputQuiz[3]) <= 0) {
          throw new Exception("Invalid max marks for " + inputQuiz[0]);
        }
        if (Integer.parseInt(inputQuiz[4]) > 0) {
          throw new Exception("Invalid penalty for " + inputQuiz[0]);
        }
        quiz.addQuestion(new Question(inputQuiz[0], inputQuiz[1].split(","),
                                      Integer.parseInt(inputQuiz[2]),
                                      Integer.parseInt(inputQuiz[3]),
                                      Integer.parseInt(inputQuiz[4])));
      }
      System.out.println(q + " are added to the quiz");
    }
  }
  /**
   * Starts a quiz.
   *
   * @param      scan  The scan
   * @param      quiz  The quiz
   * @param      q     The answer count
   */
  public static void startQuiz(final Scanner scan,
                               final Quiz quiz, final int q) {
    // write your code here to display the quiz questions on the console.
    // read the user responses from the console using scanner object.
    // store the user respone in the question object
    if (quiz.getSize() == 0) {
      return;
    }
    for (int i = 0; i < q; i++) {
      System.out.println(quiz.getQuestion(i));
      quiz.getQuestion(i).setResponse(scan.nextLine());
    }
  }
  /**
   * Displays the score report.
   *
   * @param      quiz     The quiz object
   */
  public static void displayScore(final Quiz quiz) {
    // write your code here to display the score report using quiz object.
    if (quiz.getSize() == 0) {
      return;
    }
    int score = 0;
    for (int i = 0; i < quiz.getSize(); i++) {
      System.out.println(quiz.getQuestion(i).getQuestionText());
      if (quiz.getQuestion(i).evaluateResponse(quiz.getQuestion(i).getResponse())) {
        // System.out.println("entered");
        score += quiz.getQuestion(i).getMaxMarks();
        System.out.println(" Correct Answer! - Marks Awarded: " + quiz.getQuestion(i).getMaxMarks());
      } else {
        score += quiz.getQuestion(i).getPenalty();
        System.out.println(" Wrong Answer! - Penalty: " + quiz.getQuestion(i).getPenalty());
      }
    }
    System.out.println("Total Score: " + score);
  }
}
