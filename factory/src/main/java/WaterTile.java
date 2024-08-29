public class WaterTile implements Tile{
    @Override
    public char getCharacter() {
        return 'W';
    }
    @Override
    public String getType() {
        return "Water";
    }
    public void action() {
        System.out.println("You can't swim, too bad.");
    }
}
