class City extends MapFX {
    public City(int width, int height, TileGraphicFactory graphicFactory) {
        super(width, height, graphicFactory);
    }

    @Override
    protected TileFX createTile() {
        int randomTile = random.nextInt(3);
        return switch (randomTile) {
            case 1 -> new Forest(graphicFactory);
            case 2 -> new Building(graphicFactory);
            default -> new Road(graphicFactory);
        };
    }
}
