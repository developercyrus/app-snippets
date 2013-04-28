package snippets.framework.mock.mockito.a1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Map;

import org.junit.Test;

public class MapTest {
    @Test
    public void testMockito() {
        Map mapMock = mock(Map.class);

        when(mapMock.get("firstKey")).thenReturn("firstValue");
        when(mapMock.get("secondKey")).thenReturn("secondValue");

        Object o = new Object();
        mapMock.put("anyObject", o);

        assertEquals("firstValue", mapMock.get("firstKey"));
        assertEquals("secondValue", mapMock.get("secondKey"));

        verify(mapMock).get("firstKey");
        verify(mapMock).get("secondKey");

        verify(mapMock).put("anyObject", o);
    }
}
