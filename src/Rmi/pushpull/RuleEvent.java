package Rmi.pushpull;

import Models.RuleSet;
import Models.User;

import java.io.Serializable;

/**
 * Created by dande on 15-6-2017.
 */
public class RuleEvent implements Serializable {
        private RuleSet finalRuleSet;
        private RuleSet hostRuleSet;
        private RuleSet joinedRuleSet;
        private User host;
        private User joined;


    public RuleEvent(RuleSet yourRuleset, RuleSet joinedRuleSet, User host) {
        this.hostRuleSet = yourRuleset;
        this.joinedRuleSet = joinedRuleSet;
        this.host = host;
    }

    public RuleSet getHostRuleset() {
        return hostRuleSet;
    }

    public void setHostRuleset(RuleSet yourRuleset) {
        this.hostRuleSet = yourRuleset;
    }

    public RuleSet getJoinedRuleSet() {
        return joinedRuleSet;
    }

    public void setJoinedRuleSet(RuleSet joinedRuleSet) {
        this.joinedRuleSet = joinedRuleSet;
    }


    public RuleSet getFinalRuleSet() {
        return finalRuleSet;
    }

    public void setFinalRuleSet(RuleSet finalRuleSet) {
        this.finalRuleSet = finalRuleSet;
    }

    public User getHost() {
        return host;
    }


    public User getJoined() {
        return joined;
    }

    public void setJoined(User joined) {
        this.joined = joined;
    }
}

