/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task.tasks;

import PAD.Main.debug.Debugger;
import PAD.game.GameHandler;
import PAD.interfaceKit.component.Component;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.main.task.Task;

/**
 *
 * @author Youri Dudock
 */
public class ChangeMagnetStateTask extends Task {
    
    private boolean state;
    
    private Component magnet;

    public ChangeMagnetStateTask(Component magnet, boolean state, int executeTimer) {     
        super(executeTimer);
        
        this.magnet = magnet;
        this.state = state;
    }
    
    
    @Override
    public void onExecute() {
        Debugger.write("Changing the magnet state ("+magnet.name()+") to "+state);
        ComponentHandler.setState(magnet, state);
    }
    
}
