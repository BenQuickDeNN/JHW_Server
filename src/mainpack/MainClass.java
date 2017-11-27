package mainpack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 配合文本编辑器的服务器
 * @author Ben Quick
 *
 */
public class MainClass {

	/**
	 * 默认通信端口s
	 */
	final int Port = 4700;
	/**
	 * 文件保存目录
	 */
	final String SaveFileDirectory = "E:/JHW_DIR/";
	public MainClass(){
		runServer();
	}
	void runServer(){
		new NetworkThread().start();
	}
	/**
	 * 执行网络任务的线程
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
					String content = "";
					String line;
					while((line = contentReader.readLine()) != null){
						content += line;
					}
					SaveFile saveFile = XMLHelper.decodeXMLDoc(content);
					
					/* 保存文件 */
					File file = new File(SaveFileDirectory + saveFile.getFileName());
					FileWriter out = new FileWriter(file);
					out.write(content);
					out.close();
					//System.out.println(content);
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
