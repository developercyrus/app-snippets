package snippets.javax.sound.sampled.a1;

import java.io.File;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class WaveData {
    public boolean saveToFile(String name, AudioFileFormat.Type fileType, AudioInputStream audioInputStream) {
        System.out.println("Saving...");
        if (null == name || null == fileType || audioInputStream == null) {
            return false;
        }
        File myFile = new File(name + "." + fileType.getExtension());
        // reset to the beginnning of the captured data
        try {
            audioInputStream.reset();
        } catch (Exception e) {
            return false;
        }
        int i = 0;
        while (myFile.exists()) {
            String temp = "" + i + myFile.getName();
            myFile = new File(temp);
        }
        try {
            AudioSystem.write(audioInputStream, fileType, myFile);
        } catch (Exception ex) {
            return false;
        }
        System.out.println("Saved " + myFile.getAbsolutePath());
        return true;
    }
}