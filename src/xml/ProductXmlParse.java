package xml;

import org.dom4j.DocumentException;


public class ProductXmlParse {

	public static void main(String[] args) {
		String file = "src/xml/getProduct.xml";
		try {
			for(int i = 0; i <= XmlUtil.getTestDataNum(file); i++){
				String xPathPrefix = "//root/product[" + i + "]/";
				System.out.println(XmlUtil.getNodeValue(file, xPathPrefix + "productId"));
			}
			String xpath = "//root/product[1]/specs/spec/specDescription";
			System.out.println(XmlUtil.getNodeValue(file, xpath));
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
