package program;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSalaryWorksheet implements SampleProgram {

    public EmployeeSalaryWorksheet() {
        /**
         * A program that would enable user to create a monthly salary worksheet.
         * The program would require the user to input the following:
         *
         * 1. Employee Name (Maximum of 15 characters long)
         * 2. Employee Number (10 characters long)
         * 3. Employee Salary Grade
         * 4. Number of hours worked (should be able to accept floating point).
         *
         * The program will display Employee Name, Employee Number, Undertime or Overtime and Salary.
         * Imposed minimum of work hours every month is 160. $10/hr fine for undertime and
         * $20/hr incentive is awarded for every hour above the minimum for overtime.
         *
         *      GRADE       RATE
         *      A           $50/hr
         *      B           $35/hr
         *      C           $25/hr
         *
         * The program will ask for three inputs.
         *
         * */
    }

    @Override
    public void show() {
        final int MAX_ENTRIES = 3;
        final int MAX_NAME_CHARS = 15;
        final int MAX_EMPNUM_CHARS = 10;
        Scanner scan = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        String name, empNum;
        char salaryGrade;
        int workHours;

        System.out.println("\n");
        System.out.println("Good Day! Please key in all your entries!");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < MAX_ENTRIES; i++) {
            do {
              name = getName();
            } while (isNotValidLenght(name, MAX_NAME_CHARS));
            do {
              System.out.print("EMPLOYEE NUMBER: ");
              empNum = scan.next();
            } while (isNotValidLenght(empNum, MAX_EMPNUM_CHARS));
            do {
              System.out.print("EMPLOYEE SALARY GRADE: ");
              salaryGrade = scan.next().toUpperCase().charAt(0);
            } while (isNotValidSG(salaryGrade));
            do {
                System.out.print("HOURS WORKED: ");
                workHours = Integer.parseInt(scan.next());
            } while (isNotValidWH(workHours));

          employees.add(new Employee(name, empNum, salaryGrade, workHours));
          System.out.println("\n");

            System.out.printf("|%15s | %15s | %10s | %10s |\n",
                    "NAME", "NUMBER", "TIME", "SALARY");
            System.out.println("--------------------------------------------------------------");
            System.out.printf("|%15s | %15s | %10s | %10s |\n",
                    employees.get(i).getName(),
                    employees.get(i).getNumber(),
                    employees.get(i).getTime(),
                    employees.get(i).getIncome());

            System.out.println();

        }

        output(employees);

    }

    static void output(List<Employee> employees) {
        System.out.println("\n");
        System.out.println("==============================================================");
        System.out.printf("|%15s | %15s | %10s | %10s |\n",
                "NAME", "NUMBER", "TIME", "SALARY");
        System.out.println("==============================================================");
        for (Employee e: employees) {
            System.out.printf("|%15s | %15s | %10s | %10s |\n",
                    e.getName(),
                    e.getNumber(),
                    e.getTime(),
                    e.getIncome());
        }
        System.out.println("--------------------------------------------------------------");
    }


    static boolean isNotValidLenght(final String nm, int max) {
        boolean isNotValid = nm.length() > max;
        if (isNotValid) System.out.println("INVALID INPUT!, The characters must not exceed "+ max);
        return isNotValid;
    }

    static boolean isNotValidSG(char in) {
        boolean isNotValid = in > 'C';
        if (isNotValid) System.out.println("INVALID INPUT!, Only available Grade is [A, B, C].");
        return isNotValid;
    }

    static boolean isNotValidWH(int wh) {
        boolean isNotValid = wh < 0;
        if (isNotValid) System.out.println("INVALID INPUT!, You can't have negative inputs.");
        return isNotValid;
    }

    static String getName(){
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("EMPLOYEE NAME: ");
        System.out.flush();

        try{
            return stdin.readLine();
        } catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }


    static class Employee {

        String name;
        String number;
        double hoursWorked;
        char salaryGrade;
        double salaryRate;
        final int MIN_WH = 160;

        public Employee(String name, String number, char salaryGrade, double hoursWorked) {
            this.name = name;
            this.number = number;
            this.hoursWorked = hoursWorked;
            this.salaryGrade = salaryGrade;
            this.salaryRate = getSalaryRate();
        }

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public double getSalaryRate() {

            switch (salaryGrade) {
                case 'A':
                    salaryRate = 50;
                    break;
                case 'B':
                    salaryRate = 35;
                    break;
                case 'C':
                    salaryRate = 25;
                    break;
            }
            return salaryRate;
        }

        public String getTime() {
            List<String> time = List.of("UNDERTIME", "NORMAL", "OVERTIME");
            if (hoursWorked < MIN_WH)
                return time.get(0);
            else if (hoursWorked == MIN_WH)
                return time.get(1);
            else
                return time.get(2);
        }

        public double getSalary() {
            final double incentive;
            final double fine;

            if (getTime().equals("UNDERTIME")) {
                fine = (MIN_WH - hoursWorked)*10;
                return (salaryRate * hoursWorked) - fine;
            } else if (getTime().equals("OVERTIME")){
                incentive = (hoursWorked -MIN_WH)*20;
                return (salaryRate * hoursWorked) + incentive;
            } else return salaryRate * hoursWorked;
        }

        public String getIncome() {
            return String.format("$%,.2f", getSalary());
        }
    }
}
