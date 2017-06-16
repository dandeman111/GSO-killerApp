package Rmi.pushpull;

import Models.RuleSet;
import Models.User;
import Screens.MainScreen;

import java.rmi.RemoteException;

/**
 * Created by dande on 15-6-2017.
 */
public class RuleController {

    //private static int portNumber = 1100;
    //private static String bindingName = "publisher";

    private RuleComunicator ruleComunicator;

    //private String currentProperty = "Rule";

    private RuleEvent ruleEvent;
    private MainScreen mainScreen;

    public RuleController(String matchId, MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        try {
            this.ruleComunicator = new RuleComunicator(this);

            ruleComunicator.connectToPublisher();

            ruleComunicator.register(matchId);

            ruleComunicator.subscribe(matchId);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


    public void updateRules(String property,RuleEvent ruleEvent){
        this.ruleEvent = ruleEvent;
        mainScreen.ruleChangedUpdate(ruleEvent);
        System.out.println("rules have changed");
    }

    public void broadcastRuleChange(String property, RuleSet hostRuleset, RuleSet joinedRuleset, User user){
        RuleEvent ruleEvent = new RuleEvent(hostRuleset,joinedRuleset,user);
        ruleComunicator.broadcast(property,ruleEvent);
    }

    public RuleSet getJoinedruleSet(){
        return ruleEvent.getJoinedRuleSet();
    }

    public RuleSet getHostruleset(){
        return ruleEvent.getHostRuleset();
    }
}
