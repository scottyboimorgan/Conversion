import org.junit.*;
import static org.junit.Assert.*;

public class ConversionsTest {
    Conversions c;
    float f;

    @Before
    public void setUp(){
        c = new Conversions();
        f = -1;
    }

    @Test
    public void testTempConversions(){
        f = c.convertC2F("0");
        assertEquals(32.0, f, 0);
    }

    @After
    public void tearDown(){
        c = null;
        f = -1;
    }
}