package Models;

import java.io.Serializable;

/**
 * Created by Danny on 30-5-2017.
 */
public class RuleSet implements Serializable{
    private boolean wildFormat;
    private String Extra;

    public RuleSet(boolean wildFormat, String extra)  {
        this.wildFormat = wildFormat;
        Extra = extra;
    }

    public boolean getFormat() {
        return wildFormat;
    }

    public void setFormat(boolean wildFormat) {
        this.wildFormat = wildFormat;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }

    public boolean equals(RuleSet ruleSet){
        if(this.wildFormat ==ruleSet.wildFormat&&this.getExtra() ==ruleSet.getExtra()){
            return true;
        }
        return false;
    }
}
