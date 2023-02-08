package dk.sebsa.mana;

public interface Logger {
    void trace(Object... messages);
    void log(Object... messages);
    void warn(Object... messages);
    void err(Object... messages);
    void close();
}
