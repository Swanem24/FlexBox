package flexbox;

import java.text.DecimalFormat;

/**
 *
 * @author UP818044, UP828826, UP866877, UP853094, UP863243
 */
public class Box5 extends Box{
    
    //Parameters of the Box
    private final double bHeight;
    private final double bWidth;
    private final double bLength;
    private final int bGrade;
    private final boolean sT;
    
    
    private final double sArea;   // The surface Area
    private double extras = 0; //The total price for the extras
    private double basePrice; //The base price of the box
    
    /**
     * This is type 5
     * @param height
     * @param width
     * @param length
     * @param grade
     * @param sealableTops
     */
    
    public Box5(double height, double width, double length, int grade, boolean sealableTops)
    {
        super(height, width, length, grade, sealableTops);
        bHeight = height;
        bWidth = width;
        bLength = length;
        bGrade = grade;
        sT = sealableTops;
        sArea = (2 * (height * width)) + (2 * (height * length)) + (2 * (width * length));
    }
    
    //  Returns Type 5
    String getType()
    {
        return "5";
    }
    
    double getTotal()
    {
        return extras + basePrice;
    }
    
    /**
     * Return the receipt of the extras to print on the
     * receipt with the prices for individual extras.
     * @return A string of extras with their pricing
     * for the receipt.
     */
    String getReceipt(){
        DecimalFormat dFormat = new DecimalFormat("0.00");
        //Get the price of the box
        basePrice = getPrice(sArea, bGrade);
        extras = round(basePrice * 0.15) + round(basePrice * 0.13) + round(basePrice *  0.12);
        
        String receipt = "\n    Height: " + bHeight + " Meters";
        receipt += "\n  Width: " + bWidth + " Meters";
        receipt += "\n  Length: " + bLength + " Meters";
        receipt += "\n  Base Cost: " + "\t£" + dFormat.format(round(basePrice));
        receipt += "\n  Grade: " + bGrade; 
        receipt += "\n  Colour: 2\t£" + dFormat.format(round(basePrice * 0.15));
        receipt += "\n  R-Bottom:\t£" + dFormat.format(round(basePrice * 0.13));
        receipt += "\n  R-Corners:\t£" + dFormat.format(round(basePrice * 0.12));
        //Does the box have a sealable top?
        if (sT)
        {
            receipt += "\n  Sealable Top: \t£" + dFormat.format(round(basePrice * 0.10)); 
            extras += round(basePrice * 0.10);
        }
        //Return the receipt of extras
        return receipt;
    }    
}
