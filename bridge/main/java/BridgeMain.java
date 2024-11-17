public class BridgeMain {
    public static void main(String[] args) {
        Device smartTv = new SmartTV();

        SmartRemote smartRemote = new SmartRemote(smartTv);

        smartRemote.power();
        smartRemote.volumeUp();
        smartRemote.channelUp();

        smartRemote.connectToWiFi();
        smartRemote.browse();
        smartRemote.watchNetflix();
        smartRemote.playGames();

        smartTv.printStatus();
    }
}
