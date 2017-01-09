/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author SaiKrishna
 */
package Wingame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class SoundPlayer {
    public Clip getSound(String location) {
        
        Clip sound = null;
        try {
            AudioInputStream Input = AudioSystem.getAudioInputStream((getClass().getResource(location)));
            sound = AudioSystem.getClip();
            sound.open(Input);
            sound.loop(Clip.LOOP_CONTINUOUSLY);
        
        }catch (Exception e) {
            System.out.println("");
        }
        return sound;
    }

}
