import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

public class SpelaMusik{


    public static void PlaySound(String filename){

        try {


            File sound = new File(filename);

            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(sound));

            clip.start();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }


    }
}
