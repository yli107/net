package edu.study.net.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TcpServerDemo02 {
	public static void main(String[] args) throws IOException {


		ServerSocket serverSocket = new ServerSocket(8888);

		Socket socket = serverSocket.accept();


		InputStream is = socket.getInputStream();


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
