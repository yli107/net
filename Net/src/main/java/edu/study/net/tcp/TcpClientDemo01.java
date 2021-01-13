package edu.study.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClientDemo01 {
	public static void main(String[] args) {
		InetAddress inetAddress = null;
		Socket socket = null;
		OutputStream os = null;
		try {
			inetAddress = InetAddress.getByName("10.1.15.113/24");
			socket = new Socket(inetAddress, 9999);
			os = socket.getOutputStream();
			os.write("Hello MFK".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
