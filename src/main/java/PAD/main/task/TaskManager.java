/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task;

import java.util.ArrayList;

/**
 * A manager for tasks that run on the main thread
 * we can delay actions here
 *
 * @author Youri Dudock
 */
public class TaskManager {
    
    private static ArrayList<Task> tasks = new ArrayList(); // a list with active tasks
    
    /**
     * Starts a new task
     * 
     * @param task 
     *            a task
     */
    public static void start(Task task) {
        tasks.add(task); // adds the task to the list
    }
    
    /**
     * Executes every loop and deals with executing tasks
     */
    public static void process() {
        ArrayList<Task> tasksLeft = new ArrayList(); // list that will be filled with tasks that are still waiting
        
        for (Task task : tasks) { // loops trough all the tasks
            
            task.decreaseTicks();
            
            if (task.shouldExecute()) { // if the task should execute
                task.onExecute();
            } else {
                tasksLeft.add(task);
            }
        }
        
        tasks = tasksLeft;
    }
    
}
