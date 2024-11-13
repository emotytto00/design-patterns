import javafx.scene.image.Image;
import java.util.Objects;

public class TileGraphicFactory {
    public Image getTileGraphic(String tileType) {
        String imagePath = switch (tileType) {
            case "Forest" -> "/tree.png";
            case "Water" -> "/water.png";
            case "Road" -> "/road.png";
            case "Building" -> "/building.png";
            case "Swamp" -> "/swamp.png";
            default -> "/default.png";
        };
        String resourcePath = Objects.requireNonNull(getClass().getResource(imagePath), "Resource not found: " + imagePath).toExternalForm();
        return new Image(resourcePath);
    }
}