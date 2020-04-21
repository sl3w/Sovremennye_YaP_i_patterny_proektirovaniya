package workMain;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ParserSAX implements IParser {
    @Override
    public void parsing(String inputFile, String outputFile) {
        try {
            // Создание фабрики и образца парсера
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            parser.parse(new File(inputFile), handler);
            System.out.println(handler.lastname);
            System.out.println(handler.nameList.toString());
            System.out.println(handler.markList.toString());
            System.out.println("documetAverage: " + handler.documetAverage);
            System.out.println("realAverage: " + handler.realAverage);

            if (handler.realAverage != handler.documetAverage) {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                Document doc = docBuilder.newDocument();
                Element student = doc.createElement("student");
                doc.appendChild(student);

                Attr attr = doc.createAttribute("lastname");
                attr.setValue(handler.lastname);
                student.setAttributeNode(attr);

                for (int i = 0; i < handler.nameList.size(); i++) {
                    Element subject1 = doc.createElement("subject");
                    student.appendChild(subject1);

                    Attr attr1 = doc.createAttribute("title");
                    attr1.setValue(handler.nameList.get(i));
                    subject1.setAttributeNode(attr1);
                    Attr attr2 = doc.createAttribute("mark");
                    attr2.setValue(handler.markList.get(i).toString());
                    subject1.setAttributeNode(attr2);
                }

                Element average = doc.createElement("average");
                average.appendChild(doc.createTextNode(String.valueOf(handler.realAverage)));
                student.appendChild(average);

                DOMSource domSource = new DOMSource(doc);
                StreamResult streamResult = new StreamResult(outputFile);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.transform(domSource, streamResult);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
