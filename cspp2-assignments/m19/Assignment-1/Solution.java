import java.util.Scanner;
// import java.util.Arrays;
/**
 * Class for quiz.
 */
class Quiz {
  /**
   * variable questions.
   */
  private String questions;
  /**
   * variable answerrs.
   */
  private String[] answers;
  /**
   * variable correct Choice.
   */
  private String correctChoice;
  /**
   * { var_description }.
   */
  private int scoreAwarded;
  /**
   * { var_description }.
   */
  private int penalityFined;
  /**
   * Constructs the object.
   */
  Quiz() {
    /**
     * { item_description }.
     */
  }
  /**
   * Constructs the object.
   *
   * @param      qsn       The qsn
   * @param      ans       The ans
   * @param      choice    The choice
   * @param      score     The score
   * @param      penality  The penality
   */
  Quiz(final String qsn, final String ans,
       final String choice, final int score, final int penality) {
    this.questions = qsn;
    this.answers = ans.split(",");
    this.correctChoice = choice;
    this.scoreAwarded = score;
    this.penalityFined = penality;
  }
  /**
   * Constructs the object.
   *
   * @param      ans   The ans
   */
  Quiz(final String[] ans) {
    this.answers = ans;
  }
  /**
   * Gets the qusetion.
   *
   * @return     The qusetion.
   */
  String getQusetion() {
    return this.questions;
  }
  /**
   * Gets the answers.
   *
   * @param      i     int.
   *
   * @return     The answers.
   */
  String getAnswers(final int i) {
    String[] tokens = this.answers[i].split(" ");
    return tokens[1];
  }
  /**
   * Gets the choices.
   *
   * @param      i     int
   *
   * @return     The choices.
   */
  String getChoices(final int i) {
    return answers[i];
  }
  /**
   * Gets the correct choice.
   *
   * @return     The correct choice.
   */
  String getCorrectChoice() {
    return this.correctChoice;
  }
  /**
   * Gets the score of question.
   *
   * @return     The score of question.
   */
  int getScoreOfQuestion() {
    return this.scoreAwarded;
  }
  /**
   * Gets the penality.
   *
   * @return     The penality.
   */
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

        System.out.println("|----------------|");
        System.out.println("| Load Questions |");
        System.out.println("|----------------|");
        quizOprtns.loadQuestions(s, q, Integer.parseInt(tokens[1]));
        break;
      case "START_QUIZ":
        System.out.println("|------------|");
        System.out.println("| Start Quiz |");
        System.out.println("|------------|");
        quizOprtns.startQuiz(s, q, Integer.parseInt(tokens[1]));
        break;
      case "SCORE_REPORT":
        System.out.println("|--------------|");
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
 * Class for quiz operations.
 */
class QuizOperations {
  /**
   * { var_description }.
   */
  private List<Quiz> listObject;
  /**
   * { var_description }.
   */
  private String[] choices;
  /**
   * Constructs the object.
   */
  QuizOperations() {
    /**
     * { item_description }.
     */
  }
  /**
   * Loads questions.
   *
   * @param      s              The scanner object for user input
   * @param      quiz           The quiz object
   * @param      questionCount  The question count
   */
  public void loadQuestions(final Scanner s,
                            final Quiz quiz, final int questionCount) {
    // write your code here to read the questions from the console
    // tokenize the question line and create the question object
    // add the question objects to the quiz class
    if (questionCount == 0) {
      System.out.println("Quiz does not have questions");
      return;
    } else {
      listObject = new List<Quiz>();
      String[] array = new String[questionCount];
      for (int i = 0; i < questionCount; i++) {
        String input = s.nextLine();
        array = input.split(":");
        final int three = 3;
        final int four = 4;
        final int five = 5;
        if (array.length < five || array[0].equals("")) {
          System.out.println("Error! Malformed question");
          return;
        }
        if (array[1].split(",").length < 2) {
          System.out.println(array[0] + " does not have enough answer choices");
          return;
        }
        if (Integer.parseInt(array[2]) > four) {
          System.out.println("Error! Correct answer choice number "
                             + "is out of range for " + array[0]);
          return;
        }
        if (Integer.parseInt(array[three]) < 0) {
          System.out.println("Invalid max marks for " + array[0]);
          return;
        }
        if (Integer.parseInt(array[four]) > 0 ) {
          System.out.println("Invalid penalty for " + array[0]);
          return;
        }
        if (array.length == 2) {

        }

        listObject.add(new Quiz(array[0], array[1], array[2],
                                Integer.parseInt(array[three]),
                                Integer.parseInt(array[four])));
      }
      System.out.println(questionCount + " are added to the quiz");
    }
  }
  /**
   * Starts a quiz.
   *
   * @param      s            The scanner object for user input
   * @param      quiz         The quiz object
   * @param      answerCount  The answer count
   */
  public void startQuiz(final Scanner s,
                        final Quiz quiz, final int answerCount) {
    // write your code here to display the quiz questions
    // read the user responses from the console
    // store the user respones in the quiz object
    if (listObject.size() > 0) {

      choices = new String[answerCount];
      for (int i = 0; i < answerCount; i++) {
        String input = s.nextLine();
        String[] arrayTemp = input.split(" ");
        choices[i] = arrayTemp[1];
        if (choices[i].equals("a")) {
          choices[i] = "1";
        }
        if (choices[i].equals("b")) {
          choices[i] = "2";
        }
        if (choices[i].equals("c")) {
          choices[i] = "3";
        }
        if (choices[i].equals("d")) {
          choices[i] = "4";
        }
      }
      Quiz answers = new Quiz(choices);
      int k = 1;
      for (int i = 0; i < answerCount; i++) {
        final int five = 5;
        if (k == five) {
          k = 1;
        }
        final int three = 3;
        System.out.println(listObject.get(i).getQusetion() + "(" + k + ")");

        System.out.println(listObject.get(i).getChoices(0)
                           + "\t" + listObject.get(i).getChoices(1) + "\t"
                           + listObject.get(i).getChoices(2) + "\t"
                           + listObject.get(i).getChoices(three) + "\n");
        k++;
      }

    }
  }

  /**
   * Displays the score report.
   *
   * @param      quiz     The quiz object
   */
  public void displayScore(final Quiz quiz) {
    // write your code here to display the score report
    if (listObject.size()  == 0) {
      return;
    }
    int temp = 0;
    for (int i = 0; i < listObject.size(); i++) {
      // System.out.println(listObject.get(i).getCorrectChoice());
      // System.out.println(choices[i]);
      if (listObject.get(i).getCorrectChoice()
          .equals(choices[i])) {
        System.out.println(listObject.get(i).getQusetion());
        System.out.println(" Correct Answer! - Marks Awarded: "
                           + listObject.get(i).getScoreOfQuestion());
        temp += listObject.get(i).getScoreOfQuestion();
      } else {
        System.out.println(listObject.get(i).getQusetion());
        System.out.println(" Wrong Answer! - Penalty: "
                           + listObject.get(i).getPenality());
        temp += listObject.get(i).getPenality();
      }
    }
    System.out.println("Total Score: " + temp);
  }
}

