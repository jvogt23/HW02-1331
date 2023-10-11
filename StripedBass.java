public class StripedBass extends Fish {
    //Data
    //Defaults to 25
    private int stripeCount;
    private boolean isSaltwater;
    private Catfish bestFriend;

    /**
     * Instantiates new StripedBass with specified values
     * @param name This StripedBass's name
     * @param length Length, in inches, defaults to Fish defaults if invalid number given
     * @param weight Weight, in ounces, defaults to Fish defaults if invalid number given
     * @param stripeCount Number of stripes on this StripedBass, defaults to 25
     * @param isSaltwater Whether this StripedBass lives in salt water
     * @param bestFriend A Catfish object that is friends with this StripedBass
     */
    public StripedBass(String name, Double length, Double weight,
        int stripeCount, boolean isSaltwater, Catfish bestFriend) {
        super(name, length, weight);
        if (stripeCount <= 0) {
            this.stripeCount = 25;
        } else {
            this.stripeCount = stripeCount;
        }
        if (bestFriend != null) {
            this.bestFriend = new Catfish(bestFriend);
        } else {
            this.bestFriend = null;
        }
        this.isSaltwater = isSaltwater;
    }

    /**
     * Instantiates new StripedBass with default values
     */
    public StripedBass() {
        this("Striper", 30.0, 320.0, 14, false, null);
    }

    /**
     * Deep copies a StripedBass to a new object
     * @param other StripedBass whose attributes should be deep copied.
     */
    public StripedBass(StripedBass other) {
        this(other.name, other.length, other.weight, other.stripeCount, other.isSaltwater, other.bestFriend);
    }

    /**
     * Migrates this StripedBass to the other water body type<br>
     * if it does not have a bestFriend
     */
    public void migrate() {
        if (this.bestFriend == null) {
            this.isSaltwater = !this.isSaltwater;
        }
    }

    /**
     * String representation of this StripedBass. Overrides Fish.toString()
     */
    @Override
    public String toString() {
        String o = super.toString();
        o += (this.isSaltwater
            ? " I'm a saltwater striped bass " : " I'm a freshwater striped bass ");
        o += String.format("with %d stripes. ", stripeCount);
        o += (this.bestFriend != null
            ? String.format("I have a best friend named %s.", bestFriend.name)
            : "I have no best friend.");
        return o;
    }


}
