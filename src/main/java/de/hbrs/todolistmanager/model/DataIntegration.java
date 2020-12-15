package de.hbrs.todolistmanager.model;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import de.hbrs.todolistmanager.model.view.TodoItem;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Schreiben und Lesen von Daten in das Dateisystem
 */
public class DataIntegration implements ListChangeListener<TodoItem> {

    private static final Logger logger = LogManager.getLogger(DataIntegration.class);

    /**
     * Dateiname, änderbar für Tests
     */
    String fileName = "todolist.xml";

    /**
     * Lesen der Daten aus dem Dateisystem, falls Datei vorhanden, in die Liste data
     *
     * @param data Die Liste, in welcher die Daten abgelegt werden sollen.
     */
    public void readData(ObservableList<TodoItem> data) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = inputStreamToString(new FileInputStream(fileName));
            PersistentTodoItemList value = xmlMapper.readValue(xml, PersistentTodoItemList.class);

            // Daten befinden sich im Speicher. Nun Übertrag auf die lokale Struktur.
            data.clear();

            if (value.getPersistentTodoItems() != null) {
                for (PersistentTodoItem persistentTodoItem : value.getPersistentTodoItems()) {
                    data.add(persistentTodoItem.createTodoItem());
                }
            }
        } catch (IOException e) {
            logger.error("Error reading file", e);
        }
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    /**
     * Der Listener sorgt dafür, dass Änderungen direkt in das Dateisystem geschrieben werden.
     */
    @Override
    public void onChanged(Change<? extends TodoItem> c) {
        List<PersistentTodoItem> list = new ArrayList<>();

        ObservableList<? extends TodoItem> newList = c.getList();
        for (TodoItem todoItem : newList) {
            list.add(new PersistentTodoItem(todoItem));
        }

        PersistentTodoItemList persistentTodoItemList = new PersistentTodoItemList();
        persistentTodoItemList.setPersistentTodoItems(list);

        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), persistentTodoItemList);
        } catch (IOException e) {
            logger.error("Error writing file", e);
        }
    }
}