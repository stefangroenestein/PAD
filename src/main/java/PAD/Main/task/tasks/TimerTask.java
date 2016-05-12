/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.Main.task.tasks;

import PAD.Main.Timer;
import PAD.main.task.Task;

/**
 * A task for timers to count up
 *
 * @author Youri
 */
public class TimerTask extends Task {
    
    private Timer timer; // instance of a timer that belongs with this task
    
    public TimerTask(Timer timer, int executeTimer) {
        super(executeTimer);
        
        this.timer = timer;
    }

    @Override
    public boolean isOneTimeExecution() {
        return false;
    }

    @Override
    public void onExecute() {
        timer.increase(); // increases the timer
    }
    
}
