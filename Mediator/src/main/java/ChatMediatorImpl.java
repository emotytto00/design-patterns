import java.util.HashMap;
import java.util.Map;

public class ChatMediatorImpl implements ChatMediator {
    private Map<String, ChatClient> clients;

    public ChatMediatorImpl() {
        this.clients = new HashMap<>();
    }

    @Override
    public void addUser(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    @Override
    public void sendMessage(String message, String sender, String recipient) {
        ChatClient recipientClient = clients.get(recipient);
        if (recipientClient != null) {
            recipientClient.receiveMessage(message, sender);
        } else {
            ChatClient senderClient = clients.get(sender);
            if (senderClient != null) {
                senderClient.receiveMessage("User " + recipient + " does not exist.", "System");
            }
        }
    }
}
