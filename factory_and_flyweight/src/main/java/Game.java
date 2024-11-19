import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Game extends Application {

    private Map map;
    int width;
    int height;


    @Override
    public void start(Stage primaryStage) {
        System.out.println("Enter 1 for City Map or 2 for Wilderness Map");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("Enter width of map");
        width = scanner.nextInt();
        System.out.println("Enter height of map");
        height = scanner.nextInt();
        map = createMap(choice, width, height);

        Canvas canvas = new Canvas(width * 32, height * 32);

        map.render(canvas);

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, width * 32, height * 32);

        primaryStage.setTitle("Map");
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
