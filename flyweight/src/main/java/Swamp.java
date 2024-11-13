import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Swamp implements TileFX {
    private static final String TYPE = "Swamp";
    private Image graphic;

    public Swamp(TileGraphicFactory graphicFactory) {
        // Get the shared graphic for Swamp tile from the factory
        this.graphic = graphicFactory.getTileGraphic(TYPE);

        // Check if the graphic was not found, handle gracefully
        if (this.graphic == null) {
            System.out.println("Warning: Image for " + TYPE + " not found. Using a default image.");
            this.graphic = new Image("/default.png");  // Use a default image if needed
        }
    }

    @Override
    public char getCharacter() {
        return 'S';  // Character representation of the Swamp tile
    }

    @Override
    public String getType() {
        return TYPE;  // Type of the tile
    }

    @Override
    public void render(GraphicsContext gc, int x, int y) {
        if (graphic != null) {
            // Render the tile's graphic at the specified position (32x32 pixels)
            gc.drawImage(graphic, x * 32, y * 32);
        } else {
            System.out.println("Error: No graphic available for Swamp tile at (" + x + ", " + y + ")");
        }
    }

    public void action() {
        System.out.println("You are in a swamp. You can't move.");
    }
}
