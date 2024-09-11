import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter("Dovahkiin");
        Scanner scanner = new Scanner(System.in);
        String action;

        while (!(character.getState() instanceof GodState)) {
            character.displayStatus();
            System.out.println("Available actions: train, meditate, fight");
            System.out.print("Enter action: ");
            action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid action. You fail.");
            }
            System.out.println();
        }

        System.out.println("Congratulations! " + character.getName() + " has become the ultimate being.");
    }
}
