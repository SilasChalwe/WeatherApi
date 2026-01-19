WeatherApi

A simple Spring Boot Weather API prototype built in Java. It fetches weather data for any city using Open-Meteo (free, no API key required) and converts city names to coordinates using Nominatim OpenStreetMap.

This project demonstrates a 3-module design:

1. Model – defines data structures (Weather class).


2. Service – contains business logic for fetching and processing weather (WeatherService and GeoService).


3. Controller – exposes a REST API endpoint (WeatherController).




---

Features

Fetch current weather for a city.

Converts city names to latitude and longitude using Nominatim.

Uses Open-Meteo API for real-time weather data.

Fully modular Spring Boot project structure.



---

Project Structure

WeatherApi/
├── src/main/java/com/covianhive/WeatherApi/
│   ├── model/
│   │   └── Weather.java
│   ├── service/
│   │   ├── WeatherService.java
│   │   └── GeoService.java
│   ├── controller/
│   │   └── WeatherController.java
│   └── WeatherApiApplication.java
├── pom.xml
└── README.md


---

Requirements

Java 21

Maven 4+

Termux (or any Linux/Mac/Windows environment with Java & Maven)



---

Setup

1. Clone the project:



git clone <your-repo-url>
cd WeatherApi

2. Ensure pom.xml includes dependencies:



<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- JSON parsing -->
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20230618</version>
    </dependency>
</dependencies>

3. Compile and run:



mvn clean spring-boot:run


---

Usage

Once the application is running (default port 8080), you can access the API:

GET http://localhost:8080/api/weather/{city}

Example:

curl http://localhost:8080/api/weather/London

Sample Response:

{
  "city": "London",
  "temperature": 21.3,
  "windSpeed": 5.1,
  "condition": "Sunny"
}


---

Notes

Make sure your package declarations match folder names exactly, especially if using Termux or Linux (case-sensitive).

The project demonstrates clean modular design with Model, Service, and Controller layers.



---

License

This project is open-source and free to use for educational purposes.
