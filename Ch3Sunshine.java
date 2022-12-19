import java.util.Scanner;
import java.text.DecimalFormat;
public class Ch3Sunshine {
    static Scanner inputDevice;

    public static void main(String[] args) {
        init();
        double iMin = getMin();
        double iExtra = getExtra(iMin);
        double iHour = getHour(iMin, iExtra);
        double iRent = calcs(iHour, iExtra);
        output(iHour, iExtra, iRent);
        DecimalFormat df = new DecimalFormat("###,###");



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

    public static void output(double iHour, double iExtra, double iRent) {
        System.out.println(CompanyMotto.getMotto());
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
