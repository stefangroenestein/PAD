/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.button;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public enum Button {
    GREEN(0),
    WHITE(1);

    private int buttonId;
    

    private Button(int buttonId) {
        this.buttonId = buttonId;
    }

    public int getId() {
        return buttonId;
    }
}
