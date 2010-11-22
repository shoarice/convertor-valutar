package org.baltoaca.conv_valut.xml;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Parses an XML document from a specific source/uri
 * 
 * @author VlaD
 * 
 */
public class XmlSource {

	private URL uri;
	private Document document;
	private String name;

	public XmlSource(URL uri, String name) {
		this.uri = uri;
		this.name = name;
	}

	/**
	 * 
	 * @return a parsed xml, DOM API enabled document
	 * @throws ParserConfigurationException
	 *             if the parser is not configured properly
	 * @throws IOException
	 *             if the source is unreachable
	 * @throws SAXException
	 *             if the parsing failed
	 */
	public Document parseAndGetParsedDocument()
			throws ParserConfigurationException, SAXException, IOException {
		parseUri();
		return document;
	}

	private void parseUri() throws ParserConfigurationException, SAXException,
			IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder(); // throws a
																// ParserConfigurationException

		document = builder.parse(uri.openStream());
	}

	@Override
	public String toString() {
		String str = "";
		str += name + " @ " + uri;
		return str;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof XmlSource) {
			if (uri.equals(((XmlSource) o).uri)) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}
}
