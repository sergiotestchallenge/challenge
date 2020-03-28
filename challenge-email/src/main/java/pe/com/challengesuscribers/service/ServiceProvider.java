package pe.com.challengesuscribers.service;

import pe.com.challengesuscribers.request.RequestSendMailDTO;

public class ServiceProvider {

	private EmailServiceProvider emailServiceProvider;

	public ServiceProvider(EmailServiceProvider emailServiceProvider) {
		this.emailServiceProvider = emailServiceProvider;
	}

	public boolean executeStrategy(RequestSendMailDTO requestSendMailDTO){
	    return emailServiceProvider.sendEmail(requestSendMailDTO);
	}
}