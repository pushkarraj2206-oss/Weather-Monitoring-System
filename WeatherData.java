import java.util.Scanner;

abstract class Sensor {

    protected String location;

    public Sensor(String location) {
        this.location = location;
    }

    public void showLocation() {
        System.out.println("Location    : " + location);
    }

    abstract void displayReport();
}

class WeatherData extends Sensor {

    private double temperature;
    private double humidity;

    static int totalReports = 0;

    public WeatherData(String location, double temperature, double humidity) {
        super(location);
        this.temperature = temperature;
        this.humidity = humidity;
        totalReports++;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getWeatherCondition() {

        if (temperature > 35)
            return "Hot";
        else if (temperature < 15)
            return "Cold";
        else
            return "Moderate";
    }

    public String checkAlert() {

        if (temperature > 40)
            return "High Temperature Alert";
        else if (humidity > 80)
            return "High Humidity Alert";
        else
            return "Weather is Normal";
    }

    @Override
    public void displayReport() {

        System.out.println("\n===== WEATHER REPORT =====");
        showLocation();
        System.out.println("Temperature : " + temperature + " °C");
        System.out.println("Humidity    : " + humidity + " %");
        System.out.println("Condition   : " + getWeatherCondition());
        System.out.println("Alert       : " + checkAlert());
        System.out.println("Total Reports Generated : " + totalReports);
        System.out.println("==========================");
    }
}

public class WeatherMonitoringSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Location: ");
            String location = sc.nextLine();

            System.out.print("Enter Temperature: ");
            double temperature = sc.nextDouble();

            System.out.print("Enter Humidity: ");
            double humidity = sc.nextDouble();

            Sensor sensor = new WeatherData(
                    location,
                    temperature,
                    humidity
            );

            sensor.displayReport();

        } catch (Exception e) {

            System.out.println("Invalid Input Entered.");

        }

        sc.close();
    }
}
