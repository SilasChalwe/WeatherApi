// package com.covianhive.WeatherApi.model;

// public class Weather {
//     private String city;
//     private double temperature;
//     private double windSpeed;
//     private String condition;

//     public Weather(String city, double temperature, double windSpeed, String condition) {
//         this.city = city;
//         this.temperature = temperature;
//         this.windSpeed = windSpeed;
//         this.condition = condition;
//     }
//     public String getCity() { return city; }
//     public double getTemperature() { return temperature; }
//     public double getWindSpeed() { return windSpeed; }
//     public String getCondition() { return condition; }
// }

package com.covianhive.WeatherApi.model;

public class Weather {
    private String city;
    private String temperature; // now includes °C
    private String windSpeed;   // now includes km/h
    private String condition;

    public Weather(String city, double temperature, double windSpeed, String condition) {
        this.city = city;
        this.temperature = temperature + " °C";  // add unit
        this.windSpeed = windSpeed + " km/h";    // add unit
        this.condition = condition;
    }

    // Public getters (required for JSON serialization)
    public String getCity() { return city; }
    public String getTemperature() { return temperature; }
    public String getWindSpeed() { return windSpeed; }
    public String getCondition() { return condition; }
}