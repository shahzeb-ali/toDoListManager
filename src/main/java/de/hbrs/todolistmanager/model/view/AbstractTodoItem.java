package de.hbrs.todolistmanager.model.view;


import javafx.beans.property.SimpleStringProperty;

public abstract class AbstractTodoItem {

	protected SimpleStringProperty issue = new SimpleStringProperty("");

	public AbstractTodoItem() {
		new LatestFinishDateTodoItem("", null);
	}

	public AbstractTodoItem(String issue) {
		this.issue.setValue(issue);
	}

	public String getIssue() {
		return issue.getValue();
	}

	public void setIssue(String issue) {
		this.issue.setValue(issue);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractTodoItem) {

			if (this.getIssue().equals(((AbstractTodoItem) obj).getIssue())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "AbstractTodoItem [issue=" + issue + "]";
	}



}
