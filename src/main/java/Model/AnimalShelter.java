package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalShelter {

    private int petCount;

    private int packAnimalCount;

    private int allAnimalCount;

    private List<Pet> pets;

    private List<PackAnimal> packAnimals;

    public AnimalShelter() {
        petCount = 0;
        packAnimalCount = 0;
        this.allAnimalCount = 0;
        pets = new ArrayList<>();
        packAnimals = new ArrayList<>();
    }

    public void addAnimal(String species, String name, int age) {
        switch (species) {
            case "кот", "кошка" -> {
                pets.add(new Cat(species, name, age));
                System.out.println("Животное успешно добавлено");
                petCount++;
                allAnimalCount++;
            }
            case "хомяк" -> {
                pets.add(new Hamster(species, name, age));
                System.out.println("Животное успешно добавлено");
                petCount++;
                allAnimalCount++;
            }
            case "собака" -> {
                pets.add(new Dog(species, name, age));
                System.out.println("Животное успешно добавлено");
                petCount++;
                allAnimalCount++;
            }
            case "верблюд" -> {
                packAnimals.add(new Camel(species, name, age));
                System.out.println("Животное успешно добавлено");
                packAnimalCount++;
                allAnimalCount++;
            }
            case "лошадь" -> {
                packAnimals.add(new Horse(species, name, age));
                System.out.println("Животное успешно добавлено");
                packAnimalCount++;
                allAnimalCount++;
            }
            case "осёл" -> {
                packAnimals.add(new Donkey(species, name, age));
                System.out.println("Животное успешно добавлено");
                packAnimalCount++;
                allAnimalCount++;
            }
            default -> System.out.println("Такой вид мы содержать не можем");
        }
    }


    public Animal getAnimal(String species, String name) {
        switch (species) {
            case "кот", "кошка", "хомяк", "собака" -> {
                Animal pet = null;
                for (Pet p : pets) {
                    if (p.getName().equals(name) && p.getSpecies().equals(species)) {
                        pet = p;
                        return pet;
                    }
                }
                return pet;
            }
            case "верблюд", "лошадь", "осёл" -> {
                PackAnimal packAnimal = null;
                for (PackAnimal p : packAnimals) {
                    if (p.getName().equals(name) && p.getSpecies().equals(species)) {
                        packAnimal = p;
                        return packAnimal;
                    }
                }

            }
            default -> {
                return null;
            }
        }
        return null;
    }

    public void learnAction(String species, String name, String action) {
        switch (species) {
            case "кот", "кошка", "хомяк", "собака" -> {
                for (Pet p : pets) {
                    if (p.getSpecies().equals(species) && p.getName().equalsIgnoreCase(name)) p.learnAction(action);
                    System.out.println("Животное успешно обучено!");
                }
            }
            case "верблюд", "лошадь", "осёл" -> {
                for (PackAnimal p : packAnimals) {
                    if (p.getSpecies().equals(species) && p.getName().equalsIgnoreCase(name)) p.learnAction(action);
                    System.out.println("Животное успешно обучено");
                }
            }
            default -> System.out.println("Такого животного у нас нет");
        }
    }

    public void printAllAnimals() {
        System.out.println("Общее количество домашних животных в питомнике " + petCount);
        System.out.println("Общее количество животных в питомнике: " + allAnimalCount);
        System.out.println("Общее количество вьючных животных в питомнике " + packAnimalCount);
    }

    public void getSound() {
        for (Pet pet : pets) {
            System.out.println(pet.getName() + " кричит " + pet.getVoice());
        }
        for (PackAnimal packAnimal : packAnimals) {
            System.out.println(packAnimal.getName() + " кричит " + packAnimal.getVoice());
        }
    }

    public void circus() {
        for (Pet pet : pets) {
            pet.doAllAction();
        }
        for (PackAnimal packAnimal : packAnimals) {
            packAnimal.doAllAction();
        }
    }
}
