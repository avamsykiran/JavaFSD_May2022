package in.tp.is.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.tp.is.entity.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {
	@Query("SELECT a FROM AccountHolder WHERE a.userAccount.userId=:userId")
	Optional<AccountHolder> getByUserId(Long userId);
	Optional<AccountHolder> findByMobile(String mobile);
	Optional<AccountHolder> findByMailId(String mailId);
}
