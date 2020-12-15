package de.hbrs.todolistmanager.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Hält die Liste der Items, die gespeichert werden.
 */
@JacksonXmlRootElement(localName = "list")
public class PersistentTodoItemList {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "todo")
    public List<PersistentTodoItem> persistentTodoItems;

    public List<PersistentTodoItem> getPersistentTodoItems() {
        return persistentTodoItems;
    }

    public void setPersistentTodoItems(List<PersistentTodoItem> persistentTodoItems) {
        this.persistentTodoItems = persistentTodoItems;
    }

}
