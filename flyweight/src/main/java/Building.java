import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Building implements TileFX {
    private static final String TYPE = "Building";
    private Image graphic;

    public Building(TileGraphicFactory graphicFactory) {
        // Get the shared graphic for Building from the factory
        this.graphic = graphicFactory.getTileGraphic(TYPE);

        // Optional: Check if the graphic was not found and handle the case
        if (this.graphic == null) {
            System.out.println("Warning: Image for " + TYPE + " not found. Using a default image.");
            // Optionally, use a default image if not found
            this.graphic = new Image("/default.png");  // Replace with your actual default image path
        }
    }

    @Override
    public char getCharacter() {
        return 'B';  // Character representation of the Building tile
    }

    @Override
    public String getType() {
        return TYPE;  // Type of the tile
    }

    @Override
    public void render(GraphicsContext gc, int x, int y) {
        if (graphic != null) {
            // Render the tile's graphic at the specified position (32x32 pixels per tile)
            gc.drawImage(graphic, x * 32, y * 32);
        } else {
            System.out.println("Error: No graphic available for tile at (" + x + ", " + y + ")");
        }
    }

    public void action() {
        System.out.println("You are in a building. Search for supplies.");
    }
}

