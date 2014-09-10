package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * XML util
 * 
 * @author June Zhang
 * 
 *         2012-7-3
 */
public class XmlUtil {

	/**
	 * @param xmlFilePath
	 *            xml file path
	 * @return Document object
	 */
	public static Document parse(String xmlFilePath) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlFilePath);
		return document;
	}

	/**
	 * get node value by xpath
	 * 
	 * @param xmlFilePaht
	 * @param xpath
	 * @return
	 */
	public static String getNodeValue(String xmlFilePath, String xpath)
			throws DocumentException {
		Document document = parse(xmlFilePath);
		Node node = document.selectSingleNode(xpath);
		if (node != null) {
			return node.getText();
		}
		return "";
	}

	public static String XmlToString(Document document) {
		return document.asXML();
	}

	public static void updateXMLFileAttribute(String xmlFile, String xmlFilePath,
			String attibuteName, String attibuteValue) {

//		Document document;
//		try {
//
//			SAXReader saxReader = new SAXReader();
//			document = saxReader.read(new File(xmlFile));
//			List list = document.selectNodes(xmlFilePath + "/@" + attibute);
//			Iterator iter = list.iterator();
//			if (iter.hasNext()) {
//				Attribute attribute = (Attribute) iter.next();
//				
//				return attribute.getValue();
//			} else {
//				return "";
//			}
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "";
//		}
		
		
		Document document;
		try {
			document = parse(xmlFile);
			Element noteElement=(Element)document.selectSingleNode(xmlFilePath); 
			 Attribute attribute = noteElement.attribute(attibuteName); 
			 if(attribute!=null) 
			   { 
			   noteElement.remove(attribute); 
			   noteElement.addAttribute(attibuteName, attibuteValue); 
			   OutputFormat   format   =   OutputFormat.createPrettyPrint(); 
	            format.setEncoding( "UTF-8"); 

	               XMLWriter writer = new XMLWriter(new FileOutputStream(new File(xmlFile)),format); 

	               writer.write(document); 

	               writer.close(); 


			   } 


		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	/**
	 * make document to String
	 * 
	 * @param text
	 * @return
	 */
	public static Document StringToDocument(String text) {
		try {
			return DocumentHelper.parseText(text);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void parseNode(Element root) throws DocumentException {

		List<Element> list = root.elements();
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (Element entity : list) {
			// 判断节点类型是否带有文本类型、
			if (entity.isTextOnly()) {
				hashMap.put(entity.getName(), entity.getText());
			} else {
				hashMap = new HashMap<String, String>();
				parseNode(entity);
			}
		}
	}

	public static Element getRoot(String xmlFilePath) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlFilePath);
		Element root = document.getRootElement();
		return root;
	}

	public static String getTextFile(String name) {
		return getFile(name, "TextFile");
	}

	public static String getXpathFile(String name) {
		return getFile(name, "XPathXmlFile");
	}

	public static String getTestDataFile(String name) {
		return getFile(name, "TestDataFile");
	}

	public static ArrayList<String> getTestDataFiles(String name) {
		return getFiles(name, "TestDataFile");
	}

	public static String getFile(String name, String xmlName) {
		try {
			Element root = getRoot("src/main/resources/Mapping.xml");
			List<Element> list = root.elements();
			for (Element entity : list) {
				// 判断节点类型是否带有文本类型、
				if (entity.getName().equals(name)) {
					List<Element> childs = entity.elements();
					for (Element child : childs) {
						if (child.getName().equals(xmlName)) {
							return child.getText().trim();
						}
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<String> getFiles(String name, String xmlName) {
		ArrayList<String> testDataFileNames = new ArrayList<String>();
		try {
			Element root = getRoot("src/main/resources/Mapping.xml");
			List<Element> list = root.elements();
			for (Element entity : list) {
				// 判断节点类型是否带有文本类型、
				if (entity.getName().equals(name)) {
					List<Element> childs = entity.elements();
					for (Element child : childs) {
						if (child.getName().startsWith(xmlName)) {
							testDataFileNames.add(child.getText().trim());
						}
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDataFileNames;
	}

	public static String getXmlPath(String file, String tag) {
		Element root;
		try {
			root = getRoot(file);
			List<Element> list = root.elements();
			for (Element entity : list) {
				if (entity.getName().equals(tag)) {
					return entity.getText().trim();
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getTestDataString(String file, String tag) {
		Element root;
		try {
			root = getRoot(file);
			List<Element> list = root.elements();
			for (Element entity : list) {
				List<Element> dataList = entity.elements();
				for (Element testData : dataList) {
					if (testData.getName().equals(tag)) {
						return entity.getText().trim();
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getXpath(String className, String xmlPathName) {
		// System.out.println(className + ":className");
		String xPathFile = XmlUtil.getXpathFile(className);

		// System.out.println(xPathFile + ":xPathFile");
		return XmlUtil.getXmlPath(
				"src/main/resources/elementManage/xpathConfigXml/" + xPathFile,
				xmlPathName);
	}

	public static String getText(String textName, String className) {
		// System.out.println(className + ":className");
		String textFile = XmlUtil.getTextFile(className);

		// System.out.println(textFile + ":textFile");
		return XmlUtil.getXmlPath("src/main/resources/testProvider/textField/"
				+ textFile, textName);
	}

	public static String getTestData(String testDataName, String className) {
		// System.out.println(className + ":className");
		String testDataFile = XmlUtil.getTestDataFile(className);

		// System.out.println(testDataFile + ":testDataFile");
		return XmlUtil.getXmlPath("src/main/resources/testProvider/testData/"
				+ testDataFile, testDataName);
	}

	public static int getTestDataNum(String testDataFile) {
		int testDataNum = 0;
		try {
			Element root = getRoot(testDataFile);
			List<Element> list = root.elements();
			if (list != null) {
				testDataNum = list.size();
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDataNum;
	}

	public static int getTestDataNum(String testDataFile, String testDataName) {
		int testDataNum = 0;
		try {
			Element root = getRoot(testDataFile);
			List<Element> list = root.elements();
			if (list != null) {
				for (Element element : list) {
					if (element.getName().trim().endsWith(testDataName)) {
						testDataNum++;
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testDataNum;
	}

	public static String getTestDataFileFullName(String className) {
		return "src/main/resources/testProvider/testData/"
				+ getTestDataFile(className);
	}

	public static int getIntegerFromXml(String xmlFile, String xPathPrefix,
			String item) {
		try {
			// System.out.println(xPathPrefix + item);
			if (!XmlUtil.getNodeValue(xmlFile, xPathPrefix + item).equals("")) {
				// System.out.println(Integer.parseInt(XmlUtil.getNodeValue(xmlFile,
				// xPathPrefix + item)));
				return Integer.parseInt(XmlUtil.getNodeValue(xmlFile,
						xPathPrefix + item));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getStringFromXml(String xmlFile, String xPathPrefix,
			String item) {
		try {
			return XmlUtil.getNodeValue(xmlFile, xPathPrefix + item);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * get node value by xpath
	 * 
	 * @param xmlFilePaht
	 * @param xpath
	 * @return
	 */
	public static String getNodeAttribute(String xmlFilePath, String xpath,
			String getNodeAttr) throws DocumentException {

		Document document = parse(xmlFilePath);
		XPath x = document.createXPath(xpath);
		Element element = (Element) x.selectSingleNode(document);
		String value = element.attributeValue(getNodeAttr);
		return value;
	}
	
	
	public static void main(String[] args){
		
//		for(int i = 0; i<=5;i++){
//			updateXMLFileAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[1]", "id","1");
//			updateXMLFileAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[2]", "id","2");
//			updateXMLFileAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[3]", "id","3");
//			updateXMLFileAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[4]", "id","4");
//			updateXMLFileAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[5]", "id","5");
//			
//			try {
//				System.out.println(getNodeAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[1]", "id"));
//				System.out.println(getNodeAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[2]", "id"));
//				System.out.println(getNodeAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[3]", "id"));
//				System.out.println(getNodeAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[4]", "id"));
//				System.out.println(getNodeAttribute(ITestDataFilePath.TESTDATA_PATH_GIFT +"giftAddFVF.xml","//giftAdd/addItem[5]", "id"));
//			} catch (DocumentException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}

}
