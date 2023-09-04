package main;

import command.Command;

import task.TaskList;

import exception.DukeException;

import java.io.IOException;

import java.util.Scanner;

public class Duke {
    Scanner userInput = new Scanner(System.in);
    TaskList tasks = new TaskList();
    Storage storage;
    UI ui;

    public static void main(String[] args) {

        Duke duke = new Duke("./data/data.txt");
        duke.start();

    }

    private Duke(String filePath) {
        this.storage = new Storage(filePath, tasks);
        this.ui = new UI();

        this.ui.printWelcomeMessage();

        try {
            this.storage.loadList();
        } catch (DukeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void start() {

        boolean isContinue = true;
        while (isContinue) {
            try {
                String input = userInput.nextLine();
                Command command = Parser.parse(input);
                command.execute(this.tasks, this.ui, this.storage);
                isContinue = command.end();
                if (isContinue) {
                    System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
                    this.ui.printDivider();
                }
            } catch (DukeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
