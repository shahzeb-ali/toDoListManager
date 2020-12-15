package de.hbrs.todolistmanager.model;


import de.hbrs.todolistmanager.model.view.TodoItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersistentTodoItemTest {
	
	private static final String TESTISSUE = "testissue";

	@Test
	void testSettingAndGetting () {
		
		TodoItem todoItem = new TodoItem(TESTISSUE,LocalDate.now());
		
		PersistentTodoItem persistentTodoItem = new PersistentTodoItem(todoItem);
		
		TodoItem todoItem2 = persistentTodoItem.createTodoItem();

		assertEquals(todoItem, todoItem2);
	}
	
	@Test
	void testSettingAndGettingWithNullTime () {
		
		TodoItem todoItem = new TodoItem(TESTISSUE,null);
		
		PersistentTodoItem persistentTodoItem = new PersistentTodoItem(todoItem);
		
		TodoItem todoItem2 = persistentTodoItem.createTodoItem();

		assertEquals(todoItem, todoItem2);

	}

}
