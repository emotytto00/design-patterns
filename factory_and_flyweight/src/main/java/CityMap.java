class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int randomTile = random.nextInt(3);
        return switch (randomTile) {
            case 1 -> new RoadTile();
            case 2 -> new BuildingTile();
            default -> new ForestTile();
        };
    }
}