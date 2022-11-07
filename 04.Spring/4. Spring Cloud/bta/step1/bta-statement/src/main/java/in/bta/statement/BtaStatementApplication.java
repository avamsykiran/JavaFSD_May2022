package in.bta.statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BtaStatementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtaStatementApplication.class, args);
	}

}
