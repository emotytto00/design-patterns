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
        String jsonResponse = fetchJson(urlString);

        return parseJson(jsonResponse, attributeName);
    }

    private String fetchJson(String urlString) throws IOException {
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            if (connection.getResponseCode() != 200) {
                throw new IOException("HTTP error code: " + connection.getResponseCode());
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }

    private String parseJson(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);

            if (attributeName.isEmpty()) {
                return jsonObject.toJSONString();
            }

            if (jsonObject.containsKey(attributeName)) {
                return jsonObject.get(attributeName).toString();
            } else {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found.");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Error parsing JSON: " + e.getMessage());
        }
    }
}

