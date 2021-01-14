package edu.study.net.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerIO {

	private static final int DEFAULT_PORT = 2077;

	private int port;

	public TcpServerIO(int port) {
		setPort(port);
	}

	public TcpServerIO() {
		setPort(DEFAULT_PORT);
	}

	public void setPort(int port) {
		if (port > 65535 || port < 0) {
			throw new IndexOutOfBoundsException("The port must be in range of 0 - 65535");
		}
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public String accept() throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
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
