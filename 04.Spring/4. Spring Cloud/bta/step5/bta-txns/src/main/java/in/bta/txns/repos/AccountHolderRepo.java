package in.bta.txns.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bta.txns.entities.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder,Long> {

}
