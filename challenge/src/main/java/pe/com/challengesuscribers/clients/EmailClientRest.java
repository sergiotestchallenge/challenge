package pe.com.challengesuscribers.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;

@FeignClient(name = "${ms.mail.name}", url = "${ms.mail.uri}")
public interface EmailClientRest {

	@PostMapping("/mailing/send-mail")
	public ResponseEntity<String> sendEmail(@RequestBody ReqSuscriptionDTO requestSendMailDTO);

}