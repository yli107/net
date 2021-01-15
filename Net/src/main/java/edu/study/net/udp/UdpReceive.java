package edu.study.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceive {
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(8888);

		while (true) {
			// 准备接收包裹
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
			socket.receive(packet);

			byte[] data = packet.getData();
			String receiveString = (new String(data, 0, data.length)).trim();

			if (receiveString.trim().equals("/QUIT")) {
				break;
			}
			System.out.println(receiveString);
		}
		socket.close();
	}
}
