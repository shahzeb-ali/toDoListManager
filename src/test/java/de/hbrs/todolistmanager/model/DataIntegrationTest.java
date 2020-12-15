package de.hbrs.todolistmanager.model;

import de.hbrs.todolistmanager.model.view.TodoItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataIntegrationTest {
	
	
	private static final String TODOLIST_IT_EMPTY_XML = "todolist-it-empty.xml";
	private static final String TODOLIST_IT_XML = "todolist-it.xml";
	private static final String TODOLIST_IT_MISSING_XML = "todolist-it-missing.xml";
	private static final String TODOLIST_IT_BROKEN_FILENAME = "";
	
	private static final String ISSUE1 = "demoissue";
	private static final String ISSUE2 = "demoissue2";


	@Test
	void writeAndReadEmptyList() {

		ObservableList<TodoItem> data = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		
		DataIntegration dataIntegration = new DataIntegration();
		dataIntegration.fileName = TODOLIST_IT_EMPTY_XML;
		data.addListener(dataIntegration);
		
		data.add(new TodoItem(ISSUE1, LocalDate.now()));
		data.remove(0);
								
		DataIntegration readDataIntegration = new DataIntegration();
		readDataIntegration.fileName = TODOLIST_IT_EMPTY_XML;
		ObservableList<TodoItem> data2 = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		readDataIntegration.readData(data2);
				
		assertEquals(data2.size(), data.size());
	}

	@Test
	void writeAndReadList() {

		ObservableList<TodoItem> data = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		
		DataIntegration dataIntegration = new DataIntegration();
		dataIntegration.fileName = TODOLIST_IT_XML;
		data.addListener(dataIntegration);
		
		data.add(new TodoItem(ISSUE1, LocalDate.now()));
		data.add(new TodoItem(ISSUE2, LocalDate.now()));
						
		DataIntegration readDataIntegration = new DataIntegration();
		readDataIntegration.fileName = TODOLIST_IT_XML;
		ObservableList<TodoItem> data2 = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		readDataIntegration.readData(data2);
				
		assertEquals(data2.size(), data.size());
		
		for (TodoItem item : data) {
			assertTrue(data2.contains(item));
		}

	}
	
	@Test 
	void missingFile() {
		DataIntegration readDataIntegration = new DataIntegration();
		readDataIntegration.fileName = TODOLIST_IT_MISSING_XML;
		ObservableList<TodoItem> data2 = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		readDataIntegration.readData(data2);

		assertEquals(0, data2.size());
	}

	@Test
	void brokenFilename() {

		ObservableList<TodoItem> data = FXCollections.observableArrayList(new ArrayList<TodoItem>());

		DataIntegration dataIntegration = new DataIntegration();
		dataIntegration.fileName = TODOLIST_IT_BROKEN_FILENAME;
		data.addListener(dataIntegration);

		data.add(new TodoItem(ISSUE1, LocalDate.now()));

		assertEquals(1, data.size());

	}
	

	@Test
	void addAndDeleteItem() {

		// Hinzufügen
		
		ObservableList<TodoItem> data = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		
		DataIntegration dataIntegration = new DataIntegration();
		dataIntegration.fileName = TODOLIST_IT_XML;
		data.addListener(dataIntegration);
		
		data.add(new TodoItem(ISSUE1, LocalDate.now()));
		
		DataIntegration readDataIntegration = new DataIntegration();
		readDataIntegration.fileName = TODOLIST_IT_XML;
		ObservableList<TodoItem> data2 = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		readDataIntegration.readData(data2);
				
		assertEquals(1, data2.size());
		
		assertEquals(data.get(0), data2.get(0));
		
		// Löschen
		
		data.remove(0);
		
		DataIntegration readDataIntegrationDelete = new DataIntegration();
		readDataIntegrationDelete.fileName = TODOLIST_IT_XML;
		ObservableList<TodoItem> dataDelete = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		readDataIntegrationDelete.readData(dataDelete);
				
		assertEquals(0, dataDelete.size());
		
	}
	
	@Test
	void changeItem() {
		
		ObservableList<TodoItem> data = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		
		DataIntegration dataIntegration = new DataIntegration();
		dataIntegration.fileName = TODOLIST_IT_XML;
		data.addListener(dataIntegration);
		
		TodoItem todoItem = new TodoItem(ISSUE1, LocalDate.now());
		
		data.add(todoItem);
		
		data.remove(todoItem);
		
		todoItem.setIssue(ISSUE2);
		
		data.add(todoItem);
			
		
		DataIntegration readDataIntegration = new DataIntegration();
		readDataIntegration.fileName = TODOLIST_IT_XML;
		ObservableList<TodoItem> data2 = FXCollections.observableArrayList(new ArrayList<TodoItem>());
		readDataIntegration.readData(data2);
				
		assertEquals(1, data2.size());

		assertEquals(data2.get(0), todoItem);
		
		data.remove(0);
	}
}
