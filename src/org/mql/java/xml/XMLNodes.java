package org.mql.java.xml;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLNodes {

	private Node node;

	public XMLNodes(Node node) {
		super();
		this.node = node;
	}

	public XMLNodes(String source) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(source);
			node = document.getFirstChild();
			while (node.getNodeType() != Node.ELEMENT_NODE) {
				node = node.getNextSibling();
			}
		} 
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public XMLNodes[] children() {
		Vector<XMLNodes> nodes = new Vector<XMLNodes>();
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				nodes.add(new XMLNodes(list.item(i)));
			}
		}
		return nodes.toArray(new XMLNodes[nodes.size()]);
	}
	
	public XMLNodes child(String name) {
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i).getNodeName().equals(name)) {
				return new XMLNodes(list.item(i));
			}
		}
		return null;
	}
	
	public String value() {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			return node.getFirstChild().getNodeValue();
		}
		return node.getNodeValue();
	}
	
	public String name() {
		return node.getNodeName();
	}
	
	public boolean isElement() {
		return (node.getNodeType() == Node.ELEMENT_NODE);
	}
	
	public String attribute(String name) {
		NamedNodeMap atts = node.getAttributes();
		return atts.getNamedItem(name).getNodeValue();
	}
	
	public int intAttribute(String name) {
		NamedNodeMap atts = node.getAttributes();
		try {
			return Integer.parseInt(atts.getNamedItem(name).getNodeValue());
		}
		catch (Exception e) {
			return -1;
		}
	}
	
	public void print() {
		System.out.println(node.getNodeName() + " , " + node.getNodeType()
								+ ", " + node.getNodeValue());
	}

}
