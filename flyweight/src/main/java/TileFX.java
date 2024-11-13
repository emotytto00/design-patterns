import javafx.scene.canvas.GraphicsContext;

public interface TileFX {
    char getCharacter();
    String getType();

    void render(GraphicsContext gc, int x, int y);
}
