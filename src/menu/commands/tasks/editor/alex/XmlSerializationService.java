package menu.commands.tasks.editor.alex;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlSerializationService implements Serializer {
    private static final File file = new File("./out/files.xml");
    private DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

    @Override
    public void save(List<String> files) {
        try {
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("Paths");
            document.appendChild(root);
            for (String file : files) {
                Element path = document.createElement("Path");
                path.appendChild(document.createTextNode(file));
                root.appendChild(path);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> load() {
        List<String> files = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            if (file.exists()) {
                Document document = documentBuilder.parse(file);
                NodeList paths = document.getElementsByTagName("Path");
                for (int index = 0; index < paths.getLength(); index++) {
                    files.add(paths.item(index).getTextContent());
                }
            } else {
                return null;
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return files;
    }
}
