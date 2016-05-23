/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.main;

import PAD.GUI.Highscore;
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
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 *
 * @author Youri Dudock
 * @author <Stefan Groenestein, IT102, 500726588>
 */
public class Main extends Application {
    
    	private static final String dbHost = "localhost";   //select host name
	private static final String dbTable = "pad_sss02"; //db schema name
	private static final String dbUser = "root";        // db username
	private static final String dbPassword = "root"; // db password
    
    public static Connection connection;
    
    public static Controller controller = new Controller();
    
    @Override
    public void start(Stage stage) throws IOException {

        InterfaceHandler.open(InterfaceName.MAIN);
    }
    

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        initializeDB(); 
  
        KitConnector.initialize();
        launch(args);
        
        
    }
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