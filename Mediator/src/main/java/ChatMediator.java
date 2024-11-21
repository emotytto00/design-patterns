interface ChatMediator {
    void sendMessage(String message, String sender, String recipient);

    void addUser(ChatClient client);
}

