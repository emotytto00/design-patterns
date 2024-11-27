import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        // Step 1: Make HTTP request and retrieve JSON
        String jsonResponse = makeHttpGetRequest(urlString);

        // Step 2: Parse JSON and extract the desired attribute
        return parseJsonForAttribute(jsonResponse, attributeName);
    }

    private String makeHttpGetRequest(String urlString) throws IOException {
        HttpURLConnection connection = null;
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read the response
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
        } catch (IOException e) {
            throw new IOException("Error occurred while making HTTP GET request: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }

    private String parseJsonForAttribute(String json, String attributeName) throws IllegalArgumentException {
        try {
            // Create a JSON parser from the string
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            // If no attributeName is provided, return the full JSON string for debugging
            if (attributeName == null || attributeName.isEmpty()) {
                return jsonObject.toJSONString();
            }

            // Return specific attribute if found
            if (jsonObject.containsKey(attributeName)) {
                return jsonObject.get(attributeName).toString();
            } else {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in the JSON response.");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Error parsing JSON response: " + e.getMessage());
        }
    }
}
