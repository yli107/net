package edu.study.net.tcp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ClientInfoStatus;

public class TcpServerDemo02 {
	public static void main(String[] args) throws IOException {

		// 1.��������
		ServerSocket serverSocket = new ServerSocket(8888);

		// 2.�����ͻ��˵�����
		Socket socket = serverSocket.accept();

		// 3.��ȡ������
		InputStream is = socket.getInputStream();

		// 4.�ļ����
		File file = new File("receive(1).jpg");
		FileOutputStream fos = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			fos.write(buffer, 0, len);
		}
		
		fos.close();
		is.close();
		socket.close();
		serverSocket.close();

	}
}
