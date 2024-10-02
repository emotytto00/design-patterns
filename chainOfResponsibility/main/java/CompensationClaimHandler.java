public class CompensationClaimHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("CompensationClaimHandler: Processing compensation claim: " + message);
        } else if (nextHandler != null) {
            nextHandler.handleFeedback(message);
        }
    }
}
