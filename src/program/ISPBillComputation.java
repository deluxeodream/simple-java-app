package program;

import java.util.Scanner;

public class ISPBillComputation implements SampleProgram {

    public ISPBillComputation() {

        /**
         * A program that calculates a customer's monthly bill.
         * It should ask the user to enter the letter of the package the customer has purchased (A,B,C)
         * and the number of hours that were used.
         * */

    }

    @Override
    public void show() {

        InternetPackage packageA = new InternetPackage(9.95, 10, 2);
        InternetPackage packageB = new InternetPackage(13.95, 20, 1);
        InternetPackage packageC = new InternetPackage(19.95, 0, 0);

        double total = 0;

        Scanner scanner = new Scanner(System.in);

        char pkg;

            packageOffers();
            System.out.print("\nENTER THE CHOSEN PACKAGE: ");
            pkg = scanner.next().toUpperCase().charAt(0);
            System.out.print("\nHOURS OF ACCESS USED: ");
            int access = scanner.nextInt();

            switch (pkg) {
                case 'A':
                    total = getTotal( packageA, access);
                break;
                case 'B':
                    total = getTotal( packageB, access);
                    break;
                case 'C':
                    total = getTotal( packageC, access);
                    break;
            }

            System.out.printf("\nTOTAL CHARGE: $%.2f \n", total);
            System.out.println();

    }

    static void packageOffers() {
        System.out.println("An ISP (Internet Service Provider) has three different subscription packages for its customers:");
        System.out.println("==========================================================================");
        System.out.println("                              DREAM TELECOM                               ");
        System.out.println("==========================================================================");
        System.out.println("\n [  PACKAGES  ]");
        System.out.println("Package [A]: For $9.95/month, 10 hours of access are provided. Additional hours are $2/hour.");
        System.out.println("Package [B]: For $13.95/month, 20 hours of access are provided. Additional hours are $1/hour.");
        System.out.println("Package [C]: For $19.95/month, unlimited access is provided.");
    }

    private double getTotal(InternetPackage internetPackage, int consumed) {

        int ex = consumed - internetPackage.cap;

        return consumed < internetPackage.cap?
                internetPackage.price : internetPackage.excess*ex + internetPackage.price;
    }

    static class InternetPackage {

        double price;
        int cap;
        int excess;

        InternetPackage(double price, int cap, int  excess) {
            this.price = price;
            this.cap = cap;
            this.excess = excess;
        }
    }

}
