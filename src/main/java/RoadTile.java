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
        System.out.println("You are on a road. You can move.");
    }
}
