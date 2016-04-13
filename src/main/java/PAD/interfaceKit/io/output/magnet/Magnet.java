/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output.magnet;

import PAD.interfaceKit.KitController;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public enum Magnet {
    ONE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4);
    

    private int outputId;
    

    private Magnet(int outputId) {
        this.outputId = outputId;
    }

    public int getId() {
        return outputId;
    }
}