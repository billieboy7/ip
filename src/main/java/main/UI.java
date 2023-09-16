package main;

import task.Task;
import task.TaskList;

import java.util.ArrayList;

/**
 * UI class - User Interface - Handles the display shown by the program.
 */
public class UI {

    /**
     * Constructor for UI class.
     */
    public UI() {}

    /**
     * Generates the divider displayed in the terminal.
     */
    void printDivider() {
        String line = "____________________________________________________________";
        System.out.println(line);
    }

    /**
     * Generates the welcome message displayed in the terminal.
     */
    void printWelcomeMessage() {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);

        this.printDivider();
        System.out.println(" Hello! I'm JARVIS");
        System.out.println("What can I do for you?");
        this.printDivider();
    }

    /**
     * Lists out the tasks stored in the ArrayList<Task> Object.
     * @param taskArrayList - Contains the list of Tasks.
     */
    public void printList(ArrayList<Task> taskArrayList) {
        this.printDivider();
        if (taskArrayList.size() == 0) {
            System.out.println("There are no tasks in your list.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskArrayList.size(); i++) {
                int index = i + 1;
                Task t = taskArrayList.get(i);
                System.out.println(index + "." + t.toString());
            }
        }
        this.printDivider();
    }

    public void list(ArrayList<Task> taskArrayList, Boolean isMatchingList) {
        this.printDivider();
        if (taskArrayList.size() == 0) {
            System.out.println("There are no matching tasks in your list.");
        } else if (isMatchingList) {
            System.out.println("Here are the " + taskArrayList.size() + " matching tasks in your list:");
            for (int i = 0; i < taskArrayList.size(); i++) {
                int index = i + 1;
                Task t = taskArrayList.get(i);
                System.out.println(index + "." + t.toString());
            }
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskArrayList.size(); i++) {
                int index = i + 1;
                Task t = taskArrayList.get(i);
                System.out.println(index + "." + t.toString());
            }
        }
        this.printDivider();
    }

    /**
     * Generates the bye message displayed in the terminal.
     */
    public void printByeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
        this.printDivider();
    }

    public void showDelete(String input, TaskList taskList) {
        int taskIndex = Integer.parseInt(input.substring(7)) - 1;
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskList.getTaskArrayList().get(taskIndex));
    }

    public static void showAddTask(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
    }

    public static void showMarked(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task);
    }

    public static void showUnmarked(Task task) {
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task);
    }
}
