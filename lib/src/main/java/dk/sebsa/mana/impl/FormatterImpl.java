package dk.sebsa.mana.impl;

import dk.sebsa.mana.LogFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Default implementation of the LogFormatter
 *
 * @author sebs
 */
public class FormatterImpl implements LogFormatter {
    /**
     * The format for TRACE level messages
     */
    public final String formatTrace;
    /**
     * The format for NORMAL level messages
     */
    public final String formatLog;
    /**
     * The format for WARNING level messages
     */
    public final String formatWarn;
    /**
     * The format for ERROR level messages
     */
    public final String formatErr;
    private DateTimeFormatter dtf;
    private final boolean formatDate;

    /**
     * Creates a new FormatterImpl with specified log formats
     *
     * @param ft The format for trace level messages
     * @param fl The format for normal level messages
     * @param fw The format for warning level messages
     * @param fe The format for error level messages
     */
    public FormatterImpl(String ft, String fl, String fw, String fe) {
        this.formatLog = fl.replace("%ft", ft).replace("%fw", fw).replace("%fe", fe).replace("%esc","\u001B");
        this.formatTrace = ft.replace("%fl", fl).replace("%fw", fw).replace("%fe", fe).replace("%esc","\u001B");
        this.formatWarn = fw.replace("%fl", fl).replace("%ft", ft).replace("%fe", fe).replace("%esc","\u001B");
        this.formatErr = fe.replace("%fl", fl).replace("%fw", fw).replace("%ft", ft).replace("%esc","\u001B");

        // DTF Stuff
        formatDate = fl.contains("%d");
        if(formatDate) dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        else dtf = null;
    }

    /**
     * FormatterImpl with default log formats: (%s is the log string)
     * <ul>
     * <li> formatTrace = "TRC: %s"; </li>
     * <li> formatLog = "LOG: %s"; </li>
     * <li> formatWarn = "WARN: %s"; </li>
     * <li> formatErr = "ERR: %s"; </li>
     * </ul>
     */
    public FormatterImpl() {
        formatDate = false;
        formatTrace = "TRC: %s";
        formatLog = "LOG: %s";
        formatWarn = "WARN: %s";
        formatErr = "ERR: %s";
    }

    /**
     * Formats an object/string using the provided format
     *
     * @param format Format to use
     * @param o The object / string to format
     * @param className The classname of the object logging
     * @return The formatted object / string
     */
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
