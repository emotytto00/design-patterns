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
        String imagePath = null;

        switch (type) {
            case "Road":
                imagePath = "road.png";
                break;
            case "Forest":
                imagePath = "forest.png";
                break;
            case "Building":
                imagePath = "building.png";
                break;
            case "Swamp":
                imagePath = "swamp.png";
                break;
            case "Water":
                imagePath = "water.png";
                break;
            default:
                System.out.println("Unknown tile type: " + type);
                return null;
        }

        try {
            Image image = new Image(TileGraphicFactory.class.getClassLoader().getResourceAsStream(imagePath));
            if (image == null || image.isError()) {
                System.out.println("Error loading image for type: " + type + " from path: " + imagePath);
                return null;
            }
            return image;
        } catch (Exception e) {
            System.out.println("Exception loading image for type: " + type + " from path: " + imagePath);
            e.printStackTrace();
            return null;
        }
    }
}
