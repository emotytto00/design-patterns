import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select map type: ");
        System.out.println("1. City");
        System.out.println("2. Wilderness");
        int mapType = scanner.nextInt();

        System.out.println("Enter map width: ");
        int width = scanner.nextInt();

        System.out.println("Enter map height: ");
        int height = scanner.nextInt();

        Map map = createMap(mapType, width, height);
        if (map != null) {
            map.display();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }

        scanner.close();
    }

    public static Map createMap(int choice, int width, int height) {
        return switch (choice) {
            case 1 -> new CityMap(width, height);
            case 2 -> new WildernessMap(width, height);
            default -> null;
        };
    }
}