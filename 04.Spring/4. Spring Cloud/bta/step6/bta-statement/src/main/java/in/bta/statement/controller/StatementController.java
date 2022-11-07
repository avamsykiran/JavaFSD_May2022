package in.bta.statement.controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bta.statement.exceptions.StatementException;
import in.bta.statement.exceptions.UnreachableException;
import in.bta.statement.models.Statement;
import in.bta.statement.services.StatementService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/")
public class StatementController {

	@Autowired
	private StatementService statementService;
	
	@GetMapping("/{ahId}/{year}")
	@CircuitBreaker(name="cb1",fallbackMethod = "getAnnualStatementFB")
	public ResponseEntity<Statement> getAnnualStatement(
			@PathVariable("ahId")Long ahId,@PathVariable("year")int year) throws StatementException {

		LocalDate start = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate end = start.with(TemporalAdjusters.lastDayOfYear());
		return ResponseEntity.ok(statementService.getStatement(ahId, start, end));
	}

	@GetMapping("/{ahId}/{year}/{month}")
	@CircuitBreaker(name="cb2",fallbackMethod = "getMonthlyStatementFB")
	public ResponseEntity<Statement> getMonthlyStatement(
			@PathVariable("ahId")Long ahId,@PathVariable("year")int year,@PathVariable("month")Month month) throws StatementException {

		LocalDate start = LocalDate.of(year, month, 1);
		LocalDate end = start.with(TemporalAdjusters.lastDayOfMonth());
		return ResponseEntity.ok(statementService.getStatement(ahId, start, end));

	}
	
	public ResponseEntity<Statement> getAnnualStatementFB(
			Long ahId,int year,Throwable t) throws StatementException {
		throw new UnreachableException("Seems like some services are not reachable, please try later");
	}
	
	public ResponseEntity<Statement> getMonthlyStatementFB(
			Long ahId,int year,Month month,Throwable t) throws StatementException {
		throw new UnreachableException("Seems like some services are not reachable, please try later");
	}

}
