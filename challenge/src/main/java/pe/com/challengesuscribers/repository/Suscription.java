package pe.com.challengesuscribers.repository;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "suscription")
public class Suscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String email;
	String firstName;
	String gender;
	Date dateOfBirth;
	Integer flag;
	Integer newsLetterId;
}