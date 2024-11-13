class Wilderness extends MapFX {
    public Wilderness(int width, int height, TileGraphicFactory graphicFactory) {
        super(width, height, graphicFactory);
    }

    @Override
    protected TileFX createTile() {
        int randomTile = random.nextInt(3);
        return switch (randomTile) {
            case 1 -> new Water(graphicFactory);
            case 2 -> new Forest(graphicFactory);
            default -> new Swamp(graphicFactory);
        };
    }
}
