package mainpack;

/**
 * ���ڱ�������ļ�
 * @author Ben Quick
 *
 */
public class SaveFile {
	/**
	 * �ı�����
	 */
	private String TextContent;
	/**
	 * �����ı�����
	 * @param TextContent
	 */
	public void setTextContent(String TextContent){
		this.TextContent = TextContent;
	}
	/**
	 * ����ı�����
	 * @return
	 */
	public String getTextContent(){
		return TextContent;
	}
	/**
	 * ��������
	 */
	private String FontType;
	/**
	 * ������������
	 * @param FontType
	 */
	public void setFontType(String FontType){
		this.FontType = FontType;
	}
	/**
	 * ��ȡ��������
	 * @return
	 */
	public String getFontType(){
		return FontType;
	}
	/**
	 * ͼƬbase64��
	 */
	private String ImageBase64;
	/**
	 * ����ͼƬbase64��
	 * @param ImageBase64
	 */
	public void setImageBase64(String ImageBase64){
		this.ImageBase64 = ImageBase64;
	}
	/**
	 * ��ȡͼƬbase64��
	 * @return
	 */
	public String getImageBase64(){
		return ImageBase64;
	}
	/**
	 * ������IP��ַ
	 */
	private String IPv4Address;
	/**
	 * ����IP��ַ
	 * @param IPv4Address
	 */
	public void setIPAddress(String IPv4Address){
		this.IPv4Address = IPv4Address;
	}
	/**
	 * ��ȡIP��ַ
	 * @return
	 */
	public String getIPAddress(){
		return IPv4Address;
	}
	/**
	 * ͨ�Ŷ˿�
	 */
	private int Port;
	/**
	 * ����ͨ�Ŷ˿�
	 * @param Port
	 */
	public void setPort(int Port){
		this.Port = Port;
	}
	/**
	 * ��ȡ�˿�
	 */
	public int getPort(){
		return Port;
	}
	/**
	 * �ļ���
	 */
	private String FileName;
	/**
	 * �����ļ���
	 * @param FileName
	 */
	public void setFileName(String FileName){
		this.FileName = FileName;
	}
	/**
	 * ��ȡ�ļ���
	 * @return
	 */
	public String getFileName(){
		return FileName;
	}
}
