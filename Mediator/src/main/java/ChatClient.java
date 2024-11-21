public class ChatClient {
    private String username;
    private ChatMediator mediator;
    private ChatClientController controller;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        this.mediator.addUser(this);
    }

    public String getUsername() {
        return username;
    }

    public void setController(ChatClientController controller) {
        this.controller = controller;
    }

    public void sendMessage(String message, String recipient) {
        mediator.sendMessage(message, this.username, recipient);
    }

    public void receiveMessage(String message, String sender) {
        if (controller != null) {
            controller.displayMessage(sender + ": " + message);
        }
    }
}
