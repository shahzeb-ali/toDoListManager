package de.hbrs.todolistmanager.model.view;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LatestFinishDateTodoItemTest {

	private static final String TESTISSUE = "testissue";

	@Test
	void testSettingAndGetting() {
		LatestFinishDateTodoItem todoItem = new LatestFinishDateTodoItem();

		todoItem.setIssue(TESTISSUE);
		todoItem.setLatestFinishDate(LocalDate.now());

		assertEquals(TESTISSUE, todoItem.getIssue());
		assertEquals(LocalDate.now(), todoItem.getLatestFinishDate());
	}

	@Test
	void testConstructorWithParameters() {
		LatestFinishDateTodoItem todoItem = new LatestFinishDateTodoItem(TESTISSUE, LocalDate.now());

		assertEquals(TESTISSUE, todoItem.getIssue());
		assertEquals(LocalDate.now(), todoItem.getLatestFinishDate());
	}

	@Test
	void testNotEqual() {
		assertFalse(testEquals(new LatestFinishDateTodoItem("test", null), new LatestFinishDateTodoItem("test", LocalDate.now())));
		assertFalse(testEquals(new LatestFinishDateTodoItem("test", LocalDate.now()), new LatestFinishDateTodoItem("test", null)));
		assertFalse(testEquals(new LatestFinishDateTodoItem("test1", LocalDate.now()), new LatestFinishDateTodoItem("test2", LocalDate.now())));
	}

	@Test
	void testEqualsNullOrOtherObject() {
		boolean nullTest = testEquals(new LatestFinishDateTodoItem("test", LocalDate.now()), null);
		assertFalse(nullTest);
		assertFalse((new LatestFinishDateTodoItem("test", LocalDate.now()).equals("test")));
	}

	@Test
	void testNotEqualOtherDate() {
		assertFalse(testEquals(new LatestFinishDateTodoItem("test", LocalDate.now()), new LatestFinishDateTodoItem("test", LocalDate.of(2018, 5, 20))));
	}

	/**
	 * Hilfemethode für Test
	 */
	private boolean testEquals(LatestFinishDateTodoItem todoItem, LatestFinishDateTodoItem todoItem2) {
		return todoItem.equals(todoItem2);
	}
}
