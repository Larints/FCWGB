package Model;

public class Dog extends Pet {

    public Dog(String species, String name, int age) {
        super(species, name, age);
        setVoice("Гав - Гав");
    }
}
