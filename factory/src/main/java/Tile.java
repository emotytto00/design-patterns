import javafx.scene.canvas.GraphicsContext;

public interface Tile {
    char getCharacter();
    String getType();

    void render(GraphicsContext gc, int x, int y);
}