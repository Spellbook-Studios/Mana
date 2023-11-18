package dk.sebsa.mana.utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

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

    public static Document loadDocumentFromInputStream(InputStream is) throws IOException, SAXException {
        init();

        return db.parse(is);
    }
}
