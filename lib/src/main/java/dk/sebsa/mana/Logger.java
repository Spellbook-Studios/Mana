package dk.sebsa.mana;

/**
 * Cmon. It logs with at 4 different log levels
 *
 * @author sebs
 */
public interface Logger {
    /**
     * Logs messages at the TRACE level
     * @param messages The objects / strings to log
     */
    void trace(Object... messages);
    /**
     * Logs messages at the NORMAL level
     * @param messages The objects / strings to log
     */
    void log(Object... messages);
    /**
     * Logs messages at the WARNING level
     * @param messages The objects / strings to log
     */
    void warn(Object... messages);
    /**
     * Logs messages at the ERROR level
     * @param messages The objects / strings to log
     */
    void err(Object... messages);
    /**
     * Should close all resources used by the logger
     */
    void close();
}
