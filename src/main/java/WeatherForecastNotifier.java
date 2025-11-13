import static spark.Spark.*;
import java.util.*;

public class WeatherForecastNotifier {
    public static void main(String[] args) {
        // Set the port for the server
        port(4567);

        // Serve static files from the "web" folder
        staticFiles.externalLocation("web");

        // Mock weather data
        Map<String, String> weatherData = new HashMap<>();
        weatherData.put("city", "Springfield");
        weatherData.put("temperature", "22°C");
        weatherData.put("condition", "Partly Cloudy");
        weatherData.put("humidity", "60%");
        weatherData.put("wind", "15 km/h");

        // Define route for "/api/weather"
        get("/api/weather", (req, res) -> {
            res.type("application/json");
            return "{"
                    + "\"city\": \"" + weatherData.get("city") + "\","
                    + "\"temperature\": \"" + weatherData.get("temperature") + "\","
                    + "\"condition\": \"" + weatherData.get("condition") + "\","
                    + "\"humidity\": \"" + weatherData.get("humidity") + "\","
                    + "\"wind\": \"" + weatherData.get("wind") + "\""
                    + "}";
        });

        System.out.println("🚀 Weather Forecast Notifier running on http://localhost:4567");
    }
}
