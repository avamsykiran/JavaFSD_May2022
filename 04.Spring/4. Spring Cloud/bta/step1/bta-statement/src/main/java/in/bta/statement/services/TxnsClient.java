package in.bta.statement.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.bta.statement.models.Txn;

@FeignClient(name = "txns", url = "http://localhost:9200")
public interface TxnsClient {
	@GetMapping("/{ahId}/{start}/{end}")
	List<Txn> getTxns(@PathVariable("ahId") long ahId,
			@PathVariable("start") @DateTimeFormat(iso = ISO.DATE) LocalDate start,
			@PathVariable("end") @DateTimeFormat(iso = ISO.DATE) LocalDate end);

	@GetMapping("/{ahId}/balance")
	double getBalance(@PathVariable("ahId") long ahId);
}
