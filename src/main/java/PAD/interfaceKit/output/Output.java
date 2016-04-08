/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.output;

import PAD.interfaceKit.KitController;

/**
 *
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public enum Output {
    MAGNET1(0),
    MAGNET2(1),
    MAGNET3(2),
    MAGNET4(3),
    MAGNET5(4);
    

    private int outputId;
    

    private Output(int outputId) {
        this.outputId = outputId;
    }

    public int getId() {
        return outputId;
    }
}