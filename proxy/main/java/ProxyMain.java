import java.util.Date;

public class ProxyMain {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        User jorma = new User("Jorma");
        User jooseppi = new User("Jooseppi");

        library.addUnprotectedDocument("doc1", new Date(), "Täällä ei ole salaisuuksia.");

        library.addProtectedDocument("doc2", new Date(), "Täällä on salaisuuksia.", acs, "Jooseppi");

        try {
            Document doc1 = library.getDocument("doc1");
            System.out.println("Document 1 content: " + doc1.getContent(jorma));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            Document doc2 = library.getDocument("doc2");
            System.out.println("Document 2 content (Jooseppi): " + doc2.getContent(jooseppi));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        try {
            Document doc2 = library.getDocument("doc2");
            System.out.println("Document 2 content (jorma): " + doc2.getContent(jorma));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
