import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatClientController {
    private ChatClient client;

    @FXML
    private TextArea chatDisplay;

    @FXML
    private TextField messageInput;

    @FXML
    private TextField recipientInput;

    @FXML
    private Button sendButton;

    public void setClient(ChatClient client) {
        this.client = client;
        client.setController(this);
    }

    public void displayMessage(String message) {
        chatDisplay.appendText(message + "\n");
    }

    @FXML
    public void sendMessage() {
        String message = messageInput.getText();
        String recipient = recipientInput.getText();

        if (!message.isEmpty() && !recipient.isEmpty()) {
            client.sendMessage(message, recipient);
            displayMessage("You: " + message);
            messageInput.clear();
        } else {
            displayMessage("System: Please enter a message and recipient.");
        }
    }
}
