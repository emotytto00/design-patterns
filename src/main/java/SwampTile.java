public class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }
    @Override
    public String getType() {
        return "Swamp";
    }
    public void action() {
        System.out.println("This is a swamp.");
    }
}
