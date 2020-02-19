import org.junit.*;
import static org.junit.Assert.*;

public class ConversionsTest {
    Conversions c;
    float a;

    @Before
    public void setUp(){
        c = new Conversions();
        a = -1;
    }
/*

    TEST CASES INPUT DOMAIN FOR CONVERSIONS:
        null
        a negative number
        a positive number
        0
        string of letters

 */


    /**
     * Tests the conversions of temperature
     */
    @Test
    public void testTempConversions(){
        a = c.convertC2F("0");
        assertEquals(32.0, a, 0);
        a = c.convertF2C("0");
        assertEquals(-17.7778, a, 0.0001);
        a = c.convertF2C("32");
        assertEquals(0.0, a, 0);
        a = c.convertC2F("100");
        assertEquals(212, a, 0.0);
        a = c.convertC2F("-10");
        assertEquals(14.0, a,0);
        a = c.convertF2C("-10");
        assertEquals(-23.3333, a, 0.0001);
        try {
            a = c.convertC2F(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try {
            a = c.convertF2C(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try{
            a = c.convertC2F("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
        try{
            a = c.convertF2C("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
    }

    @Test
    public void testSmallDistanceConversions(){
        a = c.convertCm2In("0");
        assertEquals(0, a, 0);
        a = c.convertIn2Cm("0");
        assertEquals(0, a, 0);
        a = c.convertCm2In("1");
        assertEquals(0.3937, a, 0.0001);
        a = c.convertIn2Cm("1");
        assertEquals(2.54, a, 0.0);
        a = c.convertIn2Cm("-10");
        assertEquals(-25.4, a,0);
        a = c.convertCm2In("-10");
        assertEquals(-3.9370, a, 0.0001);
        try {
            a = c.convertIn2Cm(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try {
            a = c.convertCm2In(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try{
            a = c.convertIn2Cm("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
        try{
            a = c.convertCm2In("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
    }

    @After
    public void tearDown(){
        c = null;
        a = -1;
    }
}