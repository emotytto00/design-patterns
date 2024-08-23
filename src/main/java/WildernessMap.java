class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int randomTile = random.nextInt(3); // 0: swamp, 1: water, 2: forest
        return switch (randomTile) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> new SwampTile(); // Default to swamp tile
        };
    }
}