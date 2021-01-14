package edu.study.net.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerIO {
	public String accept() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2077);
		Socket socket = serverSocket.accept();
		InputStream is = socket.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}

		baos.close();
		is.close();
		socket.close();
		serverSocket.close();
		return baos.toString();
	}
}
