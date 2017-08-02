package first.controller.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPclient {

	public static void main(String[] args) {
		try{
			//指定端口号，避免与其他应用程序发发生冲突
			DatagramSocket cli=new DatagramSocket(10002);
			byte[] sb=new byte[1024];
			String sen ="UDP方式发送数据";
			sb=sen.getBytes();
			DatagramPacket pac=new DatagramPacket(sb, sb.length,InetAddress.getByName("localhost"),10005);
			cli.send(pac);	
		}catch(SocketException se){
			se.printStackTrace();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}

}
