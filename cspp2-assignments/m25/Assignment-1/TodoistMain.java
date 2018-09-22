import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
  * write your code below this comment
  */
class Todoist {
	ArrayList<Task> taskList;
	private int i;
	Todoist() {
		taskList = new ArrayList<>();
		i = 0;
	}
	public void addTask(Task todoTask) {
		taskList.add(todoTask);
	}
	public Task getNextTask(String name) {
		for (Task each : taskList) {
			if (name.equals(each.getAssignedTo()) && each.getImportant().equals("Important")
			    && each.getUrgent().equals("Not Urgent") && each.getStatus().equals("todo")) {
				return each;
			}
		}
		return null;
	}
	public Task[] getNextTask(String name,  int value) {
		Task[] taskArray = new Task[value];
		int k = 0;
		for (i = 0; i < taskList.size(); i++) {
			if (name.equals(taskList.get(i).getAssignedTo()) && i < value) {
				taskArray[k++] = taskList.get(i);
				// count +=1;
			}
		}
		// if(k-1 != value-1 && k < value) {
		// 	taskArray[k++] = null;
		// }
		return taskArray;
	}
	public int totalTime4Completion() {
		int time = 0;
		for (Task each : taskList) {
			if (each.getStatus().equals("todo")) {
				time += each.getTimeTOComplete();
			}
		}
		return time;
	}
	public String toString() {
		String temp = "";
		for (Task each : taskList) {
			temp += each + "\n";
		}
		return temp;
	}
}
class Task {
	/**
	 * Constructs the object.
	 * empty constructor.
	 */
	private String titleOfTask;
	private String taskAssignedTo;
	private int timeToCompleteTask;
	private boolean importantTask;
	private boolean urgentTask;
	private String taskStatus;
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
	 */
	Task(final String title, final String assignedTo,
	     final int timeToComplete, final boolean important,
	     final boolean urgent, String status) throws Exception {

		this.titleOfTask = title;
		this.taskAssignedTo = assignedTo;
		this.timeToCompleteTask = timeToComplete;
		this.importantTask = important;
		this.urgentTask = urgent;
		this.taskStatus = status;
		// System.out.println(status);
		if (timeToCompleteTask <= 0) {
			throw new Exception("Invalid timeToComplete " + timeToCompleteTask);
		}
		if (!((status.equals("todo")) || (status.equals("done")))) {
			throw new Exception("Invalid status " + status);
		}
		if (title.equals("")) {
			throw new Exception("Title not provided");
		}

	}
	public String getTitle() {
		return this.titleOfTask;
	}
	public String getAssignedTo() {
		return this.taskAssignedTo;
	}
	public int getTimeTOComplete() {
		return this.timeToCompleteTask;
	}
	public String getImportant() {
		if (this.importantTask) {
			return "Important";
		}
		return "Not Important";
	}
	public String getUrgent() {
		if (this.urgentTask) {
			return "Urgent";
		}
		return "Not Urgent";
	}
	public String getStatus() {
		return this.taskStatus;
	}
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
	public static void testAddTask(final Todoist todo, final String[] tokens) {
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
		String title = tokens[1];
		String assignedTo = tokens[2];
		int timeToComplete = Integer.parseInt(tokens[3]);
		boolean important = tokens[4].equals("y");
		boolean urgent = tokens[5].equals("y");
		String status = tokens[6];
		return new Task(
		         title, assignedTo, timeToComplete, important, urgent, status);
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
