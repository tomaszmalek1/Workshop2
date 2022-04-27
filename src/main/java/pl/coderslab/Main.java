package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.util.Scanner;

public class Main {
    static final String[] OPTIONS = {"1 - Dodaj użytkownika", "2 - Usuń użytkownika", "3 - Wyświetl wszystkich użytkowników", "4 - Zmień dane użytkownika", "5 - Wyświetl dane użytkownika podając jego id", "6 - Koniec"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        printOptions(OPTIONS);

        User user = new User();
        UserDao userDao = new UserDao();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "6":
                    System.out.println("Bye, Bye!");
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Podaj nazwę użytkownika: ");
                    user.setUserName(scan.nextLine());

                    System.out.println("Podaj e mail: ");
                    user.setEmail(scan.nextLine());

                    System.out.println("Podaj hasło: ");
                    user.setPassword(scan.nextLine());

                    userDao.create(user);
                    System.out.println("Użytkownik dodany!");
                    break;
                case "2":
                    System.out.println("podaj id użytkownika do usunięcia:");
                    userDao.delete(scan.nextInt());
                    System.out.println("Użytkownik usunięty!");
                    break;
                case "3":
                    User[] all = userDao.findAll();
                    for (User u : all) {
                        System.out.println(u.toString());
                    }
                    break;
                case "4":
                    System.out.println("Podaj id użytkownika do zmiany: ");
                    User userToUpdate = userDao.findUserById(scanner.nextInt());

                    System.out.println("Podaj nazwę użytkownika: ");
                    userToUpdate.setUserName(scan.nextLine());

                    System.out.println("Podaj e mail: ");
                    userToUpdate.setEmail(scan.nextLine());

                    System.out.println("Podaj hasło: ");
                    userToUpdate.setPassword(scan.nextLine());

                    userDao.userUpdate(userToUpdate);
                    break;
                case "5":
                    System.out.println("Podaj id użytkownika: ");
                    User id = userDao.findUserById(scan.nextInt());
                    System.out.println(id.toString());
                    break;
                default:
                    System.out.println("Podaj poprwną opcję!");
            }
            printOptions(OPTIONS);
        }
    }

    public static void printOptions(String[] tab) {
        System.out.println("Wybierz opcję: ");
        for (String option : tab) {
            System.out.println(option);
        }
    }
}
