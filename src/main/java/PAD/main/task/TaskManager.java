/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task;

import java.util.ArrayList;

/**
 * A manager for tasks that run on the main thread we can delay actions here
 *
 * @author Youri Dudock
 */
public class TaskManager {

    private static ArrayList<Task> tasks = new ArrayList(); // a list with active tasks

    /**
     * Starts one or more new tasks
     *
     * @param tasks A list with tasks
     */
    public static void start(Task... tasks) {
        for (Task task : tasks) {
            TaskManager.tasks.add(task);
        }
    }

    /**
     * Executes every loop and deals with executing tasks
     */
    public static void process() {
        ArrayList<Task> tasksLeft = new ArrayList(); // list that will be filled with tasks that are still waiting

        for (Task task : tasks) { // loops trough all the tasks

            if (task.hasAborted()) { // skip the task if the task should stop
                continue;
            }

            task.decreaseTicks();

            if (task.shouldExecute()) { // if the task should execute
                task.onExecute();

                if (!task.isOneTimeExecution()) { // if the task should continue
                    task.resetTicks();

                    tasksLeft.add(task); // add task back to the list with tasks that should continue
                }

            } else {
                tasksLeft.add(task);
            }
        }

        tasks = tasksLeft; // replaces the active task list
    }

}
