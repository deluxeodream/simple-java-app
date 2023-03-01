package program;

import java.util.Scanner;

public class WeatherBulletin implements SampleProgram {

    public WeatherBulletin() {
        /**
         * A program that will let a user input 3 CITY NAMES and TEMPERATURES IN CELSIUS.
         * First, let the user input name of the city then store it in an array named CITIES.
         * Secondly, let the user input the temperature of the city in Celsius convert it to
         * Fahrenheit and store it in an array named TEMP. Lastly, determine the relative
         * weather status of each city using the table below and store it in array named STATUS.
         *
         *                                                                        F = (Cx9/5) + 32;
         *
         *  Temp in Fahrenheit < 50.0 = COLD;
         *  Temp in Fahrenheit 50.0 - 77.0 = FAIR;
         *  Temp in Fahrenheit > 77.0 = WARM;
         *
         *  - CITY NAMES <15 chars, left aligned>
         *  - TEMP IN FAHRENHEIT <6 chars, right aligned, 2 decimal points>
         *  - STATUS <6 chars, right aligned>
         *
         *   >> SAMPLE INPUTS:
         *      MANILA: 30.7
         *      SYDNEY: 12.4
         *      DUBLIN: -2.1
         *
         * */
    }

    @Override
    public void show() {

        Scanner scanner = new Scanner(System.in);
        String[] cityNames = new String[3];
        double[] temperature = new double[3];

        for (int i = 0; i < cityNames.length; i++) {
            System.out.println();
            System.out.printf("NAME OF CITY #%d: ", i+1);
            cityNames[i] = scanner.next();
            System.out.print("TEMPERATURE <IN CELSIUS>: ");
            temperature[i] = scanner.nextDouble();
            System.out.println();
        }

       output(cityNames, temperature);
    }

    private void output(String[] cities, double[] temp) {

        System.out.printf("%-15s%6s  %6s", "CITY NAMES", "TEMP", "STATUS \n");
        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%-15s %-6.2f %6s \n",
                    cities[i], getTempInFahrenheit(temp[i]), getStatus(getTempInFahrenheit(temp[i])));
        }
        System.out.println();

    }

    private double getTempInFahrenheit(double tempInCelsius) {
        return (tempInCelsius * 9/5) + 32;
    }

    static String getStatus(double tempInFahrenheit) {
        String[] STATUS = {"COLD", "FAIR", "WARM"};
        double[] tempBreakpoints = {50, 77};

        if (tempInFahrenheit < tempBreakpoints[0]) {
            return STATUS[0];
        } else if (tempInFahrenheit > tempBreakpoints[1]) {
            return STATUS[2];
        } else
            return STATUS[1];
    }


}
