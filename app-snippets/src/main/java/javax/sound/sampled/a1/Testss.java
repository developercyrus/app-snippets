package javax.sound.sampled.a1;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;

public class Testss {
    public static void main(String[] args) throws Exception {
        AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
        MicrophoneRecorder mr = new MicrophoneRecorder(format);  
        mr.start();  
        Thread.sleep(10000);  
        mr.stop();  
        //save  
        WaveData wd = new WaveData();  
        Thread.sleep(3000);  
        wd.saveToFile("D:/tmp/sound", Type.WAVE, mr.getAudioInputStream());  
    }
}
