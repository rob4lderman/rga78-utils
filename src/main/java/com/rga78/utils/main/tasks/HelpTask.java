package com.rga78.utils.main.tasks;

import com.rga78.utils.main.Task;
import com.rga78.utils.main.TaskIO;
import com.rga78.utils.main.TaskList;

public class HelpTask extends Task<HelpTask> {
    
    /**
     * List of registered tasks.
     */
    private final TaskList tasks;

    /**
     * CTOR.
     */
    public HelpTask(TaskList tasks) {
        this.tasks = tasks;
    }


    @Override
    public String getTaskName() {
        return "help";
    }

    @Override
    public String getTaskHelp() {
        StringBuilder sb = new StringBuilder();
        
        for (Task task : tasks) {
            if (task != this) {
                sb.append("\t" + task.getTaskHelp())
                .append("\n")
                .append(task.getTaskDescription())
                .append("\n");
            }
        }
        
        return sb.toString();
    }

    @Override
    public String getTaskDescription() {
        return "Print help and usage for tasks";
    }

    @Override
    public int handleTask(TaskIO taskIO, String[] args) throws Exception {
        System.out.println( getTaskHelp() );
        return 0;
    }

}
