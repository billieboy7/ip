package Command;

import Task.TaskList;
import Main.UI;
import Main.Storage;

import Exception.DukeException;

public class MarkCommand extends Command {

    int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, UI ui, Storage storage) throws DukeException {
        try {
            taskList.mark(this.index);
            storage.saveList(taskList);
        } catch (RuntimeException e) {
            throw new DukeException(String.format("Given index is out of range. Index range should be between" +
                            " 1 and %d.",
                    taskList.size()));
        }
    }
}