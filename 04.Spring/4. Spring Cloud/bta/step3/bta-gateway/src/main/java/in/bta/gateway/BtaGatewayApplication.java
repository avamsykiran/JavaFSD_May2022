package in.bta.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BtaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtaGatewayApplication.class, args);
	}

}
