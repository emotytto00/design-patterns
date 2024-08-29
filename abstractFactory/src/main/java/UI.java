abstract class UI {
    protected String text;

    public UI(String text) {
        this.text = text;
    }

    public abstract void display();

    public void setText(String text) {
        this.text = text;
    }
}
