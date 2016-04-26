/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task;

/**
 *
 * @author Youri Dudock
 */
public abstract class Task {
    
    private int ticks; // after how many ticks the this task should execute
    
    public Task(int ticks) {
        ticks = ticks;
    }
    
    public void decreaseTicks() {
        ticks--;
    }
    
    /**
     * Checks if this task should be executed
     * 
     * @return if should execute
     */
    public boolean shouldExecute() {
        return ticks <= 0;
    }
    
    public abstract void onExecute();
    
}
