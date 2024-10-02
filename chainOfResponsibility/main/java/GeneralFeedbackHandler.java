public class GeneralFeedbackHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Analyzing general feedback: " + message);
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
