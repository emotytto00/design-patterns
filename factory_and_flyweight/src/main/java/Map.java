import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Random;

public abstract class Map {
    protected int width;
    protected int height;
    protected Tile[][] tiles;
    protected Random random = new Random();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
        generateMap();
    }

    protected abstract Tile createTile();

    private void generateMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    public void render(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int tileSize = 32;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Image tileImage = TileGraphicFactory.getTileGraphic(tiles[i][j].getType());
                if (tileImage != null) {
                    gc.drawImage(tileImage, j * tileSize, i * tileSize, tileSize, tileSize);
                }
            }
        }
    }
}

