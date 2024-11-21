import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ChatMediator mediator = new ChatMediatorImpl();

        createClientWindow("Jorma", mediator);
        createClientWindow("Jooseppi", mediator);
        createClientWindow("Joakim", mediator);
    }

    public void createClientWindow(String username, ChatMediator mediator) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatClient.fxml"));
        Stage stage = new Stage();
        stage.setTitle(username);
        stage.setScene(new Scene(loader.load()));

        ChatClientController controller = loader.getController();
        ChatClient client = new ChatClient(username, mediator);
        controller.setClient(client);

        stage.show();
    }
}
