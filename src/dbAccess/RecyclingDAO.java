package dbAccess;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Electricity;
import model.Recycling;

public class RecyclingDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());
	
	public List<Recycling> getAll(){
		String sql = "SELECT * FROM recycling";
		List<Recycling> recyclingList = jdbctemp.query(sql, new BeanPropertyRowMapper<Recycling>(Recycling.class));
		
		return recyclingList;
	}
	
	public Recycling findByConId(int conId) {
		String sql = "SELECT * FROM recycling WHERE conid = ?";
		Recycling recycling = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Recycling>(Recycling.class), conId);
		
		return recycling;
	}
	
	public Recycling findById(int recId) {
		String sql = "SELECT * FROM recycling WHERE recid = ?";
		Recycling recycling = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Recycling>(Recycling.class), recId);
		
		return recycling;
	}
	
	public Recycling checkByEvent(int conId) {
		String sql = "SELECT * FROM recycling WHERE conId = ?";
		Recycling recycling = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Recycling>(Recycling.class), conId);
		
		return recycling;
	}
	
	public List<Recycling> getByCon() {
		String sql = "SELECT * FROM recycling INNER JOIN housing ON recycling.conid = housing.conid";
		List<Recycling> recycling = jdbctemp.query(sql, new BeanPropertyRowMapper<Recycling>(Recycling.class));
		
		return recycling;
	}
	
	public int add(int conId, Recycling recycling) {
		String sql = "INSERT INTO recycling (conid, wasteweight, wasteamount, oilweight, oilamount, image, description, carbonValue) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object args[] = { conId,
						  recycling.getWasteWeight(), 
						  recycling.getWasteAmount(), 
						  recycling.getOilWeight(),
						  recycling.getOilAmount(),
						  recycling.getImage(),
						  recycling.getDescription(),
						  recycling.getCarbonValue() };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int update(int recId, Recycling recycling) {
		String sql = "UPDATE recycling SET wasteweight = ?, wasteamount = ?, oilweight = ?, oilamount = ?, image = ?, description = ?, carbonValue WHERE recid = ?";
		Object args[] = { recycling.getWasteWeight(), 
				  		  recycling.getWasteAmount(), 
				  		  recycling.getOilWeight(),
				  		  recycling.getOilAmount(),
				  		  recycling.getImage(),
				  		  recycling.getDescription(),
				  		  recycling.getCarbonValue(),
				  		  recId };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int delete(int recId) {
		String sql = "DELETE FROM recycling WHERE recid = ?";
		int rowAffected = jdbctemp.update(sql, recId);
		
		return rowAffected;
	}
}
