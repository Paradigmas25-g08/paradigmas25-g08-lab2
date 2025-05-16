package parser;

import java.io.StringReader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Map;
import java.io.ByteArrayInputStream;

/* Esta clase implementa el parser de feed de tipo rss (xml)
 

    https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm,
*/


public class RssParser extends GeneralParser{

    public ArrayList<Map<String,String>> getItems(String feedRss) throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {

        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();

        StringBuilder xmlBuilder = new StringBuilder(); 
        xmlBuilder.append(feedRss);
        ByteArrayInputStream input = new ByteArrayInputStream( xmlBuilder.toString().getBytes("UTF-8"));

        Document xmldoc = docBuilder.parse(input);

        Element element = xmldoc.getDocumentElement();
        System.out.println("Root element name is "+element.getTagName());

        //Getting the child elements List
        NodeList nList = element.getChildNodes();

        //Iterating through all the child elements of the root
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeName() == "item") {
               Element eElement = (Element) nNode;
               System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
               System.out.println("Description : " + eElement.getElementsByTagName("description").item(0).getTextContent());
               System.out.println("Publication Date : " + eElement.getElementsByTagName("pubDate").item(0).getTextContent());
               System.out.println("Link : " + eElement.getElementsByTagName("link").item(0).getTextContent());
            }

        }

        return null;

    }
}