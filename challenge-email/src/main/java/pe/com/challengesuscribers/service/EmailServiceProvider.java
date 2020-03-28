package pe.com.challengesuscribers.service;

import pe.com.challengesuscribers.request.RequestSendMailDTO;

public interface EmailServiceProvider {
	public boolean sendEmail(RequestSendMailDTO requestSendMailDTO);
}