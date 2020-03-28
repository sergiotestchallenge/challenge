package pe.com.challengesuscribers.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;
import pe.com.challengesuscribers.repository.Suscription;

@FeignClient(name = "${ms.suscribers.name}", url = "${ms.suscribers.uri}")
public interface SuscribersClientRest {

	@PostMapping("/suscriptions")
	Suscription create(@RequestBody ReqSuscriptionDTO reqSuscriptionDTO);
}