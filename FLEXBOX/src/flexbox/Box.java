package flexbox;

/**
 *This is the SuperClass
 * @author UP818044, UP828826, UP866877, UP853094, UP863243
 */
public abstract class Box 
{
    /**
     * Box Superclass
     * @param height
     * @param width
     * @param length
     * @param grade
     * @param sealableTops 
     */
    public Box(double height, double width, double length, int grade, boolean sealableTops)
            {
            }
    
        /**
    * Calculates the base price of the box
    * @param sArea The surface area of the box.
    * @param grade The grade of the cardboard.
    * @return The base price of the box.
    */
    public double getPrice(double sArea, int grade)
    {
        double basePrice = 0;
        //Calculates the pirce of the box
        switch (grade) {
            case 1:
                {
                    basePrice = sArea * 0.55;
                    break;
                }
            case 2:
                {
                    basePrice = sArea * 0.65;
                    break;
                }
            case 3:
                {
                    basePrice = sArea * 0.82;
                    break;
                }
            case 4:
                {
                    basePrice = sArea * 0.98;
                    break;
                }
            case 5:
                {
                    basePrice = sArea * 1.50;
                    break;
                }
            default:
                break;
        }
        //Return the base price of the box.
        return basePrice;
    }
    
    abstract String getType();
    abstract double getTotal();
    abstract String getReceipt();
    
    //  To round up the decimals up to 2 place
    public double round(double num)
    {
        return ((double)(Math.round(num*100)))/100;
    }
    
}
