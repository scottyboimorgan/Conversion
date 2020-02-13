/* *****************************************************************
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
import java.security.acl.LastOwnerException;
import java.util.*;
import java.lang.*;

// conversion class
//
// CONSTRUCTOR: no constructor specified (default)
//
// ****************  PUBLIC OPERATIONS  **********************************
// void  menuDisplay()             --> Displays the UI menu with the options listed as integer values
// int getMenuChoice()             --> Takes menu selection input from user
// String getValueForConversion()  --> Gets the users input to convert from one measurement to another
// void menuOpsForConversions()    --> Selects the proper conversion method based on user selection
// void finishConversion(          --> Checks for the user's desired number of decimal places and prints the converted value
// float convertX2Y()              --> One for each conversion pair
// void main()                     --> Main method for calling the UI
//*************************************************************************
//

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
    {  // Convert fahrenheit to celsius
        float num2;
        float num1 = string2Float(FAsStr);
        // Convert
        num2 = (float) ( ( (num1-32.0) * 5.0) / 9.0);
        return (num2);
    }

    private float convertC2F (String CAsStr)
    {  // Convert celsius to fahrenheit
        float num2;
        float num1 = string2Float(CAsStr);
        // Convert
        num2 = (float) ( (num1 * 9.0 / 5.0) + 32.0);
        return(num2);
    }

    // small distance
    private float convertIn2Cm (String inAsStr)
    {  // Convert inches to centimeters
        float num2;
        float num1 = string2Float(inAsStr);
        // Convert
        num2 = (float) (num1 * 2.54);
        return(num2);
    }

    private float convertCm2In (String cmAsStr)
    {  // Convert centimeters to inches
        float num2;
        float num1 = string2Float(cmAsStr);
        // Convert
        num2 = (float) (num1 * 0.3937);
        return(num2);
    }

    // medium distance
    private float convertF2M (String ftAsStr)
    {  // Convert feet to meters
        float num2;
        float num1 = string2Float(ftAsStr);
        // Convert
        num2 = (float) (num1 * 0.3048);
        return(num2);
    }

    private float convertM2F (String mAsStr)
    {  // Convert meters to feet
        float num2;
        float num1 = string2Float(mAsStr);
        // Convert
        num2 = (float) (num1 / 0.6048);
        return(num2);
    }

    // large distance
    private float convertM2K (String miAsStr)
    {  // Convert miles to kilometers
        float num2;
        float num1 = string2Float(miAsStr);
        // Convert
        num2 = (float) (num1 * 1.609);
        return(num2);
    }

    private float convertK2M (String kmAsStr)
    {  // Convert kilometers to miles
        float num2;
        float num1 = string2Float(kmAsStr);
        num2 = (float) (num1 * 0.6214);
        return(num2);
    }

    // volume
    private float convertG2L (String galAsStr)
    {  // Convert gallons to liters
        float num2;
        float num1 = string2Float(galAsStr);
        // Convert
        num2 = (float) (num1 * 3.785);
        return(num2);
    }

    private float convertL2G (String LAsStr)
    {  // Convert liters to gallons
        float num2; // temporary variables
        float num1 = string2Float(LAsStr);
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

    /**
     * Converts a string to a float
     * @param s string with a float value
     * @return the float value of the input
     */
    private float string2Float(String s){
        float num1; // temporary variable
        num1 = Float.parseFloat(s);
        return num1;
    }

    /**
     * Displays the UI menu with the options listed as integer values
     */
    private static void menuDisplay(){
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
        System.out.println("15.\tMiles per hour (mph) to Kilometers per hour(km/h)");
        System.out.println("16.\tKilometers per hour (km/h) to Miles per hour (mph)");
        System.out.println("0.\tEXIT PROGRAM");
    }

    /**
     * Gets the user's menu choice
     * @return the number of the menu choice
     */
    private static int getMenuChoice(){
        int ans;
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
    private String getValueForConversion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value you would like to convert:");
        return sc.next();
    }

    /**
     * This method performs the operations based on the user's input. Depending on their selection,
     * a different measurement is converted. The newly converted value's abbreviation will appear
     * after the new value.
     */
    private void menuOpsForConversions(){
        int choice = -1;
        while(choice != 0){
            menuDisplay();
            choice = getMenuChoice();
            switch(choice){
                case 0:
                    System.out.println("Thank you for using Conversions.java\nBye!");
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
                case 15:
                    finishConversion(convertM2K(getValueForConversion()),  "km/h");
                    break;
                case 16:
                    finishConversion(convertK2M(getValueForConversion()),  "mph");
                    break;
            }
        }

    }

    /**
     * Checks for the user's desired number of decimal places and prints the converted value
     * @param f the float value to convert
     * @param unit the unit of measurement we are converting to
     */
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
     * @param args CLI
     */
    public static void main(String[]args){
        Conversions c = new Conversions();
        c.menuOpsForConversions();
    }

}
