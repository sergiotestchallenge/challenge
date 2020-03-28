package pe.com.challengesuscribers.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;
import pe.com.challengesuscribers.repository.Suscription;
import pe.com.challengesuscribers.service.SuscriptionService;

@Slf4j
@RequestMapping("/")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
@RestController
public class SuscriptionController {

	@Autowired
	private SuscriptionService suscriptionService;

	@PostMapping("suscriptions")
	@ResponseStatus(HttpStatus.CREATED)
	public Suscription create(@RequestBody @Valid ReqSuscriptionDTO request) {
		log.info("INI private /suscriptions create : ReqSuscriptionDTO {}", request);
		Suscription suscription = suscriptionService.create(request);
		log.info("END private /suscriptions create : ReqSuscriptionDTO {}", request);
		return suscription;
	}
}