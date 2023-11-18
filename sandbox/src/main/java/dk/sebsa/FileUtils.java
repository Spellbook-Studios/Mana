package dk.sebsa;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {
    /**
     * Loads a jar ressource file
     *
     * @param location The location of the file.
     * @throws IOException If file can't be found or loaded
     */
    public static InputStream loadFileFromJar(String location) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResourceAsStream(location);
    }
}
