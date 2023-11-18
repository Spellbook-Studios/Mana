package dk.sebsa.mana;

/**
 * Formats Objects / Strings at different log levels
 *
 * @author sebs
 */
public interface LogFormatter {
    /**
     * Formats an object / string using this formatters TRACE format
     * @param o The object / string to format
     * @return The formatted object / string
     */
    String formatTrace(Object o);
    /**
     * Formats an object / string using this formatters NORMAL format
     * @param o The object / string to format
     * @return The formatted object / string
     */
    String formatLog(Object o);
    /**
     * Formats an object / string using this formatters WARNING format
     * @param o The object / string to format
     * @return The formatted object / string
     */
    String formatWarn(Object o);
    /**
     * Formats an object / string using this formatters ERROR format
     * @param o The object / string to format
     * @return The formatted object / string
     */
    String formatErr(Object o);
}
