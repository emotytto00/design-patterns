class CityMap extends Map {
    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int randomTile = random.nextInt(3); // 0: road, 1: forest, 2: building
        return switch (randomTile) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            case 2 -> new BuildingTile();
            default -> new RoadTile(); // Default to road tile
        };
    }
}