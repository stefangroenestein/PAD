/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main.task.tasks;

import PAD.game.mechanic.PistonMechanic;
import PAD.main.task.Task;

/**
 *
 * @author Youri Dudock
 */
public class CancelBlockedStateTask extends Task {
    
    public CancelBlockedStateTask() {
        super(2);
    }

    @Override
    public void onExecute() {
        PistonMechanic.setReleaseBlocked(false);
    }
    
}
