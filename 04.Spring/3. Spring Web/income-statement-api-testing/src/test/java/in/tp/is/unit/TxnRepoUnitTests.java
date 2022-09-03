package in.tp.is.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import in.tp.is.entity.Txn;
import in.tp.is.entity.TxnType;
import in.tp.is.repo.TxnRepo;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TxnRepoUnitTests {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private TxnRepo txnRepo;

	private List<Txn> testData;

	public TxnRepoUnitTests() {
		testData = List.of(
				new Txn(null, "Salary", 65000.0, LocalDate.of(2022, Month.SEPTEMBER, 1), TxnType.CREDIT),
				new Txn(null, "Rent", 5000.0, LocalDate.of(2022, Month.SEPTEMBER, 2), TxnType.DEBIT)
				);
	}

	@BeforeEach
	void setUp() {
		for (Txn t : testData) {
			t = testEntityManager.persist(t);
		}
		testEntityManager.flush();
	}

	@AfterEach
	void cleanUp() {
		txnRepo.deleteAll();
	}

	@Test
	void whenFindBy_givenExsitingId_thenReturnsTheRecord() {
		Txn txn = txnRepo.findById(testData.get(0).getTxnId()).orElse(null);
		assertEquals(testData.get(0), txn);
	}

	@Test
	void whenFindBy_givenNonExsitingId_thenReturnsNull() {
		Txn txn = txnRepo.findById(1024L).orElse(null);
		assertNull(txn);
	}

	@Test
	void whenSave_givenNewRecord_thenReturnTheSavedRecordd() {
		Txn txn = txnRepo.save(new Txn(null, "Bonus", 4500.0, LocalDate.now(), TxnType.CREDIT));
		assertNotNull(txn.getTxnId());
	}
}
