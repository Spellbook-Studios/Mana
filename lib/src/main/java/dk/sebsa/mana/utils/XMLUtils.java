package dk.sebsa.mana.utils;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class XMLUtils {
    private static DocumentBuilder db;

    private static boolean init = false;
    private static void init() {
        if(init) return;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            init = true;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static Document loadDocumentFromGenericFileLocation(String f) throws IOException {
        init();

        try {
            if(f.startsWith("/")) {
                f = f.replaceFirst("/", "");
                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                InputStream inputStream = classLoader.getResourceAsStream(f);

                return db.parse(inputStream);
            } else {
                File file = new File(f);

                return db.parse(file);
            }
        } catch (Exception e) {
            throw new FileNotFoundException("Mana, XMLUtils: Couldn't find logger file, " + f);
        }
    }
}
