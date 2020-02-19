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
     * Tests the conversions of temperature (C to F, F to C)
     */
    @Test
    public void testTempConversions(){
        a = c.convertC2F("0");
        assertEquals(32.0, a, 0);
        a = c.convertF2C("0");
        assertEquals(-17.7778, a, 0.001);
        a = c.convertF2C("32");
        assertEquals(0.0, a, 0.001);
        a = c.convertC2F("100");
        assertEquals(212, a, 0.001);
        a = c.convertC2F("-10");
        assertEquals(14.0, a,0.001);
        a = c.convertF2C("-10");
        assertEquals(-23.3333, a, 0.001);
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

    /**
     * This Test covers both the inches to cm conversion method
     * and the cm to inches conversion methods
     */
    @Test
    public void testSmallDistanceConversions(){
        a = c.convertCm2In("0");
        assertEquals(0, a, 0);
        a = c.convertIn2Cm("0");
        assertEquals(0, a, 0);
        a = c.convertCm2In("1");
        assertEquals(0.3937, a, 0.001);
        a = c.convertIn2Cm("1");
        assertEquals(2.54, a, 0.001);
        a = c.convertIn2Cm("-10");
        assertEquals(-25.4, a,0.001);
        a = c.convertCm2In("-10");
        assertEquals(-3.9370, a, 0.001);
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

    /**
     * This Test covers conversion Meters <--> Feet
     */
    @Test
    public void testMediumDistanceConversions(){
        a = c.convertM2F("0");
        assertEquals(0, a, 0);
        a = c.convertF2M("0");
        assertEquals(0, a, 0);
        a = c.convertM2F("1");
        assertEquals(3.2808, a, 0.001);
        a = c.convertF2M("1");
        assertEquals(0.3048, a, 0.001);
        a = c.convertF2M("-10");
        assertEquals(-3.048, a,0.001);
        a = c.convertM2F("-10");
        assertEquals(-32.8084, a, 0.001);
        try {
            a = c.convertF2M(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try {
            a = c.convertM2F(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try{
            a = c.convertF2M("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
        try{
            a = c.convertM2F("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
    }

    /**
     * This test covers the miles to km conversion, km to miles, MPH to KM/H, and KM/H to MPH
     * The speed conversions call the same methods as the distance conversions, so they will
     * not have their own test method.
     * LESS TESTS = MORE $$$$$$$
     */
    @Test
    public void testLargeDistanceConversions(){
        a = c.convertK2M("0");
        assertEquals(0, a, 0);
        a = c.convertM2K("0");
        assertEquals(0, a, 0);
        a = c.convertK2M("10");
        assertEquals(6.2137, a, 0.001);
        a = c.convertM2K("10");
        assertEquals(16.0934, a, 0.001);
        a = c.convertK2M("-10");
        assertEquals(6.2137, a,0.001);
        a = c.convertM2K("-10");
        assertEquals(-16.0934, a, 0.001);
        try {
            a = c.convertM2K(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try {
            a = c.convertK2M(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try{
            a = c.convertM2K("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
        try{
            a = c.convertK2M("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
    }

    /**
     * This test covers the conversions Gallons <--> Liters
     */
    @Test
    public void testVolumeConversions(){
        a = c.convertG2L("0");
        assertEquals(0, a, 0.001);
        a = c.convertL2G("0");
        assertEquals(0, a, 0.001);
        a = c.convertG2L("1");
        assertEquals(3.785, a, 0.001);
        a = c.convertL2G("1");
        assertEquals(0.264, a, 0.001);
        a = c.convertG2L("-1");
        assertEquals(-3.785, a,0.001);
        a = c.convertL2G("-1");
        assertEquals(-0.264, a, 0.001);
        try {
            a = c.convertOz2G(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try {
            a = c.convertG2Oz(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try{
            a = c.convertOz2G("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
        try{
            a = c.convertG2Oz("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
    }


    /**
     * Tests the oz to grams conversions and grams to oz
     */
    @Test
    public void testSmallWeightConversions(){
        a = c.convertOz2G("0");
        assertEquals(0, a, 0.001);
        a = c.convertG2Oz("0");
        assertEquals(0, a, 0.001);
        a = c.convertOz2G("10");
        assertEquals(283.495, a, 0.001);
        a = c.convertG2Oz("10");
        assertEquals(0.3527, a, 0.001);
        a = c.convertOz2G("-10");
        assertEquals(-283.495, a,0.001);
        a = c.convertG2Oz("-10");
        assertEquals(-0.3527, a, 0.001);
        try {
            a = c.convertOz2G(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try {
            a = c.convertG2Oz(null);
            Assert.fail("Should not have null input");
        }
        catch(NullPointerException e){
        }

        try{
            a = c.convertOz2G("letters");
            Assert.fail("User must enter a number");
        }
        catch(NumberFormatException e){
        }
        try{
            a = c.convertG2Oz("letters");
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