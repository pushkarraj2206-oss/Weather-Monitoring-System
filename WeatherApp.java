import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Temperature: ");
        double temp = sc.nextDouble();

        System.out.print("Enter Humidity: ");
        double hum = sc.nextDouble();

        // Create object
        WeatherData wd = new WeatherData(temp, hum);

        // Display report
        wd.displayReport();

        sc.close();
    }
}