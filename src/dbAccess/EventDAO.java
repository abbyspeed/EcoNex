package dbAccess;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Event;

public class EventDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());
	
	public List<Event> getAll(){
		String sql = "SELECT * FROM event";
		List<Event> eventList = jdbctemp.query(sql, new BeanPropertyRowMapper<Event>(Event.class));
		
		return eventList;
	}
	
	public Event findById(int eventId) {
		String sql = "SELECT * FROM event WHERE eventid = ?";
		Event event = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Event>(Event.class), eventId);
		
		return event;
	}
	
	public int add(Event event) {
		String sql = "INSERT INTO event (userid, name, slogan, description, startdate, enddate, image, status) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object args[] = { event.getUserId(),
						  event.getName(), 
						  event.getSlogan(), 
						  event.getDescription(),
						  event.getStartDate(),
						  event.getEndDate(),
						  event.getImage(),
						  event.getStatus() };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int update(int eventId, Event event) {
		String sql = "UPDATE event SET name = ?, slogan = ?, description = ?, startdate = ?, enddate = ?, image = ?, status = ? WHERE eventid = ?";
		Object args[] = { event.getName(), 
						  event.getSlogan(), 
						  event.getDescription(),
						  event.getStartDate(),
						  event.getEndDate(),
						  event.getImage(),
						  event.getStatus(),
				  		  eventId };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int delete(int eventId) {
		String sql = "DELETE FROM event WHERE eventid = ?";
		int rowAffected = jdbctemp.update(sql, eventId);
		
		return rowAffected;
	}
}
