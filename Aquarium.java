public class Aquarium {
    public static void main(String[] args) {
        Fish fish1 = new Fish("Dory", 25.015, 16.015);
        System.out.println(fish1);

        Fish fish2 = new Fish("mackerel", null, Double.NEGATIVE_INFINITY);
        System.out.println(fish2);
        
        Fish fish3 = new Fish();
        System.out.println(fish3);

        Fish fish4 = new Fish(fish1);
        System.out.println(fish4);

        Catfish fish5 = new Catfish("Niedermeyer", 50.0, 50.0, 51.0);
        System.out.println(fish5);

        Catfish fish6 = new Catfish(fish5);
        System.out.println(fish6);
    }
}
