package pe.com.challengesuscribers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BootApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(BootApplicationStarter.class, args);
	}
}