package in.bta.statement.services;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.bta.statement.models.AccountHolder;

@FeignClient(name="profiles")
@LoadBalancerClient(name="profiles")
public interface ProfilesClient {
	
	@GetMapping("/{ahId}/exists")
	public Boolean checkAccountHolderExists(@PathVariable("ahId") Long ahId);
	
	@GetMapping("/{ahId}")
	public AccountHolder getAccountHolder(@PathVariable("ahId") Long ahId);
}