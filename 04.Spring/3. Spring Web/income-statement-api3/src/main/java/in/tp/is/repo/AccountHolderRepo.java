package in.tp.is.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tp.is.entity.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {

}
