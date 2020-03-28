package pe.com.challengesuscribers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.challengesuscribers.clients.SuscribersClientRest;
import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;
import pe.com.challengesuscribers.repository.Suscription;

@Slf4j
@Service
public class SuscriptionService implements ISuscriptionService {

	@Autowired
	private SuscribersClientRest suscribersClientRest;

	@Override
	public Suscription create(ReqSuscriptionDTO reqSuscriptionDTO) {

		return suscribersClientRest.create(reqSuscriptionDTO);
	}
}