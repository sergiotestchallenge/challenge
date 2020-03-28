package pe.com.challengesuscribers.service;

import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;
import pe.com.challengesuscribers.repository.Suscription;

public interface ISuscriptionService {
	Suscription create(ReqSuscriptionDTO request);
}