/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.jar.Attributes.Name;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

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
	public void initialize() {
		// Initialize the search table
		columnName.setCellValueFactory(
				cellData -> cellData.getValue().getUserName());
//		columnScore.setCellValueFactory(
//				cellData -> cellData.getValue().getHighscore()); //hoe krijg ik dit int

	} 
        
	}