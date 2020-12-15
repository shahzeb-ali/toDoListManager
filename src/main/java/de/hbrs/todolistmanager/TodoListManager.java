package de.hbrs.todolistmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Locale;

/**
 * Hauptprogramm des Aufgaben-Listen-Managers
 *
 */
public class TodoListManager extends Application {

	/**
	 * Start-Methode für JavaFX
	 * 
	 * @param primaryStage Die Stage, auf der das Fenster angezeigt werden soll, wird übergeben
	 */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(Locale.GERMANY);
        primaryStage.setTitle("Meine Aufgabenliste");

        URL url = ClassLoader.getSystemResources("todolistview.fxml").nextElement();

        Pane pane = FXMLLoader.load(url);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Der Einsprungspunkt in das Programm
     * @param args Kommandozeilenargumente
     */
    public static void main(String[] args) {
        launch(args);
    }
}