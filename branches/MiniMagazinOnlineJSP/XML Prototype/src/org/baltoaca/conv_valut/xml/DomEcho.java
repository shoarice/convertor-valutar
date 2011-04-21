package org.baltoaca.conv_valut.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomEcho {
	
	//declare a document reference which will "point" to the parsed document
	static Document document;
	
	public static void main(String args[]){
		
		//build a docbuilder factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//factory.setValidating(true);
		factory.setNamespaceAware(true);
		try {
			//get a doc builder instance
			DocumentBuilder builder = factory.newDocumentBuilder();
			//most important parse the xml document
			document = builder.parse("http://www.bnro.ro/nbrfxrates.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//a collection of nodes from the parsed doc
		NodeList nodeList = document.getElementsByTagName("*");
		for(int i=0;i<nodeList.getLength(); i++){
			//for each element
			Element e = (Element)nodeList.item(i);
			NodeList child = e.getChildNodes();
			System.out.println(e.getNodeName()+ " " 
					+ e.getAttributeNode("currency") + " " 
					+e.getAttributeNode("multiplier") + " " +
					child.item(0).getNodeValue());
		}
		
		//my own implementation
		//a collection of all the rate nodes
		NodeList rates = document.getElementsByTagName("Rate");
		System.out.println(rates.item(0).getChildNodes().item(0).getNodeValue());
		
		//a collection of all the Cube nodes, retrieves the date
		NodeList cube = document.getElementsByTagName("Cube");
		System.out.println(((Element) cube.item(0)).getAttributeNode("date"));
		
		
		
		
		
		
	}
	

}
