package pe.com.challengesuscribers.service.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.challengesuscribers.request.RequestSendMailDTO;
import pe.com.challengesuscribers.service.EmailServiceProvider;

@Slf4j
@Service
public class SmtpServiceImpl implements EmailServiceProvider {

	@Value("${challenge.mail.login.username}")
	private String username;

	@Value("${challenge.mail.login.password}")
	private String password;

	@Value("${challenge.mail.smtp.host}")
	private String host;

	@Value("${challenge.mail.smtp.socketFactory.socketFactory}")
	private String socketFactory;

	@Value("${challenge.mail.smtp.socketFactory.class}")
	private String socketFactoryClass;

	@Value("${challenge.mail.smtp.auth}")
	private String auth;

	@Value("${challenge.mail.smtp.port}")
	private String port;

	@Value("${challenge.mail.smtp.starttls.enable}")
	private String enable;

	@Override
	public boolean sendEmail(RequestSendMailDTO requestSendMailDTO) {

		log.info("sendEmail {}", password);

		Session session = createSession();

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(requestSendMailDTO.getFrom()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(String.join(",", requestSendMailDTO.getTo())));
			message.setRecipients(Message.RecipientType.CC, InternetAddress
					.parse(requestSendMailDTO.getCc().size() > 0 ? String.join(",", requestSendMailDTO.getCc()) : ""));
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(
					requestSendMailDTO.getBcc().size() > 0 ? String.join(",", requestSendMailDTO.getBcc()) : ""));
			message.setSubject(requestSendMailDTO.getSubject());
			message.setText(requestSendMailDTO.getMessage());

			Multipart multipart = new MimeMultipart();

			log.info("host {}", host);
			log.info("adding body part text");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(requestSendMailDTO.getMessage(), "text/html");
			multipart.addBodyPart(messageBodyPart);

			log.info("adding body part multipart");

			message.setContent(multipart);

			log.info("sending...");
			Transport.send(message);

			log.info("SMTP email sent");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;

		} finally {
			log.info("finished!");
		}
	}

	private Session createSession() {
		Properties props = new Properties();

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", socketFactory);
		props.put("mail.smtp.socketFactory.class", socketFactoryClass);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", enable);

		log.info("start session");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});

		log.info("session started");

		return session;
	}
}