/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.GUI.InterfaceHandler;
import PAD.GUI.InterfaceName;

import PAD.interfaceKit.KitConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class of this application, this class starts everything
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 * @author Max
 * @author Bobbie
 */
public class Main extends Application {

    private static final String dbHost = "localhost";   // the databass host
    private static final String dbTable = "pad_sss02"; // the name of the table we are selecting
    private static final String dbUser = "root";        // the database username
    private static final String dbPassword = "root"; // the database password

    public static Connection connection; // the database connection

    public static Controller controller = new Controller(); // the controller for this application

    /**
     * The main function of this application
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        initializeDB(); // inits the database

        KitConnector.initialize(); // connects the interface kit

        launch(args); // launches the interface
    }

    @Override
    public void start(Stage stage) throws IOException {
        InterfaceHandler.open(InterfaceName.MAIN); // opens the main interface
    }

    /**
     * Connects with the database
     */
    public static void initializeDB() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + "/" + dbTable + "?autoreconnect=true?db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", dbUser, dbPassword);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
