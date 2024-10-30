import java.util.Date;

public class DocumentImpl implements Document {
    private String id;
    private Date creationDate;
    private String content;

    public DocumentImpl(String id, Date creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
