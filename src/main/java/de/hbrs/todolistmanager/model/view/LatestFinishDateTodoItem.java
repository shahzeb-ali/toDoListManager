package de.hbrs.todolistmanager.model.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;

public class LatestFinishDateTodoItem extends AbstractTodoItem{

	private ObjectProperty<LocalDate> latestFinishDate = new SimpleObjectProperty<>();

	public LatestFinishDateTodoItem() {
		super();
	}

	public LatestFinishDateTodoItem(String issue, LocalDate latestFinishDate) {
		super(issue);
		this.latestFinishDate.setValue(latestFinishDate);
	}

	public LocalDate getLatestFinishDate() {
		return latestFinishDate.getValue();
	}

	public void setLatestFinishDate(LocalDate latestFinishDate) {
		this.latestFinishDate.setValue(latestFinishDate);
	}

	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		if (obj instanceof LatestFinishDateTodoItem) {
			return latestFinishDate.getValue().equals(((LatestFinishDateTodoItem) obj).latestFinishDate.getValue());
		}
		return false;
	}
}