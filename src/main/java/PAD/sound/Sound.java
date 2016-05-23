/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.sound;

/**
 * Contains all the sounds that can be played in our game
 *
 * @author Youri Dudock
 */
public enum Sound {
    
    DOG("dog"),
    LION("lion"),
    KOALA("koala"),
    RHINO("rhino"),
    BEAR("bear"),
    PLING("pling");
    
    private String fileName; // name of the file
    
    private Sound(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 
     * @return the name of the file
     */
    public String getFileName() {
        return fileName;
    }
    
}
