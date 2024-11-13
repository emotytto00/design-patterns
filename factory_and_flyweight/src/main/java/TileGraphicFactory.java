import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, Image> tileGraphics = new HashMap<>();

    public static Image getTileGraphic(String type) {
        if (!tileGraphics.containsKey(type)) {
            tileGraphics.put(type, loadImageForTile(type));
        }
        return tileGraphics.get(type);
    }

    private static Image loadImageForTile(String type) {
        switch (type) {
            case "Road":
                return new Image("/road.png");
            case "Forest":
                return new Image("/forest.png");
            case "Building":
                return new Image("/building.png");
            case "Swamp":
                return new Image("/swamp.png");
            case "Water":
                return new Image("/water.png");
            default:
                return null;
        }
    }
}
