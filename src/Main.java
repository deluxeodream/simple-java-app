
import program.SampleProgramFactory;

import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String exit;
      int nav;

      do {
          displayMainMenu();
          if (scanner.hasNextInt()) {
              nav = scanner.nextInt();
              SampleProgramFactory.
                      getInstance(getPrograms()
                              .get(nav))
                              .show();
          }

        exit = confirmExit(scanner);
      } while (!exit.equalsIgnoreCase("y"));


      scanner.close();
    }

     static void displayMainMenu() {

        System.out.println("=====================================================================");
        System.out.println("                       SIMPLE JAVA PROGRAMS                          ");
        System.out.println("=====================================================================");
        for (int i = 1; i < getPrograms().size(); i++) {
            System.out.printf(" %d. %s \n", i, getPrograms().get(i));
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Choose the program you want to view: ");

    }

    static List<String> getPrograms() {
        return List.of(
                "",
                "Internet Service Package Monthly Bill Computation",
                "Weather Bulletin",
                "Daily Time Record",
                "Simple Employee Salary Worksheet",
                "Simple Ordering App"
        );
    }

    static String confirmExit(Scanner scanner) {
        String exit;
        do {
            System.out.print("Do you want to exit? [Y/N]: ");
            exit = scanner.next();
            System.out.println();
            if (exit.length() != 1) {
                System.out.println("Invalid input, Please try again.");
            }
        } while (exit.length() != 1);

        return exit;
    }



}