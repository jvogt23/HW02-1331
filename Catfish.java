public class Catfish extends Fish{
    //Data
    //Default should be 8.0
    private Double whiskerLength;

    //Constructors
    /**
     * Constructor for new Catfish. Extends Fish class.
     * @param name String representing the name of the Catfish
     * @param length Defaults to 8.0 if invalid input given.
     * @param weight Defaults to 2.0 if invalid input given.
     * @param whiskerLength Defaults to 8.0 if invalid input given.
     */
    public Catfish(String name, Double length, Double weight, Double whiskerLength) {
        super(name, length, weight);
        this.setWhiskerLength(whiskerLength);
    }

    /**
     * Default constructor<br>
     * Name: Bubba<br>
     * Length: 52<br>
     * Weight: 720<br>
     * Whisker Length: 5
     */
    public Catfish() {
        this("Bubba", 52.0, 720.0, 5.0);
    }

    /**
     * Copy constructor: deep copies other Catfish
     * @param other
     */
    public Catfish(Catfish other) {
        this(other.name, other.length, other.weight, other.whiskerLength);
    }

    /**
     * Sets whiskerLength while preventing invalid values (infinite, null, negative)
     * @param whiskerLength
     */
    public void setWhiskerLength(Double whiskerLength) {
        if (whiskerLength == null || Double.isNaN(whiskerLength) || 
            Double.isInfinite(whiskerLength) || whiskerLength <= 0) {
            this.whiskerLength = 8.0;
        } else {
            this.whiskerLength = whiskerLength;
        }
    }

    /**
     * Returns true if the Catfish's whiskerLength > length, false otherwise.
     * @return Boolean representing status as Shaggy/Not Shaggy
     */
    public boolean isShaggy() {
       if (this.whiskerLength > this.length) {
           return true;
       }
       return false;
    }

    /**
     * String representation of current Catfish. Overrides Fish.toString.
     */
    @Override
    public String toString() {
        String o = super.toString();
        if (this.isShaggy()) {
            o += String.format(
                " I'm a catfish whose longest whisker is %.2f, so I am shaggy.",
                this.whiskerLength);
        } else {
            o += String.format(
                " I'm a catfish whose longest whisker is %.2f, so I am not shaggy.",
                this.whiskerLength);
        }
        return o;
    }
}
