package de.hbrs.todolistmanager.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Hält die Liste der Items, die gespeichert werden.
 */
@JacksonXmlRootElement(localName = "lists")
public class PersistentTodoItemList {

    @JacksonXmlElementWrapper(localName = "finishDate", useWrapping = true)
    @JacksonXmlProperty(localName = "latestFinishDateTodoItem")
    public List<LatestFinishDatePersistentTodoItem> latestFinishDatePersistentTodoItems;

    @JacksonXmlElementWrapper(localName = "priority", useWrapping = true)
    @JacksonXmlProperty(localName = "priorityTodoItem")
    public List<PriorityPersistentTodoItem> priorityPersistentTodoItems;


    public List<LatestFinishDatePersistentTodoItem> getLatestFinishDatePersistentTodoItems() {
        return latestFinishDatePersistentTodoItems;
    }

    public void setLatestFinishDatePersistentTodoItems(List<LatestFinishDatePersistentTodoItem> todoItems) {
        this.latestFinishDatePersistentTodoItems = todoItems;
    }

    public List<PriorityPersistentTodoItem> getPriorityPersistentTodoItems() {
        return priorityPersistentTodoItems;
    }

    public void setPriorityPersistentTodoItems(List<PriorityPersistentTodoItem> todoItems) {
        this.priorityPersistentTodoItems = todoItems;
    }
}
