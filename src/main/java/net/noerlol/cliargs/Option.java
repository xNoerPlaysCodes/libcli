package net.noerlol.cliargs;

public class Option {
    private boolean shorthand = false;
    private String option = "";
    private String value = "";

    public Option(String option) {
        if (!option.substring(1).startsWith("-")) {
            this.shorthand = true;
            this.option = option.substring(1);
        } else {
            this.option = option.substring(2);
        }
    }

    public Option(String option, String value) {
        if (!option.substring(1).startsWith("-")) {
            this.shorthand = true;
            this.option = option.substring(1);
        } else {
            this.option = option.substring(2);
        }

        this.value = value;
    }

    public boolean hasValue() {
        return !(value.isEmpty());
    }

    public String getValue() {
        return value;
    }

    public String getOption() {
        return this.option;
    }

    public boolean isShorthand() {
        return this.shorthand;
    }
}
