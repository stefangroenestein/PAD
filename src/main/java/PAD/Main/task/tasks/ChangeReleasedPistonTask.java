/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task.tasks;

import PAD.main.debug.Debugger;
import PAD.game.GameHandler;
import PAD.interfaceKit.component.LinkedComponent;
import PAD.main.task.Task;

/**
 * Changes the ingame registerd released piston
 *
 * @author Youri Dudock
 */
public class ChangeReleasedPistonTask extends Task {
    
    private LinkedComponent linkedComponent; // the linked component which should become the new release piston

    public ChangeReleasedPistonTask(LinkedComponent linkedComponent, int executeTimer) {     
        super(executeTimer);
        
        this.linkedComponent = linkedComponent;
    }
    
    
    @Override
    public void onExecute() {
        Debugger.write("Changing the released piston to ("+linkedComponent.name()+")");
        
        GameHandler.getGame().setReleasedPiston(linkedComponent); // sets the new released piston
    }
    
    @Override
    public boolean isOneTimeExecution() {
        return true;
    }
    
    
}
