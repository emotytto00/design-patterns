public class SmartRemote extends BasicRemote {
    public SmartRemote(Device device) {
        super.device = device;
    }

    public void connectToWiFi() {
        System.out.println("Remote: connect to WiFi");
        ((SmartTV) device).connectToWiFi();
    }

    public void browse() {
        System.out.println("Remote: browse the internet");
        ((SmartTV) device).browse();
    }

    public void watchNetflix() {
        System.out.println("Remote: watch Netflix");
        ((SmartTV) device).watchNetflix();
    }

    public void playGames() {
        System.out.println("Remote: play games");
        ((SmartTV) device).playGames();
    }
}
