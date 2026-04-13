class WeatherData {
    private double temperature;
    private double humidity;

    
    public WeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    
    public String checkAlert() {
        String alert = "";

        if (temperature > 40) {
            alert += "High Temperature Alert ";
        }
        if (temperature < 10) {
            alert += "Low Temperature Alert ";
        }
        if (humidity > 80) {
            alert += "High Humidity Alert ";
        }

        if (alert.equals("")) {
            alert = "Weather is Normal";
        }

        return alert;
    }

    
    public void displayReport() {
        System.out.println("\n--- Weather Report ---");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Alert: " + checkAlert());
    }
}
