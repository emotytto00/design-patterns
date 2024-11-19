class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int randomTile = random.nextInt(3);
        return switch (randomTile) {
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> new SwampTile();
        };
    }
}