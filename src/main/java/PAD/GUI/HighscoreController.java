/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author max
 */
public class HighscoreController {
 
    	@FXML
	private TableColumn<Highscore, String> columnName;
        @FXML
	private TableColumn<Highscore, Integer> columnScore;
        
        @FXML
        private TableView<Highscore> highscoreTable;
        
            
        private ObservableList<Highscore> tableContent = FXCollections.observableArrayList();

        
        @FXML
	public void initialize() {
                    tableContent.add(new Highscore(1, 1, "test"));
            //ObservableList<Highscore> list = Highscore.getHighscoreData();
           
            
            columnName.setCellValueFactory(new PropertyValueFactory<Highscore,String>("userName"));
            columnScore.setCellValueFactory(new PropertyValueFactory<Highscore,Integer>("highscore"));

		// Initialize the search table
		///columnName.setCellValueFactory(
				//cellData -> cellData.getValue().getUserName());
//		columnScore.setCellValueFactory(
//				cellData -> cellData.getValue().getHighscore()); //hoe krijg ik dit int

	} 
        
	}