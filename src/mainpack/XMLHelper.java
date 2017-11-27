package mainpack;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * XML����
 * @author Ben Quick
 *
 */
public class XMLHelper {

	/**
	 * ����XML�ĵ�
	 * @param content ����
	 * @return XML�ַ���
	 */
	public static String encodeXMLDoc(SaveFile content){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(out);
		xmlEncoder.writeObject(content);
		xmlEncoder.close();
		String xmlString = out.toString();
		return xmlString;
	}
	/**
	 * ��ȡXML�ĵ�
	 * @param xmlContent ����
	 * @return �ļ�����
	 */
	public static SaveFile decodeXMLDoc(String xmlContent){
		ByteArrayInputStream in = new ByteArrayInputStream(xmlContent.getBytes());
		XMLDecoder xmlDecoder = new XMLDecoder(in);
		SaveFile saveFile = (SaveFile)xmlDecoder.readObject();
		xmlDecoder.close();
		return saveFile;
	}
}
