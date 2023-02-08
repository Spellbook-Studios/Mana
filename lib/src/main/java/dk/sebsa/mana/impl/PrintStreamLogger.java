package dk.sebsa.mana.impl;

import dk.sebsa.mana.LogFormatter;
import dk.sebsa.mana.Logger;

import java.io.PrintStream;

public class PrintStreamLogger implements Logger {
    private final PrintStream printStream;
    public final LogFormatter formatter;

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
