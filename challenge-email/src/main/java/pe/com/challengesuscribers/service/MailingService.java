package pe.com.challengesuscribers.service;

import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;

public interface MailingService {
	void sendMail(ReqSuscriptionDTO request);
}