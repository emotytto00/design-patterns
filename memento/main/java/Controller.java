import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;   // Undo history
    private List<IMemento> redoList;  // Redo history

    private List<String> historyMetadata;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoList = new ArrayList<>();
        this.historyMetadata = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();  // Save current state before changing
        model.setOption(optionNumber, choice);
        redoList.clear();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();  // Save current state before changing
        model.setIsSelected(isSelected);
        redoList.clear();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento currentState = model.createMemento();
            redoList.add(currentState);

            IMemento previousState = history.remove(history.size() - 1); // Pop last state from history
            historyMetadata.remove(historyMetadata.size() - 1);  // Remove corresponding metadata
            model.restoreState(previousState);  // Restore state
            gui.updateGui();  // Update the GUI
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Memento found in redo list");
            saveToHistory();  // Save current state to history before redoing
            IMemento redoState = redoList.remove(redoList.size() - 1); // Pop last redo state
            model.restoreState(redoState); // Restore redo state
            gui.updateGui();  // Update the GUI
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);

        // Save a timestamp of the state for the history window
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        historyMetadata.add("State saved at: " + timestamp);
    }

    // Method to open the history window and allow selecting states to restore
    public void openHistoryWindow() {
        Stage historyStage = new Stage();
        ListView<String> historyListView = new ListView<>();

        // Add the history metadata to the ListView
        ObservableList<String> items = FXCollections.observableArrayList(historyMetadata);
        historyListView.setItems(items);

        // Handle item selection to restore a state
        historyListView.setOnMouseClicked(event -> {
            int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                // Restore the selected state
                IMemento selectedState = history.get(selectedIndex);
                model.restoreState(selectedState);
                gui.updateGui();  // Update the GUI
            }
        });

        // Create and display the history window
        VBox vbox = new VBox(historyListView);
        Scene historyScene = new Scene(vbox, 300, 400);
        historyStage.setScene(historyScene);
        historyStage.setTitle("State History");
        historyStage.show();
    }
}
