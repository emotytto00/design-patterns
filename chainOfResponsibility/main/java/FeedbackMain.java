public class FeedbackMain {
    public static void main(String[] args) {
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalFeedbackHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalFeedbackHandler);

        Message message1 = new Message(MessageType.COMPENSATION, "I broke it and I want a new one.", "jooseppi.kivinen@asd.com");
        Message message2 = new Message(MessageType.CONTACT_REQUEST, "Why you don't answer me??.", "jooseppi.kivinen@asd.com");
        Message message3 = new Message(MessageType.DEVELOPMENT_SUGGESTION, "Make it cheaper.", "jooseppi.kivinen@asd.com");
        Message message4 = new Message(MessageType.GENERAL_FEEDBACK, "Service was mediocre.", "jooseppi.kivinen@asd.com");
        Message message5 = new Message(MessageType.GENERAL_FEEDBACK, "I take it back service was not so good.", "jooseppi.kivinen@asd.com");

        System.out.println("Processing feedback messages...\n");
        compensationHandler.handleFeedback(message1);
        compensationHandler.handleFeedback(message2);
        compensationHandler.handleFeedback(message3);
        compensationHandler.handleFeedback(message4);
        compensationHandler.handleFeedback(message5);
    }
}

