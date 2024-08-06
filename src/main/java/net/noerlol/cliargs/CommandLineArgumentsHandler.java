package net.noerlol.cliargs;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandLineArgumentsHandler {
    private final ArrayList<Option> options = new ArrayList<>();
    private final ArrayList<String> valueOptions = new ArrayList<>();

    public CommandLineArgumentsHandler(String[] args, String... optionsWithValue) {
        valueOptions.addAll(Arrays.asList(optionsWithValue));
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (valueOptions.contains(arg)) {
                valueOptions.remove(arg);
                options.add(new Option(arg, args[i + 1]));
            } else {
                options.add(new Option(arg));
            }
        }
    }

    public ArrayList<Option> getOptions() {
        return this.options;
    }

    public boolean isEnabled(String option, boolean shorthand) {
        for (Option opt : options) {
            if (opt.getOption().equals(option) && opt.isShorthand() == shorthand) {
                return true;
            }
        }
        return false;
    }

    public Option getOption(String optionName) {
        for (Option opt : options) {
            if (opt.getOption().equals(optionName)) {
                return opt;
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return options.isEmpty();
    }
}
