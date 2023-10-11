/**
 * Represents a Fish object.
 * @author jvogt33
 */
public class Fish {
    //Data
    protected String name;
    protected Double length;
    protected Double weight;
    //Only modify in the body of Fish constructor
    private static int totalFish = 0;

    /**
     * Constructor for Fish object
     * @param name The name of the Fish
     * @param length The length of the Fish, as a positive Double
     * @param weight The weight of the Fish as a positive Double
     */
    public Fish(String name, Double length, Double weight) {
        if (name == null || name.length() == 0 || name.trim() == "") {
            this.name = "Nemo";
        } else {
            this.name = name;
        }

        if (length == null ||Double.isNaN(length) || 
            Double.isInfinite(length) || length <= 0) {
            this.length = 8.0;
        } else {
            this.length = length;
        }

        if (weight == null || Double.isNaN(weight) || 
            Double.isInfinite(weight) || weight <= 0) {
            this.weight = 2.0;
        } else {
            this.weight = weight;
        }
        totalFish++;
    }

    /**
     * Constructor for a Fish with default values. <br>
     * Name: Nemo<br>
     * Length: 5.0<br>
     * Weight: 12.0
     */
    public Fish() {
        this("Nemo", 5.0, 12.0);
    }

    /**
     * Copy constructor: deep copies other Fish
     * @param other
     */
    public Fish(Fish other) {
        this(other.name, other.length, other.weight);
    }

    //Methods
    /**
     * formatLength
     * @return String interpretation of this Fish's length
     */
    public String formatLength() {
        String o = "";
        double[] splitUnits = separateUnits(length, 12);
        int ft = (int) splitUnits[0];
        double in = splitUnits[1];
        o = String.format("%d ft %.2f in", ft, in);
        return o;
    }

    /**
     * formatWeight
     * @return String interpretation of this Fish's weight
     */
    public String formatWeight() {
        String o = "";
        double[] splitUnits = separateUnits(weight, 16);
        int lb = (int) splitUnits[0];
        double oz = splitUnits[1];
        if (lb > 1) {
            o = String.format("%d lbs %.2f oz", lb, oz);
        } else {
            o = String.format("%d lb %.2f oz", lb, oz);
        }
        return o;
    }

    /**
     * toString
     * @return String interpretation of this Fish
     */
    @Override
    public String toString() {
        return String.format(
            "I'm a talking fish named %s. My length is %s and my weight is %s.",
            this.name, this.formatLength(), this.formatWeight());
    }

    private double[] separateUnits(Double in, int distBetweenUnits) {
        double[] o = new double[2];
        int big = (int) (in / distBetweenUnits);
        double small = in - (big * distBetweenUnits);
        o[0] = big;
        o[1] = small;
        return o;
    }

}