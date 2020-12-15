module todolistmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.dataformat.xml;
    requires org.apache.logging.log4j;

    opens de.hbrs.todolistmanager;
    opens de.hbrs.todolistmanager.controller;
    opens de.hbrs.todolistmanager.view;
    opens de.hbrs.todolistmanager.model.view;
    opens de.hbrs.todolistmanager.model;
}