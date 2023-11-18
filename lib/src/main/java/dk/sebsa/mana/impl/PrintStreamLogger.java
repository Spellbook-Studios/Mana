package dk.sebsa.mana.impl;

import dk.sebsa.mana.LogFormatter;
import dk.sebsa.mana.Logger;

import java.io.PrintStream;

/**
 * Logs to the provided PrintStream e.g. System.out
 *
 * @author sebs
 */
public class PrintStreamLogger implements Logger {
    private final PrintStream printStream;
    /**
     * The formatter used when logging
     */
    public final LogFormatter formatter;

    /**
     * @param printStream PrintStream to log to
     * @param formatter The format to use when logging
     */
    public PrintStreamLogger(PrintStream printStream, LogFormatter formatter) {
        this.printStream = printStream;
        this.formatter = formatter;
    }

    private void print(String s) {
        printStream.println(s);
    }

    @Override
    public void trace(Object... messages) {
        for(Object o : messages) {
            print(formatter.formatTrace(o));
        }
    }

    @Override
    public void log(Object... messages) {
        for(Object o : messages) {
            print(formatter.formatLog(o));
        }
    }

    @Override
    public void warn(Object... messages) {
        for(Object o : messages) {
            print(formatter.formatWarn(o));
        }
    }

    @Override
    public void err(Object... messages) {
        for(Object o : messages) {
            print(formatter.formatErr(o));
        }
    }

    @Override
    public void close() {

    }
}
