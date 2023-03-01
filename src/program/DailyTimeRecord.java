package program;

import jdk.jfr.Timespan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DailyTimeRecord implements SampleProgram {

    public DailyTimeRecord() {
        /**
         * A program that will let a user input 3 EMPLOYEE NAMES and HOURS WORKED.
         * First, let the user input the name of the employee then store it in an array
         * named EMPLOYEES. Secondly, let the user input total hours worked in minutes and
         * store it in an array named TIME. Lastly, determine the status of an employee's
         * working hours.
         *
         * TIME WORKED { 480 = NORMAL }
         * TIME WORKED { > 480 = OVERTIME }
         * TIME WORKED { < 480 = UNDERTIME }
         *
         * Sample Input:
         *      Juan - 480
         *      Maria - 500
         *      Pedro - 400
         *
         * */
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String[] empNames = new String[3];
        int[] hoursWorked = new int[3];

        for (int i = 0; i < empNames.length; i++) {
            System.out.printf("NAME OF EMPLOYEE #%d: ", i+1);
            empNames[i] = scanner.next();
            System.out.print("TOTAL HOURS WORKED: ");
            hoursWorked[i] = Integer.parseInt(scanner.next());
            System.out.println();
        }

        output(empNames, hoursWorked);
    }

    private void output(String[] emps, int[] hour) {
        System.out.printf("%-15s %6s %10s\n", "EMPLOYEES", "TIME", "STATUS");
        for (int i = 0; i < emps.length; i++) {
            System.out.printf("%-15s %6s %10s\n", emps[i],
                    getTime(getHour(hour[i]), getMinutes(hour[i])),
                    getStatus(hour[i]));
        }
    }

    int getHour(int hour) {
       return hour/60;
    }

    int getMinutes(int hour) {
        return hour%60;
    }

    String getTime(int h, int  m) {
       return h+":"+m;
    }

    String getStatus(int hoursWorked) {
        String[] STATUS = {"UNDERTIME", "OVERTIME", "NORMAL"};
        final int normalHour = 480;
            if (hoursWorked < normalHour) {
                return STATUS[0];
            } else if (hoursWorked > normalHour) {
                return STATUS[2];
            } else return STATUS[1];
    }
}
