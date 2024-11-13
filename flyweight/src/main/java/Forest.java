import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Forest implements TileFX {
    private static final String TYPE = "Forest";
    private Image graphic;

    public Forest(TileGraphicFactory graphicFactory) {
        // Get the shared graphic for Forest tile from the factory
        this.graphic = graphicFactory.getTileGraphic(TYPE);

        // Check if the graphic was not found, handle gracefully
        if (this.graphic == null) {
            System.out.println("Warning: Image for " + TYPE + " not found. Using a default image.");
            this.graphic = new Image("/default.png");  // Use a default image if needed
        }
    }

    @Override
    public char getCharacter() {
        return 'F';  // Character representation of the Forest tile
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
            System.out.println("Error: No graphic available for Forest tile at (" + x + ", " + y + ")");
        }
    }

    public void action() {
        System.out.println("You are in a forest. Watch out for bears.");
    }
}
