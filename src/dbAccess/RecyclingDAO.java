package dbAccess;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Recycling;

public class RecyclingDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());
	
	public List<Recycling> getAll(){
		String sql = "SELECT * FROM recycling";
		List<Recycling> rList = jdbctemp.query(sql, new BeanPropertyRowMapper<Recycling>(Recycling.class));
		
		return rList;
	}
	
	public Recycling findById(int recId) {
		String sql = "SELECT * FROM recycling WHERE recid = ?";
		Recycling recycling = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<Recycling>(Recycling.class), recId);
		
		return recycling;
	}
	
	public int add(int conid, Recycling recycling) {
		String sql = "INSERT INTO recycling (conid, wasteweight, wasteamount, oilweight, oilamount, image, description, status) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Object args[] = { conid,
						  recycling.getWasteWeight(), 
						  recycling.getWasteAmount(), 
						  recycling.getOilWeight(),
						  recycling.getOilAmount(),
						  recycling.getImage(),
						  recycling.getDescription(),
						  recycling.getStatus() };
		
		int rowAffected = jdbctemp.update(sql, args);
		
		return rowAffected;
	}
	
	public int update(int recId, Recycling recycling) {
		String sql = "UPDATE recycling SET wasteweight = ?, wasteamount = ?, oilweight = ?, oilamount = ?, image = ?, description = ?, status = ? WHERE recid = ?";
		Object args[] = { recycling.getWasteWeight(), 
				  		  recycling.getWasteAmount(), 
				  		  recycling.getOilWeight(),
				  		  recycling.getOilAmount(),
				  		  recycling.getImage(),
				  		  recycling.getDescription(),
				  		  recycling.getStatus(),
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
