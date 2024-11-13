import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Water implements TileFX {
    private static final String TYPE = "Water";
    private Image graphic;

    public Water(TileGraphicFactory graphicFactory) {
        // Get the shared graphic for Water tile from the factory
        this.graphic = graphicFactory.getTileGraphic(TYPE);

        // Check if the graphic was not found, handle gracefully
        if (this.graphic == null) {
            System.out.println("Warning: Image for " + TYPE + " not found. Using a default image.");
            this.graphic = new Image("/default.png");  // Use a default image if needed
        }
    }

    @Override
    public char getCharacter() {
        return 'W';  // Character representation of the Water tile
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
            System.out.println("Error: No graphic available for Water tile at (" + x + ", " + y + ")");
        }
    }

    public void action() {
        System.out.println("You can't swim, too bad.");
    }
}

