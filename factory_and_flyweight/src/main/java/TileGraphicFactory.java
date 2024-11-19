import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TileGraphicFactory {
    private static final Map<String, Image> tileGraphics = new HashMap<>();

    public static Image getTileGraphic(String type) {
        return tileGraphics.computeIfAbsent(type, TileGraphicFactory::loadImageForTile);
    }

    private static Image loadImageForTile(String type) {
        String imagePath = switch (type) {
            case "Road" -> "road.png";
            case "Forest" -> "forest.png";
            case "Building" -> "building.png";
            case "Swamp" -> "swamp.png";
            case "Water" -> "water.png";
            default -> null;
        };

        if (imagePath != null) {
            return new Image(Objects.requireNonNull(TileGraphicFactory.class.getClassLoader().getResourceAsStream(imagePath)));
        }
        return null;
    }
}

