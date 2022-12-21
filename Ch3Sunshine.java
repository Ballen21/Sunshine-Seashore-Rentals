import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.time.LocalDate;
public class Ch3Sunshine {
    static Scanner inputDevice;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        init();
        String iDate = getDate();
        String formattedDate = formatDate(iDate);
        double iMin = getMin();
        double iExtra = getExtra(iMin);
        double iHour = getHour(iMin, iExtra);
        double iRent = calcs(iHour, iExtra);
        output(iHour, iExtra, iRent, formattedDate);
        DecimalFormat df = new DecimalFormat("###,###");
    }

    private static String formatDate(String enteredDate) {
        String enteredPattern = "MM/dd/yyyy";
        String newPattern = "MMMM dd, yyyy";
        String formattedDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat(enteredPattern);
        try {
            Date d = sdf.parse(enteredDate);
            sdf.applyPattern(newPattern);
            String newDateString = sdf.format(d);
            System.out.println("Rental date formatted: " + newDateString);
            formattedDate = newDateString;


        } catch (ParseException pe) {
            System.out.println("Invalid date entered, defaulted to todays date");
            LocalDate today = LocalDate.now();
        }
        return formattedDate;
    }

    private static String getDate(){
        String enteredDate;
        System.out.print("Enter a date (MM/DD/YYYY format): ");
        enteredDate = scanner.nextLine();
        return enteredDate;
    }
    private static double getHour(double iMin, double iExtra){
        double iHour = (iMin - iExtra) / 60 ;
        return iHour;


    }

    private static double calcs(double iHour, double iExtra){
        double iRent = (40 * iHour + iExtra);
        return iRent;
    }

    private static double getExtra(double iMin){
        double iExtra = iMin % 60;
        return iExtra;

    }

    public static void output(double iHour, double iExtra, double iRent, String formattedDate) {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yy");
        System.out.println(CompanyMotto.getMotto());
        System.out.println("Rental Date: " + formattedDate);
        System.out.format("%-25s%-25s%-25s\n", "Hours", "Additional Minutes", "Rental Cost");
        DecimalFormat df = new DecimalFormat("###,###.00");
        System.out.format("%-25s%-25s$%-25s\n", iHour, iExtra, iRent);
        System.out.format("%-25s%-25s$%-25s\n", 3, 10, 130);
        System.out.format("%-25s%-25s$%-25s\n", 1, 25, 65);
    }
    private static double getMin(){
        double iMin = 0;
        System.out.println("Enter minutes for rental: ");
        String iData = inputDevice.nextLine();
        try{
            iMin = Double.parseDouble(iData);
        }
        catch (NullPointerException npe){
            System.out.println("Invalid - must be a value, defaulted 60");
            iMin = 60;
        }
        catch (Exception e){
            System.out.println("Invalid - must be numeric, defaulted 60");
            iMin = 60;
        }
        return iMin;

    }
    private static void init(){
        inputDevice = new Scanner(System.in);
    }


}