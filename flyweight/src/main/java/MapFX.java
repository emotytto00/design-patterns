import javafx.scene.canvas.GraphicsContext;
import java.util.Random;

public abstract class MapFX {
    protected int width;
    protected int height;
    protected TileFX[][] tiles;
    protected Random random = new Random();
    protected TileGraphicFactory graphicFactory;

    public MapFX(int width, int height, TileGraphicFactory graphicFactory) {
        this.width = width;
        this.height = height;
        this.tiles = new TileFX[height][width];
        this.graphicFactory = graphicFactory;
        generateMap();
    }


    protected abstract TileFX createTile();

    private void generateMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public void render(GraphicsContext gc) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j].render(gc, j, i);
            }
        }
    }
}
