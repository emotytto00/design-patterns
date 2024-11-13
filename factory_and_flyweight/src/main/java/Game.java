import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {

    private Map map;

    @Override
    public void start(Stage primaryStage) {
        // Initialize map
        int width = 10;  // You can ask the user for width and height like before
        int height = 10;
        map = createMap(1, width, height);  // Example: CityMap, can be selected by user

        // Create a Canvas to render the map
        Canvas canvas = new Canvas(width * 32, height * 32);  // Assuming each tile is 32x32 pixels

        // Render the map
        map.render(canvas);

        // Set up the JavaFX scene
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, width * 32, height * 32);

        primaryStage.setTitle("RPG Map");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Map createMap(int choice, int width, int height) {
        return switch (choice) {
            case 1 -> new CityMap(width, height);
            case 2 -> new WildernessMap(width, height);
            default -> null;
        };
    }
}
