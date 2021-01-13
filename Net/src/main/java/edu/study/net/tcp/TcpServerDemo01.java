package edu.study.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerDemo01 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		InputStream is = null;
		try {
			serverSocket = new ServerSocket(9999);
			Socket accept = serverSocket.accept();
			is = accept.getInputStream();
			byte[] buffer = new byte[10];
			int len;
			StringBuilder sb = new StringBuilder();
			while ((len = is.read(buffer)) != -1) {
				sb.append(new String(buffer, 0, len));
			}
			System.out.println(sb.toString());

			accept.close();
			is.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
