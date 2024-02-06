package dbAccess;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Electricity;

public class ElectricityDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());
	
	public List<Electricity> getAll(){
		String sql = "SELECT * FROM electricity";
		List<Electricity> electricityList = jdbctemp.query(sql, new BeanPropertyRowMapper<Electricity>(Electricity.class));
		
		return electricityList;
	}
	
	public Electricity findById(int electId) {
		String sql = "SELECT * FROM electricity WHERE electid = ?";
		Electricity electricity = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Electricity>(Electricity.class), electId);
		
		return electricity;
	}
	
	public int add(int conId, Electricity electricity) {
		String sql = "INSERT INTO electricity (conid, noofdays, profactor, currentusage, amount, bill, description, status) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object args[] = { conId,
						  electricity.getNoOfDays(), 
						  electricity.getProfactor(), 
						  electricity.getCurrentUsage(),
						  electricity.getAmount(),
						  electricity.getBill(),
						  electricity.getDescription(),
						  electricity.getStatus() };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int update(int electId, Electricity electricity) {
		String sql = "UPDATE electricity SET noofdays = ?, profactor = ?, currentusage = ?, amount = ?, bill = ?, description = ?, status = ? WHERE electid = ?";
		Object args[] = { electricity.getNoOfDays(), 
						  electricity.getProfactor(), 
						  electricity.getCurrentUsage(),
						  electricity.getAmount(),
						  electricity.getBill(),
						  electricity.getDescription(),
						  electricity.getStatus(),
				  		  electId };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int delete(int electId) {
		String sql = "DELETE FROM electricity WHERE electid = ?";
		int rowAffected = jdbctemp.update(sql, electId);
		
		return rowAffected;
	}
}
