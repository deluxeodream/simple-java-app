package program;

public class SampleProgramFactory {


    public static SampleProgram getInstance(String req) {

        switch (req) {
            case "Internet Service Package Monthly Bill Computation":
                return new ISPBillComputation();
            case "Weather Bulletin":
                return new WeatherBulletin();
            case "Daily Time Record":
                return new DailyTimeRecord();
            case "Simple Employee Salary Worksheet":
                return new EmployeeSalaryWorksheet();
            default:
                return new SimpleOrderingApp();
        }
    }
}
