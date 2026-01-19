package com.covianhive.WeatherApi.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class GeoService {

    public double[] getCoordinates(String city) {
        try {
            String url = "https://nominatim.openstreetmap.org/search?q="
                    + city.replace(" ", "%20")
                    + "&format=json&limit=1";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "JavaWeatherApp") // Required by Nominatim
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray array = new JSONArray(response.body());

            if (array.isEmpty()) return null; // City not found

            JSONObject obj = array.getJSONObject(0);
            double lat = obj.getDouble("lat");
            double lon = obj.getDouble("lon");

            return new double[]{lat, lon};

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}