package snippets.library.mmseg4j.a1;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class ChineseSegmentatorTest {
	@Test
	public void testSegWords() throws IOException {
		ChineseSegmentator seg = new ChineseSegmentator();		
		
		String str = "在祷告之间、 常常恳求、 或者照神的旨意、 终能得平坦的道路往你们那里去。";
		String expected = "在|祷告|之间|常常|恳求|或者|照|神|的|旨意|终|能|得|平坦|的|道路|往|你们|那里|去";
		String actual = seg.segWords(str, "|");
		
		 assertEquals(expected, actual);
    }
}
