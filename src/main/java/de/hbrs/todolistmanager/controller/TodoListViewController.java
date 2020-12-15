package de.hbrs.todolistmanager.controller;

import de.hbrs.todolistmanager.model.DataIntegration;
import de.hbrs.todolistmanager.model.view.TodoItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Kontroller für JavaFX
 */
public class TodoListViewController {

    public static final DateTimeFormatter DATE_TIME_FORMATTER =DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @FXML
    private GridPane rootGridPane;

    @FXML
    private TableView<TodoItem> tableView;

    @FXML
    private TableColumn<TodoItem, String> issueTableColumn;

    @FXML
    private TableColumn<TodoItem, String> latestFinishDateTableColumn;

    @FXML
    private TextField issueTextField;

    @FXML
    private DatePicker latestFinishDateDatePicker;


    @FXML
    public void initialize() {
        
        rootGridPane.layoutBoundsProperty().addListener(new ResizingListener (tableView, issueTableColumn, latestFinishDateTableColumn));

        tableView.setEditable(true);

        issueTableColumn.setOnEditCommit(event -> {

            TodoItem todoItem = event.getTableView().getItems().get(event.getTablePosition().getRow());

            // Enfernen und neues Hinzufügen, damit die Listener der Liste benachrichtigt werden.
            int position = event.getTablePosition().getRow();
            event.getTableView().getItems().remove(todoItem);
            todoItem.setIssue(event.getNewValue());
            event.getTableView().getItems().add(position, todoItem);
        }
        );


        issueTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        latestFinishDateTableColumn.setOnEditCommit(event -> {
               TodoItem todoItem = event.getTableView().getItems().get(event.getTablePosition().getRow());
               LocalDate latestFinishDate = todoItem.getLatestFinishDate();

               try {
                   latestFinishDate = LocalDate.parse(event.getNewValue(), DATE_TIME_FORMATTER);
               } catch (DateTimeParseException ex) {
                   // Ignorieren
               }

               // Enfernen und neues Hinzufügen, damit die Listener der Liste benachrichtigt werden.
               int position = event.getTablePosition().getRow();
               event.getTableView().getItems().remove(todoItem);
               todoItem.setLatestFinishDate(latestFinishDate);
               event.getTableView().getItems().add(position, todoItem);

           }
        );

        latestFinishDateTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        
        ObservableList<TodoItem> data = FXCollections.observableArrayList(new ArrayList<TodoItem>());
        DataIntegration dataIntegration = new DataIntegration();
        dataIntegration.readData(data);
        data.addListener(dataIntegration);
                
       	tableView.setItems(data);
    }

    public void addTodoItem() {
        if (issueTextField.getText() != null && !issueTextField.getText().isEmpty()
                && latestFinishDateDatePicker.getValue() != null) {
            TodoItem item = new TodoItem();
            item.setIssue(issueTextField.getText());
            item.setLatestFinishDate(latestFinishDateDatePicker.getValue());

            ObservableList<TodoItem> data = tableView.getItems();
            data.add(item);

            issueTextField.clear();
            latestFinishDateDatePicker.setValue(null);
        }
    }

    public void delete() {
        TodoItem item = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(item);
    }
    
    public void undo() {
    	
    	// Ihr Code für das Command-Pattern
    	
    }
}