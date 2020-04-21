package workMain;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;

public class SaxHandler extends DefaultHandler {
    String lastname = "";
    String lastElementName = "";
    ArrayList<Integer> markList = new ArrayList<Integer>();
    ArrayList<String> nameList = new ArrayList<String>();
    double documetAverage = 0;
    double realAverage = 0;

//    @Override
//    public void startDocument() {
//        // Тут будет логика реакции на начало документа
//        System.out.println("Start parse XML...");
//    }
//
//    @Override
//    public void endDocument() {
//        // Тут будет логика реакции на конец документа
//        System.out.println("End parse XML");
//    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        // Тут будет логика реакции на начало элемента
        lastElementName = qName;
        if (qName.equals("student")) {
            String lastname = attributes.getValue("lastname");
            this.lastname = lastname;
            System.out.println(lastname);
        } else
        if (qName.equals("subject")) {
            String name = attributes.getValue("title");
            int mark = Integer.parseInt(attributes.getValue("mark"));
            markList.add(mark);
            nameList.add(name);
            System.out.println(name + " –– " +mark);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // Тут будет логика реакции на текст между элементами
        String information = new String(ch, start, length);

        information = information.replace("\n", "").trim();

        if (!information.isEmpty()) {
            if (lastElementName.equals("average")){
                documetAverage = Double.parseDouble(information);
                int temp = 0;
                for (int i = 0; i < markList.size(); i++) {
                    temp+= markList.get(i);
                }
                this.realAverage = temp / markList.size();
            }
        }
    }
}
