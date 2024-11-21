import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> bookList;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.bookList = new ArrayList<>();
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        this.bookList.remove(book);
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.bookList = new ArrayList<>();
            for (Book book : this.bookList) {
                cloned.bookList.add(book.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Target Audience: " + targetAudience + "\nBooks: " + bookList.toString();
    }
}
