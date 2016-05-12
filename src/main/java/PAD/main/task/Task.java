/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task;

/**
 * A task is a running executable in the program that executes after a certain
 * amount of ticks
 *
 * @author Youri Dudock
 */
public abstract class Task {

    private int ticks; // amount of ticks till execution

    private int ticksLeft; // the ticks left before the exection should happen

    private boolean shouldStop = false;

    public Task(int ticks) {
        this.ticks = ticks;
        this.ticksLeft = ticks;
    }

    /**
     * decreases by a tick
     */
    public void decreaseTicks() {
        ticksLeft--;
    }

    /**
     * Checks if this task should be executed
     *
     * @return if should execute
     */
    public boolean shouldExecute() {
        return ticksLeft <= 0;
    }

    /**
     * Resets the ticks to the original state
     */
    public void resetTicks() {
        this.ticksLeft = ticks;
    }

    /**
     * Stops the task and prevents executing on the next tick
     */
    public void stop() {
        shouldStop = true;
    }

    /**
     *
     * @return if the task should stop
     */
    public boolean shouldStop() {
        return shouldStop;
    }

    /**
     * Tells us if the task should restart after executing or end
     *
     * @return
     */
    public abstract boolean isOneTimeExecution();

    /**
     * The action performed on the execution
     */
    public abstract void onExecute();

}
