package UI;

import Model.Animal;
import Presenter.Presenter;

import java.util.Scanner;

public class ConsoleInterface {

    private Scanner console;

    private Presenter presenter;

    private String select = """         
            1. Занести животное в питомник.
            2. Проверить наличие животного в питомнике.
            3. Научить животное команде.
            4. Показать общее количество животных.
            5. Устроить перекличку!
            6. Даёшь цирк!
            7. Выход.
            """;

    public ConsoleInterface() {
        this.console = new Scanner(System.in);
        this.presenter = new Presenter();
    }

    public void animalShelterMenu() {
        String species;
        String name;
        int age;
        while (true) {
            System.out.println("=".repeat(50));
            System.out.println(select);
            System.out.println("=".repeat(50));
            switch (console.nextLine()) {
                case "1" -> {
                    System.out.println("Введите вид, имя и возраст животного");
                    species = console.nextLine().toLowerCase();
                    name = console.nextLine();
                    try {
                        age = Integer.parseInt(console.nextLine());
                        presenter.addAnimal(species, name, age);
                    } catch (Exception e) {
                        System.out.println("Неверный формат числа");
                    }
                }
                case "2" -> {
                    System.out.println("Введите вид и имя животного");
                    species = console.nextLine().toLowerCase();
                    name = console.nextLine().toLowerCase();
                    Animal animal = presenter.getAnimal(species, name);
                    if (animal != null) System.out.println(animal);
                    else System.out.println("Животное не найдено");
                }
                case "3" -> {
                    System.out.println("Введите вид, имя животного и команду которой хотите обучить\n" +
                            "Помните, что верблюда не научить скакать!");
                    String action;
                    species = console.nextLine().toLowerCase();
                    name = console.nextLine();
                    action = console.nextLine();
                    presenter.learnAction(species, name, action);
                }
                case "4" -> presenter.printAllAnimals();
                case "5" -> presenter.getSound();
                case "6" -> presenter.circus();
                case "7" -> {
                    return;
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
}
