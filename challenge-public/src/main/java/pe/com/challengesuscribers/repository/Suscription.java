package pe.com.challengesuscribers.repository;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Suscription {

	Integer id;
	String email;
	String firstName;
	String gender;
	Date dateOfBirth;
	Integer flag;
	Integer newsLetterId;
}