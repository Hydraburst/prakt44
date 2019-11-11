import javax.xml.crypto.Data;
import java.util.Comparator;
import java.util.Scanner;

import java.io.IOException;

public class Main {
    public static Database database;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        database = new Database(10);
        database.add(new Country("Brazil", "Brasilia", Continents.SOUTH_AMERICA, 207353391, 8515767, 1));
        database.add(new Country("USA", "Washington", Continents.NORTH_AMERICA, 328915700, 9519431, 2));
        database.add(new Country("Ukraine", "Kyiv", Continents.EUROPE, 41840426, 6035491, 3));
        database.add(new Country("Bulgaria", "Sofia", Continents.EUROPE, 7000000, 110994, 4));
        database.add(new Country("Moldova", "Kishinev", Continents.EUROPE, 3550900, 33846, 5));
        database.add(new Country("Russia", "Moscow", Continents.EUROPE, 146793744, 17098246, 6));
        database.add(new Country("Austria", "Vienna", Continents.EUROPE, 8857960, 83879, 7));
        database.add(new Country("Poland", "Warsaw", Continents.EUROPE, 37972812, 312696, 8));
        database.add(new Country("France", "Paris", Continents.EUROPE, 67022000, 640679, 9));
        database.add(new Country("Spain", "Madrid", Continents.EUROPE, 46733038, 505990, 10));
        ExTask executingTask = new ExTask();
        executingTask.start();
        Menu();
    }

    public static void BackUp() {
        BackUp backUp = new BackUp("Database.bcp", database);
        backUp.start();
    }

    public static void Menu() throws IOException, ClassNotFoundException {
        Serialization serialization = new Serialization("D://database.txt");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1) Removing from the database all countries with less than than given population");
            System.out.println("2) Search by the name of the capital");
            System.out.println("3) Search for occupied square over a given");
            System.out.println("4) Providing information about the states of a given continent with a choice of sorting method");
            System.out.println("0) Exit");
            System.out.println("5) Write data in file");
            System.out.println("6) Read  data from file ");
            System.out.println("7) Delete list");


            int swtch = in.nextInt();

            switch (swtch) {

                case 1:
                    System.out.println("Enter count of population: ");
                    int pop = in.nextInt();
                    database.remove(pop);
                    database.printAll();
                    break;

                case 2:
                    System.out.println("Enter a name of the capital: ");
                    String nam = in.next();
                    System.out.println(database.findAllByCapital(nam));
                    break;

                case 3:
                    System.out.println("Enter a square: ");
                    double sqr = in.nextDouble();
                    database.findAllWhereSquareBiggerThan(sqr).forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Choose a sort type: ");
                    System.out.println("1)name sort ");
                    System.out.println("2)square sort ");
                    System.out.println("3)pop sort ");
                    int sort = in.nextInt();
                    Comparator<Country> comp = null;
                    switch (sort) {
                        case 1:
                            comp = new NameComparator();
                            break;
                        case 2:
                            comp = new SquareComparator();
                            break;
                        case 3:
                            comp = new PopulationComparator();
                            break;
                    }
                    database.sort(comp).forEach(System.out::println);
                    break;


                case 0:
                    System.exit(0);

                case 5:

                    System.out.println(serialization.Serialization(database));
                    break;

                case 6:
                    System.out.println(serialization.Deserialization(database));
                    break;

                case 7: {

                    database.list.clear();
                }
            }
        }
    }
}