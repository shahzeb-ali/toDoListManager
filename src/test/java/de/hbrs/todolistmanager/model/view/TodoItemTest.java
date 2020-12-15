package de.hbrs.todolistmanager.model.view;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TodoItemTest {

	private static final String TESTISSUE = "testissue";

	@Test
	void testSettingAndGetting() {
		TodoItem todoItem = new TodoItem();

		todoItem.setIssue(TESTISSUE);
		todoItem.setLatestFinishDate(LocalDate.now());

		assertEquals(TESTISSUE, todoItem.getIssue());
		assertEquals(LocalDate.now(), todoItem.getLatestFinishDate());
	}

	@Test
	void testConstructorWithParameters() {
		TodoItem todoItem = new TodoItem(TESTISSUE, LocalDate.now());

		assertEquals(TESTISSUE, todoItem.getIssue());
		assertEquals(LocalDate.now(), todoItem.getLatestFinishDate());
	}

	@Test
	void testNotEqual() {
		assertFalse(testEquals(new TodoItem("test", null), new TodoItem("test", LocalDate.now())));
		assertFalse(testEquals(new TodoItem("test", LocalDate.now()), new TodoItem("test", null)));
		assertFalse(testEquals(new TodoItem("test1", LocalDate.now()), new TodoItem("test2", LocalDate.now())));
	}

	@Test
	void testEqualsNullOrOtherObject() {
		boolean nullTest = testEquals(new TodoItem("test", LocalDate.now()), null);
		assertFalse(nullTest);
		assertFalse((new TodoItem("test", LocalDate.now()).equals("test")));
	}

	@Test
	void testNotEqualOtherDate() {
		assertFalse(testEquals(new TodoItem("test", LocalDate.now()), new TodoItem("test", LocalDate.of(2018, 5, 20))));
	}

	/**
	 * Hilfemethode für Test
	 */
	private boolean testEquals(TodoItem todoItem, TodoItem todoItem2) {
		return todoItem.equals(todoItem2);
	}
}
