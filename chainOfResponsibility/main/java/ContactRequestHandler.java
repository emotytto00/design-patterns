public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Processing contact request: " + message);
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
