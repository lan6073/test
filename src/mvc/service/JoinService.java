package mvc.service;

import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class JoinService {
	@Autowired
	JavaMailSender sender;
	/*
	 * Ư�� �̸��� �ּҷ� ����Ű�� ������ ����� ���鲨��.
	 * java mail api�� ���� ���Ϻ����� ����.
	 */
	
	public boolean sendAuthKey(String email) {
		String[] uuids = UUID.randomUUID().toString().split("-");
		String key = uuids[0]+"-"+uuids[1];
		MimeMessage message = sender.createMimeMessage();
		try {
			message.addRecipients(RecipientType.TO, email);
			message.setSubject("����Ű�Դϴ�.");
			String text = "<h3>����Ű</h3>";
			text +="<p>���۹��� ����Ű <a href=\"#\">"+ key+"</a>�� �Է����ּ���";
			
			message.setContent(text, "text/html;charset=utf-8");
			
			sender.send(message);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}