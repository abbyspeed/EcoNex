package dbAccess;

import org.springframework.jdbc.core.JdbcTemplate;

public class RecyclingDAO {
	JdbcTemplate jdbctemplate = new JdbcTemplate(DBConnect.getDataSource());
	
	
}
