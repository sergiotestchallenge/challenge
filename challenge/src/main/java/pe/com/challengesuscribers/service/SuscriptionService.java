package pe.com.challengesuscribers.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.com.challengesuscribers.clients.EmailClientRest;
import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;
import pe.com.challengesuscribers.repository.Suscription;
import pe.com.challengesuscribers.repository.SuscriptionRepository;

@Slf4j
@Service
public class SuscriptionService implements ISuscriptionService {

	@Autowired
	EmailClientRest emailClientRest;

	@Autowired
	SuscriptionRepository suscriptionRepository;

	public Suscription create(ReqSuscriptionDTO newSuscriptionDTO) {

		Suscription newSuscription = Suscription.builder().email(newSuscriptionDTO.getEmail())
				.firstName(newSuscriptionDTO.getFirstName()).gender(newSuscriptionDTO.getGender())
				.dateOfBirth(newSuscriptionDTO.getDateOfBirth()).flag(newSuscriptionDTO.getFlag())
				.newsLetterId(newSuscriptionDTO.getNewsLetterId()).build();

		Suscription savedSuscription = suscriptionRepository.save(newSuscription);

		CompletableFuture.runAsync(() -> emailClientRest.sendEmail(newSuscriptionDTO));

		return savedSuscription;
	}
}