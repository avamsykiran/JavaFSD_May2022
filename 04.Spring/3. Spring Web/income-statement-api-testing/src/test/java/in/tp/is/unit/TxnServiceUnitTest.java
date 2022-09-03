package in.tp.is.unit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import in.tp.is.entity.Txn;
import in.tp.is.entity.TxnType;
import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.repo.TxnRepo;
import in.tp.is.service.TxnService;
import in.tp.is.service.TxnServiceImpl;

@SpringBootTest
public class TxnServiceUnitTest {

	@Mock
	private TxnRepo txnRepo;

	@InjectMocks
	private TxnService txnService = new TxnServiceImpl();

	private List<Txn> testData;

	public TxnServiceUnitTest() {
		testData = List.of(
				new Txn(1L, "Salary", 65000.0, LocalDate.of(2022, Month.SEPTEMBER, 1), TxnType.CREDIT),
				new Txn(2L, "Rent", 5000.0, LocalDate.of(2022, Month.SEPTEMBER, 2), TxnType.DEBIT)
			);
	}
	
	@Test
	@DisplayName("Whenb getAll then returns all existing txn records")
	void getAllTest() throws OperationFailedException {
		Mockito.when(txnRepo.findAll()).thenReturn(testData);
		List<Txn> actual = txnService.getAll();
		assertEquals(testData, actual);
	}
	
	@Test
	@DisplayName("When getById given existing id then returns txn record")
	void getByIdTest1() throws OperationFailedException {
		Mockito.when(txnRepo.findById(testData.get(0).getTxnId())).thenReturn(Optional.of(testData.get(0)));
		Txn txn = txnService.getById(testData.get(0).getTxnId());
		assertEquals(testData.get(0), txn);
	}
	
	@Test
	@DisplayName("When getById given non-existing id then returns null")
	void getByIdTest2() throws OperationFailedException {
		Mockito.when(txnRepo.findById(1024L)).thenReturn(Optional.empty());
		Txn txn = txnService.getById(1024L);
		assertNull(txn);
	}
	
	@Test
	@DisplayName("when deleeById given exsiting id then doesnt return anything and throws no exceptions")
	void deleteByIdTest1() {
		Mockito.when(txnRepo.existsById(1L)).thenReturn(true);
		Mockito.doNothing().when(txnRepo).deleteById(1L);
		assertDoesNotThrow(() -> {txnService.deleteById(1L);});
	}
	
	@Test
	@DisplayName("when deleeById given non-exsiting id then throws OperationFailedException")
	void deleteByIdTest2() {
		Mockito.when(txnRepo.existsById(1024L)).thenReturn(false);
		assertThrows(OperationFailedException.class, () -> {txnService.deleteById(1024L);});
	}
}
