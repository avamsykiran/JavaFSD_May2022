package in.tp.is.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tp.is.entity.StatementUser;

public interface StatementUserRepo extends JpaRepository<StatementUser, Long>{
	Optional<StatementUser> findByUserName(String userName);
}
