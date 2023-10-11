import java.util.Random;

public class FlyingFish extends Fish {
    private int flightTime;

    /**
     * Instantiates new FlyingFish from specified values
     * @param name The name of this FlyingFish
     * @param length the length of this FlyingFish
     * @param weight the weight of this FlyingFish
     * @param flightTime the flight time of this FlyingFish, defaults to 30.
     */
    public FlyingFish(String name, Double length, Double weight, int flightTime) {
        super(name, length, weight);
        if (flightTime <= 0) {
            this.flightTime = 30;
        } else {
            this.flightTime = flightTime;
        }
    }

    /**
     * Instantiates new FlyingFish from default values
     */
    public FlyingFish() {
        this("Gilbert", 12.0, 24.0, 36);
    }

    /**
     * Deep copies other FlyingFish to create a new FlyingFish
     * @param other A FlyingFish object to copy values from
     */
    public FlyingFish(FlyingFish other) {
        this(other.name, other.length, other.weight, other.flightTime);
    }

    /**
     * Calculates the power of the FlyingFish from weight and flight time.
     * @return Double representing the FlyingFish's power
     */
    public double calculatePower() {
        return weight * flightTime;
    }

    /**
     * Prints message representing FlyingFish flight. The flight time<br>
     * is a random floating point in range (0, this.flightTime].
     */
    public void fly() {
        Random rand = new Random();
        double ft = (rand.nextDouble() * flightTime) + 1;
        if (ft > this.flightTime) {
            ft = this.flightTime;
        }
        System.out.printf("Woohoo! %s flew for %.2f seconds.\r\n", this.name, ft);
    }

    /**
     * String representation of this FlyingFish. Overrides Fish.toString
     */
    @Override
    public String toString() {
        String o = super.toString();
        o += String.format(
            " I'm a flying fish, and my flight time record is %d, so my power is %.2f.",
            this.flightTime, this.calculatePower());
        return o;
    }
}
