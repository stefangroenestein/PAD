/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.Main.task.tasks;

import PAD.Main.debug.Debugger;
import PAD.game.GameHandler;
import PAD.interfaceKit.component.ComponentHandler;
import PAD.interfaceKit.component.LinkedComponent;
import PAD.main.task.Task;

/**
 *
 * @author Youri
 */
public class ChangeReleasedPistonTask extends Task {
    
    private LinkedComponent linkedComponent;

    public ChangeReleasedPistonTask(LinkedComponent linkedComponent, int executeTimer) {     
        super(executeTimer);
        
        this.linkedComponent = linkedComponent;
    }
    
    
    @Override
    public void onExecute() {
        Debugger.write("Changing the released piston to ("+linkedComponent.name()+")");
        GameHandler.getGame().setReleasedPiston(linkedComponent); 
    }
    
    @Override
    public boolean isOneTimeExecution() {
        return true;
    }
    
    
}
