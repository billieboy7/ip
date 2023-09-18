package command;

import task.TaskList;
import main.UI;
import main.Storage;

import exception.DukeException;

/**
 * Mark Command is a subclass of Command.
 * Used to execute Mark Commands.
 */
public class MarkCommand extends Command {

    private int index;

    /**
     * Constructor for MarkCommand
     * @param index index of task to be marked
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * method to execute the mark sequence
     *
     * @param taskList object containing the ArrayList of tasks
     * @param ui       user interface responsible for terminal messages
     * @param storage  object to communicate with data.txt file
     * @return
     * @throws DukeException organic exception for Duke
     */
    @Override
    public String execute(TaskList taskList, UI ui, Storage storage) throws DukeException {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(taskList.mark(this.index));
            storage.saveList(taskList);
        } catch (RuntimeException e) {
            throw new DukeException(String.format("Given index is out of range. Index range should be between" +
                            " 1 and %d.",
                    taskList.getSize()));
        }
        return String.valueOf(sb);
    }
}
