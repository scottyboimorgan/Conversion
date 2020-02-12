/** *****************************************************************
 conversion.java
 Converts various measures from one unit to another

 @author Jeff Offutt & Ren Li

 @version 1.0    October 2000
 @version 2.0    June 2015
 @version 2.1    January 2020

 @UI_Change_Authors: Scott Morgan, Nestor Maldonado, Amine Bourdi
 @version 1.0 February 2020

  ********************************************************************* */

/* Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;
*/

// Import Java Libraries
import sun.awt.geom.AreaOp; //unused

import java.io.*; //unused
import java.util.*;
import java.lang.*;

// conversion class
//
// CONSTRUCTOR: no constructor specified (default)
//
// ****************  PUBLIC OPERATIONS  **********************************
// void  doGet()      --> Uses PrintHead() and PrintForm() to print the screen
// void  PrintHead()  --> Generates the head of the web page
// void  PrintForm()  --> Generates the form of the web page
// void  doPost()     --> Handles the conversions
// float convertX2Y() --> One for each conversion pair
//*************************************************************************
//
// The possible IOException on the PrintWriter is thrown up.

/**
 *
 */
public class Conversions //extends HttpServlet
{


    /** *****************************************************
     *  Conversion methods below
     *  14 methods, 2 for each pair of units
     ********************************************************* */
    private float convertF2C (String FAsStr)
    {  // Convert farenheit to celsius
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf(FAsStr).floatValue());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return (num2);
    }

    private float convertC2F (String CAsStr)
    {  // Convert celsius to farenheit
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (CAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // small distance
    private float convertIn2Cm (String inAsStr)
    {  // Convert inches to centimeters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (inAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 2.54);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertCm2In (String cmAsStr)
    {  // Convert centimeters to inches
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (cmAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.3937);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // medium distance
    private float convertF2M (String ftAsStr)
    {  // Convert feet to meters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (ftAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.3048);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertM2F (String mAsStr)
    {  // Convert meters to feet
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (mAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 0.6048);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // large distance
    private float convertM2K (String miAsStr)
    {  // Convert miles to kilometers
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (miAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 1.609);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertK2M (String kmAsStr)
    {  // Convert kilometers to miles
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (kmAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 0.6214);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    // volume
    private float convertG2L (String galAsStr)
    {  // Convert gallons to liters
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (galAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 * 3.785);
        // Back to 2 digits
        n    = Math.round(num2 * (float)100.0);
        num2 = (float) (n / (float)100.0);
        return(num2);
    }

    private float convertL2G (String LAsStr)
    {  // Convert liters to gallons
        float num1, num2; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (LAsStr).floatValue ());
        n    = Math.round(num1 * (float)100.0);
        num1 = (float) (n / (float)100.0);
        // Convert
        num2 = (float) (num1 / 3.785);
        return(num2);
    }

    // small weight
    private float convertOz2G (String ozAsStr)
    {  // Convert ounces to grams
        float num2;
        float num1 = string2Float(ozAsStr);
        num2 = (float) (num1 * 28.35);
        return(num2);
    }

    private float convertG2Oz (String gAsStr)
    {  // Convert grams to ounces
        float num2; // temporary variables
        float num1 = string2Float(gAsStr);
        num2 = (float) (num1 / 28.35);
        return(num2);
    }

    // medium weight
    private float convertLb2K (String lbAsStr)
    {  // Convert pounds to kilograms
        float num2;
        float num1 = string2Float(lbAsStr);
        // Convert
        num2 = (float) (num1 * 0.4536);
        return(num2);
    }

    private float convertK2Lb (String kgAsStr)
    {  // Convert kilograms to pounds
        float num2;
        float num1 = string2Float(kgAsStr);
        // Convert
        num2 = (float) (num1 * 2.205);
        return(num2);
    }

    private float string2Float(String s){
        float num1; // temporary variables
        int n; // temporary variable
        // Round to 2 digits past decimal
        num1 = (Float.valueOf (s).floatValue ());
       // n    = Math.round(num1 * (float)10000.0000);
        //num1 = (float) (n / (float)10000.0000);
        return num1;
    }

    /**
     * Displays the UI menu with the options listed as integer values
     */
    public static void menuDisplay(){
        System.out.println("MEASUREMENT CONVERSION");
        System.out.println("1.\tFahrenheit (F) to Celsius (C)");
        System.out.println("2.\tCelsius (C) to Fahrenheit (F)");
        System.out.println("3.\tInches (in) to Centimeters (cm)");
        System.out.println("4.\tCentimeters (cm) to Inches (in)");
        System.out.println("5.\tFeet (ft) to Meters (m)");
        System.out.println("6.\tMeters (m) to Feet (ft)");
        System.out.println("7.\tMiles (mi) to Kilometers (km)");
        System.out.println("8.\tKilometers (km) to Miles (mi)");
        System.out.println("9.\tGallons (gal) to Liters (L)");
        System.out.println("10.\tLiters (L) to Gallons (gal)");
        System.out.println("11.\tOunces (oz) to Grams (g)");
        System.out.println("12.\tGrams (g) to Ounces (oz)");
        System.out.println("13.\tPounds (lb) to Kilograms (kg)");
        System.out.println("14.\tKilograms (kg) to Pounds (lbs)");
        System.out.println("0.\tEXIT PROGRAM");
    }

    /**
     * Gets the user's menu choice
     * @return the number of the menu choice
     */
    public static int getMenuChoice(){
        int ans = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter menu number to choose conversion");
        ans = Integer.parseInt(sc.next());
        return ans;
    }

    /**
     * Gets the users input to convert from one measurement to another
     * @return The string entered by the user to use for conversion, does not type check as the
     * original servelet does not account for this either
     */
    public String getValueForConversion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value you would like to convert:");
        return sc.next();
    }

    /**
     * This method performs the operations based on the user's input. Depending on their selection,
     * a different measurement is converted. The newly converted value's abbreviation will appear
     * after the new value.
     */
    public void menuOpsForConversions(){
        int choice = -1;
        while(choice != 0){
            menuDisplay();
            choice = getMenuChoice();
            switch(choice){
                case 0:
                    System.out.println("Program terminated");
                    break;
                case 1:
                    finishConversion(convertF2C(getValueForConversion()), "C");
                    break;
                case 2:
                    finishConversion(convertC2F(getValueForConversion()), "F");
                    break;
                case 3:
                    finishConversion(convertIn2Cm(getValueForConversion()), "cm");
                    break;
                case 4:
                    finishConversion(convertCm2In(getValueForConversion()), "in");
                    break;
                case 5:
                    finishConversion(convertF2M(getValueForConversion()), "m");
                    break;
                case 6:
                    finishConversion(convertM2F(getValueForConversion()), "ft");
                    break;
                case 7:
                    finishConversion(convertM2K(getValueForConversion()),  "km");
                    break;
                case 8:
                    finishConversion(convertK2M(getValueForConversion()),  "mi");
                    break;
                case 9:
                    finishConversion(convertG2L(getValueForConversion()),  "L");
                    break;
                case 10:
                    finishConversion(convertL2G(getValueForConversion()),  "gal");
                    break;
                case 11:
                    finishConversion(convertOz2G(getValueForConversion()),  "g");
                    break;
                case 12:
                    finishConversion(convertG2Oz(getValueForConversion()), "oz");
                    break;
                case 13:
                    finishConversion(convertLb2K(getValueForConversion()),"kg");
                    break;
                case 14:
                    finishConversion(convertK2Lb(getValueForConversion()), "lbs");
                    break;
            }
        }

    }

    private void finishConversion(float f, String unit){
        String numPlaces;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many decimal places would you like to round to (0-4)?");
        numPlaces = sc.next();
        int places = Integer.parseInt(numPlaces);
        switch(places){
            case 0:
                System.out.printf("%.0f " + unit + "\n", f);
                break;
            case 1:
                System.out.printf("%.1f " + unit + "\n", f);
                break;
            case 2:
                System.out.printf("%.2f " + unit + "\n", f);
                break;
            case 3:
                System.out.printf("%.3f " + unit + "\n", f);
                break;
            case 4:
                System.out.printf("%.4f " + unit + "\n", f);
                break;
        }
    }

    /**
     * Main method for calling the UI
     * @param args
     */
    public static void main(String[]args){
        Conversions c = new Conversions();
        c.menuOpsForConversions();
    }

}
