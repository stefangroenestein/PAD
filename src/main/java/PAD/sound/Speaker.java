/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.sound;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import java.io.File;

/**
 * Controls our speaker in the box
 *
 * @author Youri Dudock
 */
public class Speaker {

    private static AudioInputStream stream; // the stream our audio file gets read into

    private static Clip clip; // the clip thats being played

    /**
     * Plays the sound trough the speakers
     *
     * @param sound the sound that should be played
     * @param override if the sound should override the current sound that is
     * being played
     */
    public static void play(Sound sound, boolean override) {
        try {

            if (clip != null && override) {
                clip.stop(); // stops playing the previous audio file
            }

            stream = AudioSystem.getAudioInputStream(new File(sound.getFileName() + ".wav")); // reads the audio file

            clip = AudioSystem.getClip(); // gets the audio clip from the stream

            clip.open(stream); // opens the clip
            clip.start(); // plays the clip

        } catch (LineUnavailableException ex) {
            Logger.getLogger(Speaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Speaker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Speaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Plays the sound trough the speakers, overrides the old clip per default
     *
     * @param sound the sound that should be played
     */
    public static void play(Sound sound) {
        play(sound, true);
    }

}
