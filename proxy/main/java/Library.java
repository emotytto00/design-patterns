import java.util.HashMap;
import java.util.Date;

public class Library {
    private HashMap<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addUnprotectedDocument(String id, Date creationDate, String content) {
        Document document = new DocumentImpl(id, creationDate, content);
        documents.put(id, document);
    }

    public void addProtectedDocument(String id, Date creationDate, String content, AccessControlService acs, String username) {
        DocumentImpl realDocument = new DocumentImpl(id, creationDate, content);
        Document proxy = new DocumentProxy(realDocument);
        documents.put(id, proxy);
        acs.grantAccess(username, id);
    }

    public Document getDocument(String id) {
        return documents.get(id);
    }
}
