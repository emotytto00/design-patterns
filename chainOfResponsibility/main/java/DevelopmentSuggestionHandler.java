public class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevelopmentSuggestionHandler: Logging development suggestion: " + message);
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
