package de.hbrs.todolistmanager.model;


import de.hbrs.todolistmanager.model.view.LatestFinishDateTodoItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersistentTodoItemTest {
	
	private static final String TESTISSUE = "testissue";

	@Test
	void testSettingAndGetting () {
		
		LatestFinishDateTodoItem todoItem = new LatestFinishDateTodoItem(TESTISSUE,LocalDate.now());
		
		PersistentTodoItem persistentTodoItem = new PersistentTodoItem(todoItem);
		
		LatestFinishDateTodoItem todoItem2 = persistentTodoItem.createTodoItem();

		assertEquals(todoItem, todoItem2);
	}
	
	@Test
	void testSettingAndGettingWithNullTime () {
		
		LatestFinishDateTodoItem todoItem = new LatestFinishDateTodoItem(TESTISSUE,null);
		
		PersistentTodoItem persistentTodoItem = new PersistentTodoItem(todoItem);
		
		LatestFinishDateTodoItem todoItem2 = persistentTodoItem.createTodoItem();

		assertEquals(todoItem, todoItem2);

	}

}
