package edu.study.net.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo01 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			// 1.创建一个可使用的端口
			serverSocket = new ServerSocket(9999);
			
			// 2.等待客户端连接发送socket
			socket = serverSocket.accept();
			
			// 3.读取客户端发送过来的socket的消息
			is = socket.getInputStream();
			
			// 4.将bytes转成String
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			System.out.println(baos.toString());
			// 5.关闭InputStream, Socket和ServerSocket
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
