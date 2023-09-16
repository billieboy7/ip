package main;

import command.Command;

import task.TaskList;

import exception.DukeException;

import java.io.IOException;
import java.util.Scanner;

/**
 * Duke class - Main class
 */
public class Duke {
    Scanner userInput = new Scanner(System.in);
    TaskList tasks = new TaskList();
    Storage storage;
    UI ui;

    public static void main(String[] args) {

        Duke duke = new Duke("./data/data.txt");
        duke.start();

    }

    /**
     * Constructor for Duke class
     * @param filePath file path from which past saved date, if available, should be read from
     */
    public Duke(String filePath) {
        this.storage = new Storage(filePath, tasks);
        this.ui = new UI();

        this.ui.printWelcomeMessage();

        try {
            this.storage.loadList();
        } catch (DukeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to start the Duke program
     */
    private void start() {

        boolean isContinue = true;
        while (isContinue) {
            try {
                String input = userInput.nextLine();
                Command command = Parser.parse(input);
                command.execute(this.tasks, this.ui, this.storage);
                isContinue = command.isContinue();
                if (isContinue) {
                    System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
                    this.ui.printDivider();
                }
            } catch (DukeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    // public String getResponse(String input) {
    //     try {
    //         Command command = Parser.parse(input);
    //         return command.execute(UI);
    //     } catch (DukeException e) {
    //         return e.getMessage();
    //     }
    // }
}

