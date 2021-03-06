/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task.tasks;

import PAD.main.debug.Debugger;
import PAD.game.GameHandler;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.main.task.Task;

/**
 * Changes the state of a magnet
 *
 * @author Youri Dudock
 */
public class ChangeMagnetStateTask extends Task {
    
    private boolean state; // the new state
    
    private Component magnet; // the magnet component

    public ChangeMagnetStateTask(Component magnet, boolean state, int executeTimer) {     
        super(executeTimer);
        
        this.magnet = magnet;
        this.state = state;
    }
    
    
    @Override
    public void onExecute() {
        ComponentHandler.setState(magnet, state); // sets the magnet is state
    }
    
    @Override
    public boolean isOneTimeExecution() {
        return true;
    }
    
    
}
