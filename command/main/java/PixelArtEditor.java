import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private static final int GRID_SIZE = 8;
    private int cursorX = 0;
    private int cursorY = 0;
    private boolean[][] grid = new boolean[GRID_SIZE][GRID_SIZE];
    private Rectangle[][] cells = new Rectangle[GRID_SIZE][GRID_SIZE];

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                Rectangle cell = new Rectangle(30, 30);
                cell.setFill(Color.WHITE);
                cell.setStroke(Color.BLACK);
                gridPane.add(cell, x, y);
                cells[x][y] = cell;
            }
        }

        updateCursor();

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.show();

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> new MoveCursorUpCommand(this).execute();
                case DOWN -> new MoveCursorDownCommand(this).execute();
                case LEFT -> new MoveCursorLeftCommand(this).execute();
                case RIGHT -> new MoveCursorRightCommand(this).execute();
                case SPACE -> new TogglePixelCommand(this).execute();
                case ENTER -> new GenerateCodeCommand(this).execute();
            }
        });
    }

    public void moveCursorUp() {
        if (cursorY > 0) cursorY--;
        updateCursor();
    }

    public void moveCursorDown() {
        if (cursorY < GRID_SIZE - 1) cursorY++;
        updateCursor();
    }

    public void moveCursorLeft() {
        if (cursorX > 0) cursorX--;
        updateCursor();
    }

    public void moveCursorRight() {
        if (cursorX < GRID_SIZE - 1) cursorX++;
        updateCursor();
    }

    public void togglePixel() {
        grid[cursorX][cursorY] = !grid[cursorX][cursorY];
        updateCell(cursorX, cursorY);
    }

    public void generateCode() {
        System.out.println("int[][] pixelArt = {");
        for (int y = 0; y < GRID_SIZE; y++) {
            System.out.print("    {");
            for (int x = 0; x < GRID_SIZE; x++) {
                System.out.print(grid[x][y] ? "1" : "0");
                if (x < GRID_SIZE - 1) System.out.print(", ");
            }
            System.out.println("},");
        }
        System.out.println("};");
    }

    private void updateCursor() {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                cells[x][y].setStroke(Color.BLACK);
            }
        }
        cells[cursorX][cursorY].setStroke(Color.RED);
    }

    private void updateCell(int x, int y) {
        cells[x][y].setFill(grid[x][y] ? Color.BLACK : Color.WHITE);
    }
}
