package dbAccess;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Consumption;

public class ConsumptionDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());
	
	public List<Consumption> getAll(){
		String sql = "SELECT * FROM consumption";
		List<Consumption> submissionList = jdbctemp.query(sql, new BeanPropertyRowMapper<Consumption>(Consumption.class));
		
		return submissionList;
	}
	
	public Consumption findById(int conId) {
		String sql = "SELECT * FROM consumption WHERE conid = ?";
		Consumption consumption = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Consumption>(Consumption.class), conId);
		
		return consumption;
	}
	
	public int add(int housingId, Consumption consumption) {
		String sql = "INSERT INTO consumption (housingId, month)" +
					 "VALUES (?, ?)";
		Object args[] = { housingId,
						  consumption.getMonth() };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
//	public int update(int eventId, Consumption event) {
//		String sql = "UPDATE event SET name = ?, slogan = ?, description = ?, startdate = ?, enddate = ?, image = ? WHERE eventid = ?";
//		Object args[] = { event.getName(), 
//						  event.getSlogan(), 
//						  event.getDescription(),
//						  event.getStartDate(),
//						  event.getEndDate(),
//						  event.getImage(),
//				  		  eventId };
//		
//		int rowAffected = jdbctemp.update(sql, args);
//		
//		return rowAffected;
//	}
//	
//	public int delete(int eventId) {
//		String sql = "DELETE FROM event WHERE eventid = ?";
//		int rowAffected = jdbctemp.update(sql, eventId);
//		
//		return rowAffected;
//	}
}
