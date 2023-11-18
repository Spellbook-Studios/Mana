/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dk.sebsa;

import dk.sebsa.mana.Logger;

/**
 * Utility functions and variables for using mana
 * @author sebs
 */
public class Mana {
    /**
     * The current Mana version
     */
    public static final String VERSION = "1.0d-SNAPSHOT";

    /**
     * Logs useful system info to the logger provided
     * @param l Logger to log to
     */
    public static void logSystemInfo(Logger l) {
        l.log("----------= SYSINFO =----------");
        l.log("MANA: " + VERSION);
        l.log("JAVA: V" + System.getProperty("java.version") + " from " + System.getProperty("java.vendor"));
        l.log("OS: " + System.getProperty("os.name") + " V" + System.getProperty("os.version"));
        l.log("DIR: " + System.getProperty("user.dir"));
        l.log("PRC: " + System.getProperty("os.arch") + " " + Runtime.getRuntime().availableProcessors() + " Cores");
        l.log("----------= SYSINFO =----------");
    }
}
