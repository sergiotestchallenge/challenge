package pe.com.challengesuscribers.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.challengesuscribers.service.impl.SmtpServiceImpl;

@Service
public class FactoryEmailServiceProvider {

	@Autowired
	private SmtpServiceImpl SMTPService;

	public EmailServiceProvider getProvider(String providerType) {

		Map<String, EmailServiceProvider> mapa = new HashMap<>();
		mapa.put("SMTP", SMTPService);

		return mapa.get(providerType);
	}
}