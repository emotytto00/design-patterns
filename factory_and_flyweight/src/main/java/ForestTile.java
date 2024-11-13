public class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }
    @Override
    public String getType() {
        return "Forest";
    }
    public void action() {
        System.out.println("This is a forest.");
    }

}
