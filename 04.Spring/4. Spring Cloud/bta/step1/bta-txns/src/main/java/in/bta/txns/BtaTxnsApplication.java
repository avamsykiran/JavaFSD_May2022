package in.bta.txns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BtaTxnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtaTxnsApplication.class, args);
	}

}
