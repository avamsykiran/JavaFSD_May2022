package in.tp.incomestatement.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.tp.incomestatement.exception.OperationFailedException;
import in.tp.incomestatement.model.Txn;
import in.tp.incomestatement.model.TxnType;

public class TxnDAOJdbcImpl implements TxnDAO {

	public static final String GET_ALL_QRY = "SELECT txnid,desp,amount,txndate,type FROM txns";
	public static final String GET_BY_ID_QRY = "SELECT txnid,desp,amount,txndate,type FROM txns WHERE txnid=?";
	public static final String GET_LAST_ID_QRY = "SELECT max(txnid) FROM txns";
	public static final String INS_QRY = "INSERT INTO txns(desp,amount,txndate,type) VALUES(?,?,?,?)";
	public static final String UPD_QRY = "UPDATE TABLE txns set desp=?,amount=?,txndate=?,type=? WHERE txnid=?";
	public static final String DEL_BY_ID_QRY = "DELETE FROM txns WHERE txnid=?";

	@Override
	public Txn add(Txn txn) throws OperationFailedException {
		if (txn != null) {
			try (Connection con = ConnectionProvider.getInstance().getConnection();
					PreparedStatement pst = con.prepareStatement(INS_QRY);
					PreparedStatement pst2 = con.prepareStatement(GET_LAST_ID_QRY);
					) {

				pst.setString(1, txn.getDesp());
				pst.setDouble(2, txn.getAmount());
				pst.setDate(3, Date.valueOf(txn.getTxnDate()));
				pst.setString(4, txn.getType().toString());

				pst.executeUpdate();
				
				ResultSet rs = pst2.executeQuery();
				
				if(rs.next()) {
					txn.setTxnId(rs.getLong(1));
				}

			} catch (SQLException | IOException e) {
				throw new OperationFailedException(e.getMessage());
			}
		}
		return txn;
	}

	@Override
	public Txn save(Txn txn) throws OperationFailedException {
		if (txn != null) {
			try (Connection con = ConnectionProvider.getInstance().getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_QRY);) {

				pst.setString(1, txn.getDesp());
				pst.setDouble(2, txn.getAmount());
				pst.setDate(3, Date.valueOf(txn.getTxnDate()));
				pst.setString(4, txn.getType().toString());
				pst.setLong(5, txn.getTxnId());

				pst.executeUpdate();

			} catch (SQLException | IOException e) {
				throw new OperationFailedException(e.getMessage());
			}
		}
		return txn;
	}

	@Override
	public void deleteById(long txnId) throws OperationFailedException {
		try (Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_BY_ID_QRY);) {

			pst.setLong(1, txnId);

			pst.executeUpdate();

		} catch (SQLException | IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
	}
	
	private Txn mapRow(ResultSet rs) throws SQLException {
		Txn t = new Txn();
		t.setTxnId(rs.getLong(1));
		t.setDesp(rs.getString(2));
		t.setAmount(rs.getDouble(3));
		t.setTxnDate(rs.getDate(4).toLocalDate());
		t.setType(TxnType.valueOf(rs.getString(5)));
		return t;
	}

	@Override
	public List<Txn> getAll() throws OperationFailedException {
		List<Txn> txns = new ArrayList<Txn>();
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement pst = con.prepareStatement(GET_ALL_QRY);
				){
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				txns.add(mapRow(rs));
			}
			
		} catch (SQLException | IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
		return txns;
	}

	@Override
	public Txn getById(long txnId) throws OperationFailedException {
		Txn t = null;
		try(Connection con = ConnectionProvider.getInstance().getConnection();
				PreparedStatement pst = con.prepareStatement(GET_BY_ID_QRY);
				){
			
			pst.setLong(1, txnId);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				t=mapRow(rs);
			}
			
		} catch (SQLException | IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
		return t;
	}

}
