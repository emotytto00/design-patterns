import java.io.IOException;

public class JokeClient {
    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        try {
            // Fetch a random Chuck Norris joke
            String joke = apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris Joke: " + joke);

            // Fetch the full response from the foreign exchange rates API
            System.out.println("\nFetching full response for debugging...");
            String fullResponse = apiFacade.getAttributeValueFromJson("https://api.exchangerate.host/latest", "");
            System.out.println("Full JSON Response: " + fullResponse);

            // Extract base currency if possible
            String baseCurrency = apiFacade.getAttributeValueFromJson("https://api.exchangerate.host/latest", "base");
            System.out.println("Base Currency: " + baseCurrency);
        } catch (IllegalArgumentException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}