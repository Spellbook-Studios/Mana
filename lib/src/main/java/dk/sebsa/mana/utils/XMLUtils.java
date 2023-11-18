package dk.sebsa.mana.utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utils for loading XML files
 */
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
            throw new RuntimeException("Failed to create XML Parser");
        }
    }

    /**
     * Loads an XML document from a file / inputstream
     *
     * @param is File to laod
     * @return The loaded document
     * @throws IOException If any IO error occurs
     * @throws SAXException If any parsing error occurs
     */
    public static Document loadDocumentFromInputStream(InputStream is) throws IOException, SAXException {
        init();

        return db.parse(is);
    }
}
