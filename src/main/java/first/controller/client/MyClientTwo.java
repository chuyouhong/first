package first.controller.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyClientTwo {
	JFrame jf = new JFrame("聊天室客户端MyClientTwo");
	JTextArea jt = new JTextArea();
	DataOutputStream dos = null;
	JTextField jtf = new JTextField(15);

	public static void main(String[] args) {
		MyClientTwo c = new MyClientTwo();
		try {
			c.createForm();
			c.clientStart("192.168.10.123", 8888);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createForm() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().add(jt, BorderLayout.CENTER);

		JButton jb = new JButton("发送");
		SendButtonAction sendAction = new SendButtonAction();
		jb.addActionListener(sendAction);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jf.getContentPane().add(jp, BorderLayout.SOUTH);

		jf.setSize(300, 200);
		jf.setVisible(true);
	}

	// 创建客服端Socket，连接服务器
	public void clientStart(String ip, int port) throws Exception {

		Socket s = new Socket(ip, port);
		// 讲消息的输出流实例化，为后续发送消息做准备
		dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
		// 打开一个接收消息的线程
		new MySocketReadServer(s).start();
	}

	// 为图形窗体界面的发送按钮添加处理事件
	class SendButtonAction implements ActionListener {
		// 当用户单机发送按钮后,将输入的消息发送给服务器
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String msg = jtf.getText();
			jtf.setText("");
			if ("".equals(msg)) {
				JOptionPane.showMessageDialog(jf, "发送内容不能为空");
				return;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(jf, "发送失败，请重新尝试");
				e.printStackTrace();
			}
		}
	}

	// 定义一个线程类,封装接收消息功能
	class MySocketReadServer extends Thread {
		private Socket s;

		public MySocketReadServer(Socket s) {
			this.s = s;
		}

		// 时刻准备接收服务器发送过来的消息，并添加到显示窗口
		public void run() {
			try {
				DataInputStream dis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
				while (true) {
					String msg = jt.getText() + "\n\r" + dis.readUTF();
					jt.setText(msg);
					if ("88".equals(msg)) {
						break;
					}
				}
			} catch (Exception e) {
				System.out.println(s + "已退出聊天室");
			}
		}

	}
}
