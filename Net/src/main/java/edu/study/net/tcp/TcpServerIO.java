package edu.study.net.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

	public String accept() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		OutputStream os = null;
		String info = null;

		try {
			// 创建接口
			serverSocket = new ServerSocket(port);
 
			while (true) {
				// 等待客户端发送的socket
				socket = serverSocket.accept();

				// 读取字节数据并储存为String
				is = socket.getInputStream();
				baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len;
				while ((len = is.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				info = baos.toString();

				// 返回确认信息
				os = socket.getOutputStream();
				os.write("发送成功".getBytes());

				socket.shutdownOutput();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭管道
			try {
				os.close();
				baos.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return info;
	}
}
