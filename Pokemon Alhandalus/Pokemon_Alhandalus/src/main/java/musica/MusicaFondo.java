package musica;

import java.io.File;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class MusicaFondo extends Thread {
    private File musica;

    public void run() {
        super.run();
        try {
        	 Clip reproductor = AudioSystem.getClip();
             AudioInputStream archivo = AudioSystem.getAudioInputStream(musica);
             reproductor.open(archivo);
             reproductor.start();
            
        } catch (LineUnavailableException e) {
           
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
          
            e.printStackTrace();
        } catch (IOException e) {
        	
            e.printStackTrace();
        }


    }
    /**
     * @param musica
     */
    public MusicaFondo(File musica) {
        super();
        this.musica = musica;
    }

    
    

}