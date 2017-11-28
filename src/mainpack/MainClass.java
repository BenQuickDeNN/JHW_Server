package mainpack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ı��༭���ķ�����
 * @author Ben Quick
 *
 */
public class MainClass {

	/**
	 * Ĭ��ͨ�Ŷ˿�s
	 */
	final int Port = 4700;
	/**
	 * �ļ�����Ŀ¼
	 */
	final String SaveFileDirectory = "E:/JHW_DIR/";
	public MainClass(){
		runServer();
	}
	void runServer(){
		new NetworkThread().start();
	}
	/**
	 * ִ������������߳�
	 * @author Ben Quick
	 *
	 */
	class NetworkThread extends Thread{
		@SuppressWarnings("resource")
		public void run(){
			ServerSocket serverSocket = null;
			Socket receiveSocket = null;
			try{
				serverSocket = new ServerSocket(Port);
			}catch (Exception e) {
				e.printStackTrace();
			}
			while(true){
				try{
					receiveSocket = serverSocket.accept();
					System.out.println(receiveSocket.getLocalSocketAddress().toString());
					InputStream in = receiveSocket.getInputStream();
					InputStreamReader inReader = new InputStreamReader(in);
					BufferedReader contentReader = new BufferedReader(inReader);
					String CTRL = contentReader.readLine();// ������
					String GET_FILE_NAME = contentReader.readLine();// �ļ���
					
					System.out.println(CTRL + "\r\n" + GET_FILE_NAME);
					if(CTRL.equals(GlobalVar.CTRL_SEND)){
						String content = "";
						String line;
						while((line = contentReader.readLine()) != null){
							content += line;
						}
						SaveFile saveFile = XMLHelper.decodeXMLDoc(content);
					
						/* �����ļ� */
						File file = new File(SaveFileDirectory + saveFile.getFileName());
						FileWriter out = new FileWriter(file);
						out.write(content);
						out.close();
						//System.out.println(content);
						
					}else if(CTRL.equals(GlobalVar.CTRL_GET)){
						/* �����ļ� */
						File file = new File(SaveFileDirectory + GET_FILE_NAME);
						FileInputStream readStream = new FileInputStream(file);
						InputStreamReader filecontentReader = new InputStreamReader(readStream);
						BufferedReader bufferedReader = new BufferedReader(filecontentReader);
						String fileline;
						String filecontent = "";
						while((fileline = bufferedReader.readLine()) != null){
							filecontent += fileline;
						}
						bufferedReader.close();
						filecontentReader.close();
						readStream.close();
						SaveFile saveFile = XMLHelper.decodeXMLDoc(filecontent);
						PrintWriter fileWriter = new PrintWriter(receiveSocket.getOutputStream(), true);
						fileWriter.print(XMLHelper.encodeXMLDoc(saveFile) + "\r\n");// ���ļ������ͻ���
						fileWriter.close();
					}
					contentReader.close();
					inReader.close();
					in.close();
					receiveSocket.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			//if(!serverSocket.isClosed())serverSocket.close();
		}
	}
	public static void main(String[] args) {
		new MainClass();
	}

}
