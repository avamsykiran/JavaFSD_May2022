package in.tp.is.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.tp.is.entity.Txn;

public interface TxnRepo extends JpaRepository<Txn, Long> {
	//@Query("SELECT t FROM Txn t WHERE t.holder.ahId=:ahId")
	@Query("SELECT t FROM Txn t JOIN t.holder h WHERE h.ahId=:ahId")
	List<Txn> findAllByAccountHolderId(Long ahId);
}
