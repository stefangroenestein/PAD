/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.Main;

import PAD.Main.debug.Debugger;
import PAD.Main.task.tasks.TimerTask;
import PAD.main.task.Task;
import PAD.main.task.TaskManager;

/**
 * A timer that counts seconds using a task
 *
 * @author Youri
 */
public class Timer {
    
    private Task timerTask; // the task for this timer
    
    private int seconds = 0; // the current second count
    
    /**
     * Increases the second count by 1
     */
    public void increase() {
        seconds++; // increases the second count
        
        Debugger.write("Timer increased, currently at: " + seconds + " seconds.");
    }
    
    /**
     * Starts the timer 
     */
    public void start() {
        timerTask = new TimerTask(this, 3); // creates a new timer task
        
        TaskManager.start(timerTask); // starts the task
    }
    
    /**
     * Stops the timer
     */
    public void stop() {
        timerTask.stop();
    }
    
    /**
     * Resets the timer
     */
    public void reset() {
        seconds = 0;
    }
    
    /**
     * 
     * @return the seconds that have passed
     */
    public int getSeconds() {
        return seconds;
    }
    
}