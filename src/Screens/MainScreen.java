package Screens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class MainScreen {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lfm_tbTitle;

    @FXML
    private ChoiceBox<?> lfm_gameModeChoiceBox;

    @FXML
    private Button lfm_btnPlacegame;

    @FXML
    private TextField trm_tbTitle;

    @FXML
    private ChoiceBox<?> trm_cbGamemode;

    @FXML
    private Button trm_btnMakeTournament;

    @FXML
    private TableColumn<?, ?> sb_tvScoreboard;

    @FXML
    void initialize() {
        //deze controller is gemaakt met behulp van de tools in scenebuilder
        assert lfm_tbTitle != null : "fx:id=\"lfm_tbTitle\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_gameModeChoiceBox != null : "fx:id=\"lfm_gameModeChoiceBox\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_btnPlacegame != null : "fx:id=\"lfm_btnPlacegame\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert trm_tbTitle != null : "fx:id=\"trm_tbTitle\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert trm_cbGamemode != null : "fx:id=\"trm_cbGamemode\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert trm_btnMakeTournament != null : "fx:id=\"trm_btnMakeTournament\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert sb_tvScoreboard != null : "fx:id=\"sb_tvScoreboard\" was not injected: check your FXML file 'MainScreen.fxml'.";

    }
}
