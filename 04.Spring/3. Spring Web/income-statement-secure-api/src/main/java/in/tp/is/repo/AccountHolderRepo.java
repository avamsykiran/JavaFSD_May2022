package in.tp.is.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.tp.is.entity.AccountHolder;

public interface AccountHolderRepo extends JpaRepository<AccountHolder, Long> {
	@Query("SELECT a FROM AccountHolder a WHERE a.userAccount.userName=:userName")
	Optional<AccountHolder> getByUserId(String userName);
}
