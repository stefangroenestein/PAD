/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.GUI;

import PAD.game.GameHandler;
import PAD.game.GameMode;
import static PAD.main.Main.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author max
 */
public class GUIController implements Initializable {

    @FXML
    private Button buttonMode1;    // eerste knop
    @FXML
    private Button buttonMode2;    // tweede knop
    @FXML
    private Button buttonMode3;    // derde knop

    @FXML
    private TableColumn<Highscore, String> tableName;
    @FXML
    private TableColumn<Highscore, String> tableScore;

    @FXML
    private TableView<Highscore> highscoreTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //tableName.setCellValueFactory(new PropertyValueFactory<Highscore, String>("userName"));
        //tableScore.setCellValueFactory(new PropertyValueFactory<Highscore, Integer>("highscore"));
        
        tableName.setCellValueFactory(cellData -> cellData.getValue().getUserName());
        tableScore.setCellValueFactory(cellData -> cellData.getValue().getConvertedHighscores());


        ObservableList<Highscore> list = Highscore.getHighscoreData();

        highscoreTable.setItems(list);

        buttonMode1.setOnAction(e -> {
            GameHandler.startGame(GameMode.NORMAL);

        });

        buttonMode2.setOnAction(e -> {
            GameHandler.startGame(GameMode.TIMED_EASY);

        });
        
        buttonMode3.setOnAction(e -> {
            GameHandler.stopGame();

        });


        new Thread(controller).start();
    }

    @FXML
    public void startMode1() {

    }

    private void start() {

    }
}
