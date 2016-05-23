/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output.LED;

import PAD.interfaceKit.component.Component;

/**
 *
 * @author Roosie
 */
public enum LedColor {
    
    RED(false,true,true),
    GREEN(true,false,true),
    BLUE(true,true,false),
    PURPLE(true, false, true),
    ORANGE(true, true, false);
    
    private boolean LedColorRed; // name of the file
    private boolean LedColorGreen; // name of the file
    private boolean LedColorBlue; // name of the file
    private boolean LedColorPurple; // name of the file
    private boolean LedColorOrange; // name of the file

    private LedColor(boolean LedColorRed, boolean LedColorGreen, boolean LedColorBlue) {
        this.LedColorRed = LedColorRed;
        this.LedColorGreen = LedColorGreen;
        this.LedColorBlue = LedColorBlue;
    }

    public boolean getColorRed() {
        return LedColorRed;
    }


    public boolean getColorGreen() {
        return LedColorGreen;
    }


    public boolean getColorBlue() {
        return LedColorBlue;
    }
    
}
