package mainpack;

import javax.swing.filechooser.FileSystemView;

/**
 * ȫ�ֱ���
 * @author Ben Quick
 *
 */
public class GlobalVar {

	public GlobalVar(){
		initFilePath();
	}
	/* 
	 * Frame����
	 *  */
	public final static String DefaultTitle = "TextEditor";
	public final static int DefaultWidth = 800;
	public final static int DefaultHeight = 600;
	/**
	 * ��ǰ�ļ�·��
	 */
	private String FilePath;
	/**
	 * ��ʼ��·����Ĭ��Ϊ�ҵ��ĵ�
	 */
	private void initFilePath(){
		FileSystemView fsv = FileSystemView.getFileSystemView();
		FilePath = fsv.getDefaultDirectory().getPath() + "/�½��Զ����ĵ�." + FileExtendsionName;
	}
	public String getFilePath(){return FilePath;}
	public void setFilePath(String FilePath){this.FilePath = FilePath;}
	
	/**
	 * �ļ���չ��
	 */
	public final static String FileExtendsionName = "mydoc";
	/**
	 * �ļ�������
	 */
	public final static String FileTypeName = "�Զ����ĵ�(*.mydoc)";
	/**
	 * ͼƬ������
	 */
	public final static String ImageFileTypeName = "λͼ(*.bmp)";
	/**
	 * ͼƬ�ļ���չ��
	 */
	public final static String ImageExtendsionName = "bmp";
	/**
	 * ���Ϳ�����
	 */
	public final static String CTRL_SEND = "SEND";
	/**
	 * ��ȡ������
	 */
	public final static String CTRL_GET = "GET";
}
