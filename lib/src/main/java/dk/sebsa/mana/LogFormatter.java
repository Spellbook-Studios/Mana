package dk.sebsa.mana;

public interface LogFormatter {
    String formatTrace(Object o);
    String formatLog(Object o);
    String formatWarn(Object o);
    String formatErr(Object o);
}
