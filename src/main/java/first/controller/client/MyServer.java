package first.controller.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MyServer {
	private Vector<Socket> vect = new Vector<Socket>();

	public static void main(String[] args) {
		MyServer server = new MyServer();
		try {
			server.startServer(8888);
		} catch (Exception e) {
			System.out.println("服务器端启动失败！");
			e.printStackTrace();
		}
	}

	// 启动服务器，并循环监听接收客户端的连接
	public void startServer(int port) throws Exception {
		ServerSocket ss = new ServerSocket(port);
		System.out.println("服务器已启动，等待客户端连接！");
		while (true) {
			// 监听并接收客户端的连接，注意该方法有阻塞性
			Socket s = ss.accept();
			// 讲客户端的Socket连接添加到一个Vector集合
			vect.add(s);
			System.out.println("客户端连接成功" + s);
			// 打开一个线程，为客户端的Sockect连接提供接收和转发服务
			new MySocketOpt(s).start();
		}

	}

	// 定义一个线程，提供接收和转发服务
	class MySocketOpt extends Thread {
		private Socket s;

		public MySocketOpt(Socket s) {
			this.s = s;
		}

		public void run() {
			try {
				DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
				while (true) {
					// 等待接收客户端发送的消息
					String msg = dis.readUTF();
					System.out.println("服务器接收到："+s.getInetAddress().getHostName()+s.getInetAddress().getHostAddress() + msg);

					// 遍历集合中的Socket连接，向外妆发消息
					for (Socket tmp_s : vect) {
					//	if (tmp_s != s) {
							DataOutputStream dos = new DataOutputStream(
									new BufferedOutputStream(tmp_s.getOutputStream()));
							dos.writeUTF(msg);
							dos.flush();
				//		}
					}
					if ("88".equals(msg)) {
						break;
					}
				}

			} catch (Exception e) {
				System.out.println(s + "已退出聊天室");
				vect.remove(s);
			}
		}
	}
}
