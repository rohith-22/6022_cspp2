import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment.
  */
class Todoist {
  /**
   * variable tasklist.
   */
  private ArrayList<Task> taskList;
  /**
   * Constructs the object.
   */
  Todoist() {
    /**
     * empty constructor.
     */
    taskList = new ArrayList<>();
  }
  /**
   * Adds a task.
   *
   * @param      todoTask  The todo task
   */
  public void addTask(final Task todoTask) {
    taskList.add(todoTask);
  }
  /**
   * Gets the next task.
   *
   * @param      name  The name
   *
   * @return     The next task.
   */
  public Task getNextTask(final String name) {
    for (Task each : taskList) {
      if (name.equals(each.getAssignedTo())
          && each.getImportant().equals("Important")
          && each.getUrgent().equals("Not Urgent")
          && each.getStatus().equals("todo")) {
        return each;
      }
    }
    return null;
  }
  /**
   * Gets the next task.
   *
   * @param      name   The name
   * @param      value  The value
   *
   * @return     The next task.
   */
  public Task[] getNextTask(final String name, final int value) {
    Task[] taskArray = new Task[value];
    int i = 0;
    for (Task each : taskList) {
      if (name.equals(each.getAssignedTo())
          && each.getImportant().equals("Important")
          && each.getUrgent().equals("Not Urgent")
          && each.getStatus().equals("todo")
          && i < value) {
        taskArray[i++] = each;
      }
    }
    return taskArray;
  }
  /**
   * gives total time.
   *
   * @return    returns int
   */
  public int totalTime4Completion() {
    int time = 0;
    for (Task each : taskList) {
      if (each.getStatus().equals("todo")) {
        time += each.getTimeTOComplete();
      }
    }
    return time;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    String temp = "";
    for (Task each : taskList) {
      temp += each + "\n";
    }
    return temp;
  }
}
/**
 * Class for task.
 */
class Task {
  /**
   * variable title.
   */
  private String titleOfTask;
  /**
   * variable name of person.
   */
  private String taskAssignedTo;
  /**
   * variable time.
   */
  private int timeToCompleteTask;
  /**
   * variable important task.
   */
  private boolean importantTask;
  /**
   * variable is urgent or not.
   */
  private boolean urgentTask;
  /**
   * variable taskStatus.
   */
  private String taskStatus;
  /**
   * Constructs the object.
   */
  Task() {

  }
  /**
   * Constructs the object.
   *
   * @param      title           The title
   * @param      assignedTo      The assigned to
   * @param      timeToComplete  The time to complete
   * @param      important       The important
   * @param      urgent          The urgent
   * @param      status          The status
   * @throws     Exception       the exception
   */
  Task(final String title, final String assignedTo,
       final int timeToComplete, final boolean important,
       final boolean urgent, final String status) throws Exception {

    this.titleOfTask = title;
    this.taskAssignedTo = assignedTo;
    this.timeToCompleteTask = timeToComplete;
    this.importantTask = important;
    this.urgentTask = urgent;
    this.taskStatus = status;
    if (timeToCompleteTask <= 0) {
      throw new Exception("Invalid timeToComplete "
                          + timeToCompleteTask);
    }
    if (!((status.equals("todo")) || (status.equals("done")))) {
      throw new Exception("Invalid status " + status);
    }
    if (title.equals("")) {
      throw new Exception("Title not provided");
    }

  }
  /**
   * Gets the title.
   *
   * @return     The title.
   */
  public String getTitle() {
    return this.titleOfTask;
  }
  /**
   * Gets the assigned to.
   *
   * @return     The assigned to.
   */
  public String getAssignedTo() {
    return this.taskAssignedTo;
  }
  /**
   * Gets the time to complete.
   *
   * @return     The time to complete.
   */
  public int getTimeTOComplete() {
    return this.timeToCompleteTask;
  }
  /**
   * Gets the important.
   *
   * @return     The important.
   */
  public String getImportant() {
    if (this.importantTask) {
      return "Important";
    }
    return "Not Important";
  }
  /**
   * Gets the urgent.
   *
   * @return     The urgent.
   */
  public String getUrgent() {
    if (this.urgentTask) {
      return "Urgent";
    }
    return "Not Urgent";
  }
  /**
   * Gets the status.
   *
   * @return     The status.
   */
  public String getStatus() {
    return this.taskStatus;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return this.titleOfTask + ", " + this.taskAssignedTo
           + ", " + this.timeToCompleteTask + ", " + getImportant()
           + ", " + getUrgent() + ", " + this.taskStatus;
  }
}

/**
 * Class for todoist main.
 */
public class TodoistMain {
  /**
   * Constructs the object.
   */
  private TodoistMain() {

  }
  /**
   * Starts a test.
   */
  public static void startTest() {
    Todoist todo = new Todoist();
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      String[] tokens = s.nextLine().split(",");
      switch (tokens[0]) {
      case "task":
        testTask(tokens);
        break;
      case "add-task":
        testAddTask(todo, tokens);
        break;
      case "print-todoist":
        System.out.println(todo);
        break;
      case "get-next":
        System.out.println(todo.getNextTask(tokens[1]));
        break;
      case "get-next-n":
        int n = Integer.parseInt(tokens[2]);
        Task[] tasks = todo.getNextTask(tokens[1], n);
        System.out.println(Arrays.deepToString(tasks));
        break;
      case "total-time":
        System.out.println(todo.totalTime4Completion());
        break;
      default:
        break;
      }
    }
  }

  /**
   * method to test add task.
   *
   * @param      todo    The todo
   * @param      tokens  The tokens
   */
  public static void testAddTask(final Todoist todo,
                                 final String[] tokens) {
    try {
      todo.addTask(createTask(tokens));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * method to test the creation of task object.
   *
   * @param      tokens  The tokens
   */
  public static void testTask(final String[] tokens) {
    try {
      System.out.println(createTask(tokens));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Creates a task object.
   *
   * @param      tokens     The tokens
   *
   * @return     Task object
   *
   * @throws     Exception  if task inputs are invalid
   */
  public static Task createTask(final String[] tokens) throws Exception {
    final int two = 2, three = 3, four = 4, five = 5, six = 6;
    String title = tokens[1];
    String assignedTo = tokens[two];
    int timeToComplete = Integer.parseInt(tokens[three]);
    boolean important = tokens[four].equals("y");
    boolean urgent = tokens[five].equals("y");
    String status = tokens[six];
    return new Task(
             title, assignedTo, timeToComplete,
             important, urgent, status);
  }

  /**
   * main method.
   *
   * @param      args  The command line arguments
   */
  public static void main(final String[] args) {
    startTest();
  }
}
