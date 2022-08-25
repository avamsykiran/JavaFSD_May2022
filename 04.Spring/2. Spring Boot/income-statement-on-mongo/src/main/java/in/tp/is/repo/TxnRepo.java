package in.tp.is.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.tp.is.entity.Txn;

public interface TxnRepo extends MongoRepository<Txn, Long> {

}
