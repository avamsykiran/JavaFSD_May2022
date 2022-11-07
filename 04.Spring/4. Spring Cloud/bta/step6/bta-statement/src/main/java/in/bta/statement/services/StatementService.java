package in.bta.statement.services;

import java.time.LocalDate;

import in.bta.statement.exceptions.StatementException;
import in.bta.statement.models.Statement;

public interface StatementService {
	Statement getStatement(long ahid,LocalDate start,LocalDate end) throws StatementException;
}
