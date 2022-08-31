package in.tp.is.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.tp.is.entity.Txn;

public interface TxnRepo extends JpaRepository<Txn, Long> {

}
