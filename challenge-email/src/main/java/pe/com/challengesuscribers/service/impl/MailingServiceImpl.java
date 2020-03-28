package pe.com.challengesuscribers.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;
import pe.com.challengesuscribers.request.RequestSendMailDTO;
import pe.com.challengesuscribers.service.FactoryEmailServiceProvider;
import pe.com.challengesuscribers.service.MailingService;
import pe.com.challengesuscribers.service.ServiceProvider;

@Service
public class MailingServiceImpl implements MailingService {

	@Autowired
	private FactoryEmailServiceProvider factoryEmailServiceProvider;

	@Override
	public void sendMail(ReqSuscriptionDTO requestSuscribtion) {

		RequestSendMailDTO request = RequestSendMailDTO.builder().bcc(null).cc(null).from("admin@mail.com")
				.message("New Subscription").subject("New Suscriptioin")
				.to(Arrays.asList(requestSuscribtion.getEmail())).build();

		if (request.getBcc() == null)
			request.setBcc(new ArrayList<String>());

		if (request.getCc() == null)
			request.setCc(new ArrayList<String>());

		ServiceProvider serviceProvider = new ServiceProvider(factoryEmailServiceProvider.getProvider("SMTP"));

		boolean mailSended = serviceProvider.executeStrategy(request);

		if (!mailSended)
			throw new RuntimeException("Error sending email");
	}
}