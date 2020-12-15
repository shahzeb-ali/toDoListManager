package de.hbrs.todolistmanager.model;

import de.hbrs.todolistmanager.model.view.TodoItem;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Item, welches persistiert wird
 */
public class PersistentTodoItem {

	private String issue;

	private Date latestFinishDate;

	/**
	 * Konvertierung von View-Item in persistentes Item
	 * @param item das Item aus dem View
	 */
	public PersistentTodoItem(TodoItem item) {
		this.issue = item.getIssue();
		if (item.getLatestFinishDate() != null) {
			this.latestFinishDate = Date.from(item.getLatestFinishDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		} else {
			this.latestFinishDate = null;
		}
	}

	/**
	 * Standard Konstruktor für Jackson XML Serialisierung.
	 */
	public PersistentTodoItem() {

	}

	/**
	 * Konvertierung von persistentem Item in View-Item
	 * @return das Item für den View
	 */
	public TodoItem createTodoItem() {
		LocalDate localDate = this.latestFinishDate != null
				? this.latestFinishDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
		return new TodoItem(this.issue, localDate);
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public Date getLatestFinishDate() {
		return latestFinishDate;
	}

	public void setLatestFinishDate(Date latestFinishDate) {
		this.latestFinishDate = latestFinishDate;
	}
}
