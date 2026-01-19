# WeatherApi

A lightweight Spring Boot REST API that provides real-time weather information for any city worldwide. This prototype demonstrates clean architecture principles with a modular 3-layer design, using free public APIs—no API keys required.

## Overview

WeatherApi fetches current weather conditions by converting city names to geographic coordinates via Nominatim (OpenStreetMap) and retrieving weather data from Open-Meteo. The project showcases proper separation of concerns through distinct Model, Service, and Controller layers.

## Features

- **Global Coverage** - Get weather for any city worldwide
- **No API Keys Required** - Uses free public APIs (Open-Meteo & Nominatim)
- **Clean Architecture** - Modular 3-layer design (Model/Service/Controller)
- **Real-time Data** - Current weather conditions including temperature, wind speed, and general conditions
- **Lightweight** - Minimal dependencies, fast startup

## Project Structure

```
WeatherApi/
├── src/main/java/com/covianhive/WeatherApi/
│   ├── model/
│   │   └── Weather.java              # Data model for weather information
│   ├── service/
│   │   ├── WeatherService.java       # Weather data retrieval logic
│   │   └── GeoService.java           # Geocoding (city → coordinates)
│   ├── controller/
│   │   └── WeatherController.java    # REST API endpoint
│   └── WeatherApiApplication.java    # Spring Boot entry point
├── pom.xml
└── README.md
```

## Requirements

- **Java** 21 or higher
- **Maven** 4.0+
- **Environment** - Works on Linux, macOS, Windows, or Termux

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/SilasChalwe/WeatherApi.git
cd WeatherApi
```

### 2. Verify Dependencies

Ensure your `pom.xml` includes these dependencies:

```xml
<dependencies>
    <!-- Spring Boot Web Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- JSON Processing -->
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20230618</version>
    </dependency>
</dependencies>
```

### 3. Build and Run

```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Usage

### Endpoint

```
GET /api/weather/{city}
```

### Example Request

```bash
curl http://localhost:8080/api/weather/Lusaka 
```

### Example Response

```json
{
  "city": "Lusaka",
  "temperature": 21.3,
  "windSpeed": 5.1,
  "condition": "Sunny"
}
```

### Try Other Cities

```bash
# New York
curl http://localhost:8080/api/weather/kitwe

# Tokyo
curl http://localhost:8080/api/weather/luanshya 

# Paris
curl http://localhost:8080/api/weather/chingola
```

## Architecture

### Model Layer
- **Weather.java** - Encapsulates weather data structure (city, temperature, wind speed, condition)

### Service Layer
- **GeoService.java** - Converts city names to latitude/longitude using Nominatim API
- **WeatherService.java** - Fetches weather data from Open-Meteo API using coordinates

### Controller Layer
- **WeatherController.java** - Exposes REST endpoints and handles HTTP requests/responses

## Development Notes

- **Case Sensitivity** - Package names and folder structures are case-sensitive on Linux/Termux
- **No Authentication** - This is a prototype; consider adding rate limiting for production use
- **Error Handling** - Basic error handling is included; enhance as needed for production
- **Port Configuration** - Default port is 8080; change in `application.properties` if needed

## Technologies Used

- **Spring Boot** - Application framework
- **Open-Meteo API** - Free weather data provider
- **Nominatim OSM** - Free geocoding service
- **JSON** - Data interchange format

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open-source and available for educational purposes.

## Repository

[https://github.com/SilasChalwe/WeatherApi](https://github.com/SilasChalwe/WeatherApi)

---

**Built with Java and Spring Boot**
