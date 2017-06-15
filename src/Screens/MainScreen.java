package Screens;

import Database.UserDataController;
import Models.Match;
import Models.User;
import Rmi.RmiController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainScreen {

    @FXML
    private Button lfm_btnJoinGame;

    @FXML
    private Label lgn_lblPassword;

    @FXML
    private RadioButton rp_rbWildformatYour;

    @FXML
    private Button lfm_btnPlacegame;

    @FXML
    private TextField lgn_tbPassword;

    @FXML
    private TextField lfm_tbTitle;

    @FXML
    private ListView<Match> lfm_lvGames;

    @FXML
    private TextArea rp_tfExtraYour;

    @FXML
    private Button rp_btnProposeYour;

    @FXML
    private Label lgn_lblGamertag;

    @FXML
    private RadioButton rp_rbWildformatTheir;

    @FXML
    private Button lfm_btnRefresh;

    @FXML
    private DatePicker lfm_dpDate;

    @FXML
    private TextField lgn_tbGamertag;

    @FXML
    private Button lgn_btnLogin;

    private RmiController rmiController;
    private UserDataController userDataController;

    private String ipAdress;
    private int portNumber;

    private User user;

    @FXML
    void initialize() {
        //deze controller is gemaakt met behulp van de tools in scenebuilder
        assert lfm_btnJoinGame != null : "fx:id=\"lfm_btnJoinGame\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lgn_lblPassword != null : "fx:id=\"lgn_lblPassword\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_rbWildformatYour != null : "fx:id=\"rp_rbWildformatYour\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_btnPlacegame != null : "fx:id=\"lfm_btnPlacegame\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lgn_tbPassword != null : "fx:id=\"lgn_tbPassword\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_tbTitle != null : "fx:id=\"lfm_tbTitle\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_lvGames != null : "fx:id=\"lfm_lvGames\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_tfExtraYour != null : "fx:id=\"rp_tfExtraYour\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_btnProposeYour != null : "fx:id=\"rp_btnProposeYour\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lgn_lblGamertag != null : "fx:id=\"lgn_lblGamertag\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_rbWildformatTheir != null : "fx:id=\"rp_rbWildformatTheir\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_btnRefresh != null : "fx:id=\"lfm_btnRefresh\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_dpDate != null : "fx:id=\"lfm_dpDate\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lgn_tbGamertag != null : "fx:id=\"lgn_tbGamertag\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lgn_btnLogin != null : "fx:id=\"lgn_btnLogin\" was not injected: check your FXML file 'MainScreen.fxml'.";

        ipAdress = "192.168.152.1";

        portNumber = 1099;
        rmiController = new RmiController(ipAdress,portNumber);
        userDataController = new UserDataController();

        lgn_btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(userDataController.getUser(lgn_tbGamertag.getText(),lgn_tbPassword.getText())){
                    lgn_btnLogin.setVisible(false);
                    lgn_lblGamertag.setVisible(false);
                    lgn_lblPassword.setVisible(false);
                    lgn_tbGamertag.setVisible(false);
                    lgn_tbPassword.setVisible(false);
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Login mislukt");
                    a.setHeaderText("Inloggen mislukt");
                    a.setContentText("De opgegeven inlog gegevens zijn incorect ingevoerd.");
                    a.showAndWait();
                }
            }
        });




        lfm_btnPlacegame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //place game code
                rmiController.addMatch(lfm_dpDate.getValue(),userDataController.getUser(),lfm_tbTitle.getText());
                updateGui();
            }
        });

        lfm_btnRefresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    updateGui();
            }
        });

        lfm_btnJoinGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                updateGui();
            }
        });

    }

    private void updateGui(){
        lfm_lvGames.setItems(rmiController.getMatches());
    }
}
