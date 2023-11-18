package dk.sebsa.mana.impl;

import dk.sebsa.mana.utils.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class FormatBuilder {
    private String fFormat = "%s";
    private String fTraceFormat = "%fi";
    private String fWarnFormat = "%fi";
    private String fErrorFormat = "%fi";

    public FormatterImpl build() {
        // Generate Logger
        FormatterImpl formatter = new FormatterImpl(fTraceFormat, fFormat, fWarnFormat, fErrorFormat);

        // Reset
        fFormat = "%s";
        fTraceFormat = "%fi";
        fWarnFormat = "%fi";
        fErrorFormat = "%fi";

        // Return Logger
        return formatter;
    }

    public FormatterImpl buildFromFile(InputStream is) throws IOException, SAXException {
        Document doc = XMLUtils.loadDocumentFromInputStream(is);

        Element loggerElement = doc.getDocumentElement();
        loggerElement.normalize();
        if(!loggerElement.getNodeName().equals("logger")) throw new RuntimeException("Root element of file was not \"logger\"");

        // Read all logger settings
        NodeList nodeList = loggerElement.getChildNodes();
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                switch (node.getNodeName()) {
                    case "format" -> fFormat = element.getTextContent();
                    case "traceFormat" -> fTraceFormat = element.getTextContent();
                    case "warnFormat" -> fWarnFormat = element.getTextContent();
                    case "errorFormat" -> fErrorFormat = element.getTextContent();
                    default -> {}
                }
            }
        }

        return build();
    }
}
