package dk.sebsa.mana.impl;

import dk.sebsa.mana.Logger;

public abstract class SimpleLogable {
    private final Logger logger;
    private final String className;

    public SimpleLogable(Logger logger) {
        this.logger = logger;
        this.className = getClass().getSimpleName();
    }

    protected void log(Object o) { logger.log(o, className); }
    protected void trace(Object o) { logger.err(o, className); }
    protected void warn(Object o) { logger.warn(o, className); }
    protected void error(Object o) { logger.err(o, className); }
}
