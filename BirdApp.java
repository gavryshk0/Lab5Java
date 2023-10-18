public class BirdApp {

    public static void main(String[] args) {

        Wing wing = new Wing(10);

        Beak beak = new Beak("Pointed");

        Bird bird = new Bird(wing, beak);



        bird.fly();

        bird.land();

        bird.feed();

        bird.attack();



        // Виведення інформації про птаха

        System.out.println(bird);

    }

}



class Wing {

    private int length;



    public Wing(int length) {

        this.length = length;

    }



}



class Beak {

    private String shape;



    public Beak(String shape) {

        this.shape = shape;

    }



}



class Bird {

    private Wing wings;

    private Beak beak;



    public Bird(Wing wings, Beak beak) {

        this.wings = wings;

        this.beak = beak;

    }



    public void fly() {

        System.out.println("The bird is flying.");

    }



    public void land() {

        System.out.println("The bird is landing.");

    }



    public void feed() {

        System.out.println("The bird is feeding.");

    }



    public void attack() {

        System.out.println("The bird is attacking.");

    }



    @Override

    public String toString() {

        return "Bird{" +

               "wings=" + wings +

               ", beak=" + beak +

               '}';

    }

}