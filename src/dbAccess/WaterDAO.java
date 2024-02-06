package dbAccess;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Water;

public class WaterDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());
	
	public List<Water> getAll(){
		String sql = "SELECT * FROM water";
		List<Water> waterList = jdbctemp.query(sql, new BeanPropertyRowMapper<Water>(Water.class));
		
		return waterList;
	}
	
	public Water findById(int waterId) {
		String sql = "SELECT * FROM water WHERE waterid = ?";
		Water water = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Water>(Water.class), waterId);
		
		return water;
	}
	
	public Water checkByEvent(int waterId) {
		String sql = "SELECT * FROM water WHERE waterid = ?";
		Water water = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Water>(Water.class), waterId);
		
		return water;
	}
	
	public int add(int conId, Water water) {
		String sql = "INSERT INTO water (conid, noofdays, profactor, currentusage, amount, bill, description, carbonValue) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object args[] = { conId,
						  water.getNoOfDays(), 
						  water.getProfactor(), 
						  water.getCurrentUsage(),
						  water.getAmount(),
						  water.getBill(),
						  water.getDescription(),
						  water.getCarbonValue() };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int update(int waterId, Water water) {
		String sql = "UPDATE water SET noofdays = ?, profactor = ?, currentusage = ?, amount = ?, bill = ?, description = ?, carbonValue = ? WHERE waterid = ?";
		Object args[] = { water.getNoOfDays(), 
						  water.getProfactor(), 
						  water.getCurrentUsage(),
						  water.getAmount(),
						  water.getBill(),
						  water.getDescription(),
						  water.getCarbonValue(),
						  waterId };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int delete(int waterId) {
		String sql = "DELETE FROM water WHERE waterid = ?";
		int rowAffected = jdbctemp.update(sql, waterId);
		
		return rowAffected;
	}
}
