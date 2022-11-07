package in.bta.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BtaProfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtaProfilesApplication.class, args);
	}

}
