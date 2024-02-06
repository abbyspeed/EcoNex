package dbAccess;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Event;
import model.Housing;

public class HousingDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());
	
	public List<Housing> getAll(){
		String sql = "SELECT * FROM housing";
		List<Housing> housingList = jdbctemp.query(sql, new BeanPropertyRowMapper<Housing>(Housing.class));
		
		return housingList;
	}
	
	public Housing findById(int housingId) {
		String sql = "SELECT * FROM housing WHERE housingid = ?";
		Housing housing = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Housing>(Housing.class), housingId);
		
		return housing;
	}
	
	public Housing findByEventId(int eventId) {
		String sql = "SELECT * FROM housing WHERE eventid = ?";
		Housing housing = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Housing>(Housing.class), eventId);
		
		return housing;
	}
	
	public Housing checkByEvent(int eventId) {
		String sql = "SELECT * FROM housing WHERE eventid = ?";
		Housing housing = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Housing>(Housing.class), eventId);
		
		return housing;
	}
	
	public int add(Housing housing) {
		String sql = "INSERT INTO housing (eventid, userid, area, category, name, householdno, address, postcode) " +
				 	 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object args[] = { housing.getEventId(),
						  housing.getUserId(),
						  housing.getArea(),
						  housing.getCategory(),
						  housing.getName(), 
						  housing.getHouseholdNo(), 
						  housing.getAddress(),
						  housing.getPostcode() };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int update(int housingId, Housing housing) {
		String sql = "UPDATE housing SET area = ?, category = ?, name = ?, householdno = ?, address = ?, postcode = ? WHERE housingId = ?";
		Object args[] = { housing.getArea(),
						  housing.getCategory(),
						  housing.getName(), 
						  housing.getHouseholdNo(), 
						  housing.getAddress(),
						  housing.getPostcode(),
						  housingId };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int delete(int housingId) {
		String sql = "DELETE FROM housing WHERE housingid = ?";
		int rowAffected = jdbctemp.update(sql, housingId);
		
		return rowAffected;
	}
}
