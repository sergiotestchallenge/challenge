package pe.com.challengesuscribers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import pe.com.challengesuscribers.dto.ReqSuscriptionDTO;
import pe.com.challengesuscribers.service.MailingService;

@Slf4j
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.OPTIONS })
@RestController
@RequestMapping("/mailing")
@Api(tags = { "Mailing" }, value = "/mailing", consumes = "multipart/form-data")
public class MailingController {

	@Autowired
	private MailingService mailingService;

	@PostMapping("/send-mail")
	public ResponseEntity<String> sendEmail(@RequestBody ReqSuscriptionDTO reqSuscriptionDTO) {

		log.info("INI sendEmail : RequestSendMailDTO {}", reqSuscriptionDTO);

		mailingService.sendMail(reqSuscriptionDTO);

		ResponseEntity<String> response = ResponseEntity.status(HttpStatus.OK).body("OK");

		log.info("FIN sendEmail : RequestSendMailDTO {}", reqSuscriptionDTO);

		return response;
	}
}