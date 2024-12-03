import java.io.IOException;

public class JokeClient {
    public static void main(String[] args) {
        ApiFacade apiFacade = new ApiFacade();

        try {
            String joke = apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris Joke: " + joke);

            String fxApiUrl = "https://api.fxratesapi.com/latest";
            String baseCurrency = apiFacade.getAttributeValueFromJson(fxApiUrl, "base");
            System.out.println("Base Currency: " + baseCurrency);

        } catch (IllegalArgumentException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
