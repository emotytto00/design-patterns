public class BridgeMain {
    public static void main(String[] args) {
        testDevice(new TV());
        testDevice(new Radio());
        testSmartDevice(new SmartTV());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
    public static void testSmartDevice(SmartTV smartDevice) {
        System.out.println("Tests with smart remote.");
        SmartRemote smartRemote = new SmartRemote(smartDevice);
        smartRemote.power();
        smartRemote.connectToWiFi();
        smartDevice.printStatus();
    }
}