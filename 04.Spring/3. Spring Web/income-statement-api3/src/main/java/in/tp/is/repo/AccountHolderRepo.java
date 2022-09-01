package in.tp.is.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tp.is.entity.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {
	Optional<AccountHolder> findByMobile(String mobile);
	Optional<AccountHolder> findByMailId(String mailId);
}
