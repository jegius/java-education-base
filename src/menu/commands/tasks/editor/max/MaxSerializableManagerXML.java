package menu.commands.tasks.editor.max;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaxSerializableManagerXML implements MaxSerializableManager {

    private File fileXml = new File("./out/listFiles.xml");

    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;

    public MaxSerializableManagerXML() {
        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(List<String> paths) {
        try {
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("paths");
            document.appendChild(root);

            for (String filePath : paths) {
                Element path = document.createElement("path");
                root.appendChild(path);
                path.appendChild(document.createTextNode(filePath));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(fileXml);

            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> load() {
        List<String> files = new ArrayList<>();
        if (fileXml.exists()) {
            try {
                Document document = documentBuilder.parse(fileXml);
                NodeList nodeList = document.getElementsByTagName("path");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    files.add(nodeList.item(i).getTextContent());
                }
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File doesn't exist!");
        }
        return files;
    }
}
