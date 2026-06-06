import java.io.FileWriter;
import java.io.IOException;

public class WeatherData {

    private double temperature;
    private double humidity;

    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public String checkAlert() {
        return checkAlert(40, 10, 80);
    }

    public String checkAlert(double highTemp,
                             double lowTemp,
                             double highHumidity) {

        StringBuilder alert = new StringBuilder();

        if (temperature > highTemp)
            alert.append("High Temperature Alert\n");

        if (temperature < lowTemp)
            alert.append("Low Temperature Alert\n");

        if (humidity > highHumidity)
            alert.append("High Humidity Alert\n");

        if (alert.length() == 0)
            alert.append("Weather is Normal");

        return alert.toString();
    }

    public String getWeatherCondition() {

        if (temperature > 35)
            return "Hot";

        else if (temperature < 15)
            return "Cold";

        else
            return "Moderate";
    }

    public void displayReport() {

        System.out.println("\n========== WEATHER REPORT ==========");
        System.out.println("Temperature      : " + temperature + " °C");
        System.out.println("Humidity         : " + humidity + " %");
        System.out.println("Condition        : " + getWeatherCondition());
        System.out.println("Alert            : " + checkAlert());
        System.out.println("====================================");
    }

    public void saveReport() {

        try {

            FileWriter writer =
                    new FileWriter("WeatherReport.txt", true);

            writer.write("\n========== WEATHER REPORT ==========\n");
            writer.write("Temperature : " + temperature + " °C\n");
            writer.write("Humidity    : " + humidity + " %\n");
            writer.write("Condition   : " + getWeatherCondition() + "\n");
            writer.write("Alert       : " + checkAlert() + "\n");
            writer.write("====================================\n");

            writer.close();

            System.out.println("Report saved successfully!");

        } catch (IOException e) {

            System.out.println("Error while saving file.");
        }
    }
}
