import java.util.Scanner;

public class PrototypeMain {
    public static void main(String[] args) {
        Recommendation rec1 = new Recommendation("Spooky book fans");
        rec1.addBook(new Book("Junji Ito", "Uzumaki", "Horror", 1999));
        rec1.addBook(new Book("Junji Ito", "Tomie", "Horror", 1987));

        Recommendation rec2 = new Recommendation("Nerdy people");
        rec2.addBook(new Book("Isaac Asimov", "Foundation", "Scifi", 1951));
        rec2.addBook(new Book("J.R.R. Tolkien", "The Lord of the Rings", "Fantasy", 1954));

        Recommendation rec3 = rec1.clone();
        rec3.setTargetAudience("Younger spooky fans");
        rec3.addBook(new Book("R. L. Stine", "Welcome to dead house", "Horror", 1992));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBook Recommendation System");
            System.out.println("1. View recommendation for Spooky Book Fans");
            System.out.println("2. View recommendation for Nerdy People");
            System.out.println("3. View modified recommendation for Younger Spooky Fans");
            System.out.println("4. Clone and modify existing recommendation");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(rec1);
                    break;
                case 2:
                    System.out.println(rec2);
                    break;
                case 3:
                    System.out.println(rec3);
                    break;
                case 4:
                    System.out.println("Cloning which recommendation? (1 for Teens, 2 for Sci-Fi Lovers)");
                    int cloneChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Recommendation clonedRec = (cloneChoice == 1) ? rec1.clone() : rec2.clone();

                    System.out.println("Enter new target audience:");
                    String newAudience = scanner.nextLine();
                    clonedRec.setTargetAudience(newAudience);

                    System.out.println("Cloned Recommendation:");
                    System.out.println(clonedRec);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
