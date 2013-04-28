package snippets.jdk.util.zip.a1;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;

import org.junit.Test;

public class ReadingJarFileTest {

    @Test
    public void test() throws IOException {
        ReadingJarFile jars = new ReadingJarFile();
        String[] expected = {
                "META-INF/MANIFEST.MF",
                "SIA/Util/ArrayProc.class",
                "SIA/Util/Common.class",
                "SIA/Util/Convertor.class",
                "SIA/Util/Gvar.class",
                "SIA/Util/Reflect.class",
                "SIA/Util/StrEncrypt.class",
                "SIA/Util/StrProc.class",
                "SIA/Util/TimeoutRunnable.class",
                "META-INF/",
        };
        assertArrayEquals(expected, jars.getList());
    }
    
}