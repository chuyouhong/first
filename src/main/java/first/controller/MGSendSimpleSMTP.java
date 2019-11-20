package first.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class MGSendSimpleSMTP {

	public static void main(String args[]) throws Exception {

		Properties props = System.getProperties();
		props.put("mail.smtps.host", "smtp.mailgun.org");
		props.put("mail.smtps.auth", "true");

		Session session = Session.getInstance(props, null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("chuyh@jackfree.cn"));

		InternetAddress[] addrs = InternetAddress.parse("chuyh@medishare.cn", false);
		msg.setRecipients(Message.RecipientType.TO, addrs);

		msg.setSubject("Hell555o");
		msg.setText("Testin7777g some Mailgun awesomness");
		msg.setSentDate(new Date());

		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
		t.connect("smtp.mailgun.com", "postmaster@jackfree.cn", "a7654c74b15b861ba27f1009f1cd736e-116e1e4d-765da16f");
		t.sendMessage(msg, msg.getAllRecipients());

		System.out.println("Response: " + t.getLastServerResponse());

		t.close();
	}
}
