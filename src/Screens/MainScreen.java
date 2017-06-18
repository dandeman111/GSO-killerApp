package Screens;

import Database.UserDataController;
import Models.Match;
import Models.RuleSet;
import Rmi.RmiController;
import Rmi.pushpull.RuleController;
import Rmi.pushpull.RuleEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class MainScreen {

    @FXML
    private Button lfm_btnJoinGame;

    @FXML
    private Text rp_txtHostMessage;

    @FXML
    private Text rp_txtJoinedMessage;


    @FXML
    private Tab gen_tabRules;

    @FXML
    private TabPane gen_tpFinder;


    @FXML
    private TextArea rp_tfExtraTheir;

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

    @FXML
    private RadioButton rp_rbWildformatAgreed;


    @FXML
    private Button rp_btnAcceptFinal;


    @FXML
    private TextArea rp_tfExtraAgreed;

    private RmiController rmiController;
    private UserDataController userDataController;
    private RuleController ruleController;

    private String ipAdress;
    private int portNumber;

    Match currentmatch;
    MainScreen mainscreen;

    @FXML
    void initialize() {
        mainscreen = this;
        //deze controller is gemaakt met behulp van de tools in scenebuilder
        assert rp_tfExtraAgreed != null : "fx:id=\"rp_tfExtraAgreed\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_rbWildformatAgreed != null : "fx:id=\"rp_rbWildformatAgreed\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_btnAcceptFinal != null : "fx:id=\"rp_btnAcceptFinal\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert lfm_btnJoinGame != null : "fx:id=\"lfm_btnJoinGame\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_txtJoinedMessage != null : "fx:id=\"rp_txtJoinedMessage\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert rp_txtHostMessage != null : "fx:id=\"rp_txtHostMessage\" was not injected: check your FXML file 'MainScreen.fxml'.";
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
        assert rp_tfExtraTheir != null : "fx:id=\"rp_tfExtraTheir\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert gen_tpFinder != null : "fx:id=\"gen_tpFinder\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert gen_tabRules != null : "fx:id=\"gen_tabRules\" was not injected: check your FXML file 'MainScreen.fxml'.";



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
                if(checkLogin()){
                    //place game code
                    currentmatch = new Match(lfm_dpDate.getValue(),userDataController.getUser(),lfm_tbTitle.getText());
                    rmiController.addMatch(currentmatch);
                    ruleController = new RuleController(currentmatch.toString(),mainscreen);

                    ruleChangeBroadcast(currentmatch,null);
                    updateGui();

                    System.out.println("Hosted game: "+ currentmatch.toString());
                }
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

                if(lfm_lvGames.getSelectionModel()!=null&&checkLogin()){
                    currentmatch = lfm_lvGames.getSelectionModel().getSelectedItem();
                    currentmatch.setJoinedUser(userDataController.getUser());
                    ruleController = new RuleController(currentmatch.toString(),mainscreen);
                    ruleChangeBroadcast(currentmatch,null);
                    rmiController.removeMatch(currentmatch); //verwijdert match uit de lijst als er gejoined word
                    updateGui();
                    System.out.println("Joined game: "+ currentmatch.toString());
                }
            }
        });
        rp_tfExtraYour.textProperty().addListener((observable, oldValue, newValue) ->{
            ruleChangeBroadcast(currentmatch,null);
            updateGui();
        });
        rp_rbWildformatYour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ruleChangeBroadcast(currentmatch,null);
                updateGui();
            }
        });

        rp_btnProposeYour.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ruleChangeBroadcast(currentmatch,new RuleSet(rp_rbWildformatYour.isSelected(),rp_tfExtraYour.getText()));
                updateGui();
            }
        });
        rp_btnAcceptFinal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rp_tfExtraYour.setText(rp_tfExtraAgreed.getText());
                rp_rbWildformatYour.setSelected(rp_rbWildformatAgreed.isSelected());
            }
        });

    }

    private void updateGui(){
        lfm_lvGames.setItems(rmiController.getAvailableMatches());
        if(userDataController.getUser() != null ){
            rp_txtHostMessage.setText(userDataController.getUser().toString()+"'s Rules");
        }
        if(currentmatch != null){
            if( userDataController.getUser().equals(currentmatch.hostUser)){
                rp_txtJoinedMessage.setText(currentmatch.joinedUser.toString());
            }else {

                rp_txtJoinedMessage.setText(currentmatch.hostUser.toString());
            }
        }



    }
    private void ruleChangeBroadcast(Match match,RuleSet finalRuleset){

        RuleSet hostRules;
        RuleSet joinedRuleSet;
        if(currentmatch.getHostUser().equals(userDataController.getUser())){
            hostRules = new RuleSet(rp_rbWildformatYour.isSelected(),rp_tfExtraYour.getText());
            joinedRuleSet = new RuleSet(rp_rbWildformatTheir.isSelected(),rp_tfExtraTheir.getText());
        }else {
            hostRules = new RuleSet(rp_rbWildformatTheir.isSelected(),rp_tfExtraTheir.getText());
            joinedRuleSet = new RuleSet(rp_rbWildformatYour.isSelected(),rp_tfExtraYour.getText());
        }



        ruleController.broadcastRuleChange(match.toString(),hostRules,joinedRuleSet,finalRuleset,userDataController.getUser());
        if(gen_tpFinder.getSelectionModel().getSelectedItem() != gen_tabRules){
            gen_tpFinder.getSelectionModel().select(gen_tabRules);
        }
    }
    public void ruleChangedUpdate(RuleEvent ruleEvent){
        if(currentmatch.getHostUser().equals(userDataController.getUser())){
            rp_rbWildformatTheir.setSelected(ruleEvent.getJoinedRuleSet().getFormat());
            rp_tfExtraTheir.setText(ruleEvent.getJoinedRuleSet().getExtra());
        }else {
            rp_rbWildformatTheir.setSelected(ruleEvent.getHostRuleset().getFormat());
            rp_tfExtraTheir.setText(ruleEvent.getHostRuleset().getExtra());
        }
        if(ruleEvent.getFinalRuleSet()!=null){
            rp_rbWildformatAgreed.setSelected(ruleEvent.getFinalRuleSet().getFormat());
            rp_tfExtraAgreed.setText(ruleEvent.getFinalRuleSet().getExtra());

            if(ruleEvent.getFinalRuleSet().equals(ruleEvent.getJoinedRuleSet())&&ruleEvent.getFinalRuleSet().equals(ruleEvent.getHostRuleset())){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Rules zijn gefixt");
                a.showAndWait();
            }
        }




    }

    public boolean checkLogin(){
        if(userDataController.getUser()!= null){
            return true;
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login error");
        alert.setHeaderText("Failed to authorise");
        alert.setContentText("Login before you do that");
        alert.showAndWait();

        return false;
    }

}
