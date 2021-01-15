package edu.study.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServerDemo01 {
	public static void main(String[] args) throws IOException {
		// 开放端口
		DatagramSocket socket = new DatagramSocket(8080);
  
		// 接受数据包
		byte[] bytes = new byte[1024];
		DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);

		socket.receive(packet);// 阻塞接受
		System.out.println(new String(packet.getData(), 0, packet.getLength()));
		// 关闭连接
		socket.close();
	}
}
