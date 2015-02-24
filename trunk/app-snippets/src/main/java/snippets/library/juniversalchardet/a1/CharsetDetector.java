package snippets.library.juniversalchardet.a1;
import java.io.FileInputStream;

import org.mozilla.universalchardet.UniversalDetector;

public class CharsetDetector {

    public static String detect(String path) throws Exception {
        FileInputStream fis = new FileInputStream(path);
        UniversalDetector detector = new UniversalDetector(null);

        int nread;
        byte[] buf = new byte[4096];
        while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, nread);
        }
        fis.close();
        detector.dataEnd();

        String encode = detector.getDetectedCharset();
        return encode;
    }
}
