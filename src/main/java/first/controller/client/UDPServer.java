package first.controller.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		try {
			DatagramSocket ser = new DatagramSocket(10005);
			byte[] rb = new byte[1024];
			DatagramPacket pac = new DatagramPacket(rb, rb.length);
			String rev = "";
			int i = 0;
			// 无数据则循环
			while (i == 0) {
				ser.receive(pac);
				i = pac.getLength();
				// 接收数据
				if (i > 0) {
					rev = new String(rb, 0, pac.getLength());
					System.out.println(rev);
					i = 0;
					;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
