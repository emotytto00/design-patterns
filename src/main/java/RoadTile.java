public class RoadTile implements Tile{
    @Override
    public char getCharacter() {
        return 'R';
    }
    @Override
    public String getType() {
        return "Road";
    }
    public void action() {
        System.out.println("This is a road.");
    }
}
