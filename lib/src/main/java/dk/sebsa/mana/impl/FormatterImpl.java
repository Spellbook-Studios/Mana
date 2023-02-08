package dk.sebsa.mana.impl;

import dk.sebsa.mana.LogFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterImpl implements LogFormatter {
    public String formatTrace = "TRC: %s";
    public String formatLog = "LOG: %s";
    public String formatWarn = "WARN: %s";
    public String formatErr = "ERR: %s";
    private DateTimeFormatter dtf;
    private final boolean formatDate;

    public FormatterImpl(String ft, String fl, String fw, String fe) {
        this.formatLog = fl.replace("%ft", ft).replace("%fw", fw).replace("%fe", fe);
        this.formatTrace = ft.replace("%fl", fl).replace("%fw", fw).replace("%fe", fe);
        this.formatWarn = fw.replace("%fl", fl).replace("%ft", ft).replace("%fe", fe);
        this.formatErr = fe.replace("%fl", fl).replace("%fw", fw).replace("%ft", ft);

        // DTF Stuff
        formatDate = fl.contains("%d");
        if(formatDate) dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        else dtf = null;
    }

    public FormatterImpl() {
        formatDate = false;
    }

    public String format(String format, Object o, String className) {
        String result = format.replace("%s", o.toString())
                .replace("%c", className)
                .replace("%t", Thread.currentThread().getName());

        if(formatDate) return result.replace("%d", dtf.format(LocalDateTime.now()));
        else return result;
    }

    @Override
    public String formatTrace(Object o) {
        return format(formatTrace, o, "Mana");
    }

    @Override
    public String formatLog(Object o) {
        return format(formatLog, o, "Mana");
    }

    @Override
    public String formatWarn(Object o) {
        return format(formatWarn, o, "Mana");
    }

    @Override
    public String formatErr(Object o) {
        return format(formatErr, o, "Mana");
    }
}
