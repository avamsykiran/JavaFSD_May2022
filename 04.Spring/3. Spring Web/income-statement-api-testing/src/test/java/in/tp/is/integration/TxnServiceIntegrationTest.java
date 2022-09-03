package in.tp.is.integration;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import in.tp.is.entity.Txn;
import in.tp.is.entity.TxnType;
import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.repo.TxnRepo;
import in.tp.is.service.TxnService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class TxnServiceIntegrationTest {

	@Autowired
	private TxnRepo txnRepo;

	@Autowired
	private TxnService txnService;

	private List<Txn> testData;

	public TxnServiceIntegrationTest() {
		testData = List.of(
				new Txn(null, "Salary", 65000.0, LocalDate.of(2022, Month.SEPTEMBER, 1), TxnType.CREDIT),
				new Txn(null, "Rent", 5000.0, LocalDate.of(2022, Month.SEPTEMBER, 2), TxnType.DEBIT)
			);
	}
	
	@BeforeEach
	void setUp() {
		for(Txn t : testData) {
			t=txnRepo.save(t);
		}
	}

	@AfterEach
	void cleanUp() {
		txnRepo.deleteAll();
	}
	
	@Test
	@DisplayName("Whenb getAll then returns all existing txn records")
	void getAllTest() throws OperationFailedException {
		List<Txn> actual = txnService.getAll();
		assertEquals(testData, actual);
	}
	
	@Test
	@DisplayName("When getById given existing id then returns txn record")
	void getByIdTest1() throws OperationFailedException {
		Txn txn = txnService.getById(testData.get(0).getTxnId());
		assertEquals(testData.get(0), txn);
	}
	
	@Test
	@DisplayName("When getById given non-existing id then returns null")
	void getByIdTest2() throws OperationFailedException {
		Txn txn = txnService.getById(1024L);
		assertNull(txn);
	}
	
	@Test
	@DisplayName("when deleeById given exsiting id then doesnt return anything and throws no exceptions")
	void deleteByIdTest1() {
		assertDoesNotThrow(() -> {txnService.deleteById(testData.get(0).getTxnId());});
	}
	
	@Test
	@DisplayName("when deleeById given non-exsiting id then throws OperationFailedException")
	void deleteByIdTest2() {
		assertThrows(OperationFailedException.class, () -> {txnService.deleteById(1024L);});
	}
}
