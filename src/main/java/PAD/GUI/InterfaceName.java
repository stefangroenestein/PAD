/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.GUI;

import javafx.stage.Stage;

/**
 *
 * @author max
 */
public enum InterfaceName {

    MAIN("GUI.fxml", new Stage()),
    PISTONS_DOWN("waitingPistons.fxml", new Stage()),
    IN_GAME("inGameScreen.fxml", new Stage());

    private String fileName;

    private Stage stage;

    private InterfaceName(String fileName, Stage stage) {

        this.fileName = fileName;
        this.stage = stage;

    }

    public String getFileName() {

        return fileName;
    }

    public Stage getStage() {
        return stage;
    }
}
