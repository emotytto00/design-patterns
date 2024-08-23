public class BuildingTile implements Tile{
    @Override
    public char getCharacter() {
        return 'B';
    }
    @Override
    public String getType() {
        return "Building";
    }
    public void action() {
        System.out.println("You are in a building. You can rest and recover.");
    }
}
