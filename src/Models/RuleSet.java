package Models;

/**
 * Created by Danny on 30-5-2017.
 */
public class RuleSet {
    private String format;
    private String Extra;

    public RuleSet(String format, String extra) {
        this.format = format;
        Extra = extra;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }
}
