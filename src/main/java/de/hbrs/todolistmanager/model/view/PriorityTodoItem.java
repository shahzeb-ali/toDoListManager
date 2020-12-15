package de.hbrs.todolistmanager.model.view;

public class PriorityTodoItem extends AbstractTodoItem {

	private Integer priority = 0;

	public PriorityTodoItem(String issue) {
		super();
	}

	public PriorityTodoItem(String issue, Integer priority) {
		super(issue);
		this.setPriority(priority);
	}

	public Integer getPriority() {
		return priority;
	}

	private void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public boolean equals(Object obj) {

		super.equals(obj);
		if (obj instanceof PriorityTodoItem) {
			return this.priority.equals(((PriorityTodoItem) obj).getPriority());
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " " + "LatestFinishDateTodoItem [priority=" + priority + "]";
	}

}
