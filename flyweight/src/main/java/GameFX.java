import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameFX extends Application {

    private static final int TILE_SIZE = 32;
    private int mapWidth;
    private int mapHeight;
    private TileGraphicFactory graphicFactory;

    // No-argument constructor required by JavaFX
    public GameFX() {
        // You can initialize default values here if necessary
        this.mapWidth = 10;  // Default value
        this.mapHeight = 10; // Default value
        this.graphicFactory = new TileGraphicFactory();  // Default value
    }

    @Override
    public void start(Stage primaryStage) {
        // You can now set your map dimensions and graphic factory within start()
        MapFX map = createMap(1, mapWidth, mapHeight, graphicFactory);  // Example: CityMap

        // Create the canvas and GraphicsContext for rendering
        Canvas canvas = new Canvas(mapWidth * TILE_SIZE, mapHeight * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Render the map
        map.render(gc);

        // Set up the scene and stage
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, mapWidth * TILE_SIZE, mapHeight * TILE_SIZE);

        primaryStage.setTitle("RPG Map with Flyweight Rendering");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create the map based on the selection
    public MapFX createMap(int choice, int width, int height, TileGraphicFactory graphicFactory) {
        return switch (choice) {
            case 1 -> new City(width, height, graphicFactory);
            case 2 -> new Wilderness(width, height, graphicFactory);
            default -> null;
        };
    }

    // Setters if you want to change map dimensions and graphic factory after initialization
    public void setMapDimensions(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public void setTileGraphicFactory(TileGraphicFactory graphicFactory) {
        this.graphicFactory = graphicFactory;
    }
}
