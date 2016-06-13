/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.interfaceKit.io.output.LED;

/**
 * Contains configs for led colors
 * creates different colors by mixing booleans
 *
 * @author Bobbie
 */
public enum LedColor {
    
    RED(false,true,true),
    GREEN(true,false,true),
    BLUE(true,true,false),
    PURPLE(false, true, false),
    YELLOW(false, false, true),
    CYAN(true, false, false);
    
    private boolean ledColorRed; // the red color
    private boolean ledColorGreen; // the green color
    private boolean ledColorBlue; // the blue color

    private LedColor(boolean LedColorRed, boolean LedColorGreen, boolean LedColorBlue) {
        this.ledColorRed = LedColorRed;
        this.ledColorGreen = LedColorGreen;
        this.ledColorBlue = LedColorBlue;
    }

    /**
     * 
     * @return the red color
     */
    public boolean getColorRed() {
        return ledColorRed;
    }

    /**
     * 
     * @return the green color
     */
    public boolean getColorGreen() {
        return ledColorGreen;
    }

    /**
     * 
     * @return the blue color
     */
    public boolean getColorBlue() {
        return ledColorBlue;
    }
    
}
