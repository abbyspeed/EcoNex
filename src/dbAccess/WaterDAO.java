package dbAccess;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import model.Water;

public class WaterDAO {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DBConnect.getDataSource());

    public List<Water> getAll() {
        String sql = "SELECT * FROM water";
        List<Water> waterList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Water.class));
        return waterList;
    }

    public Water findById(int waterId) {
        String sql = "SELECT * FROM water WHERE waterid = ?";
        Water water = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Water.class), waterId);
        return water;
    }

    public int add(Water water) {
        String sql = "INSERT INTO water (noofdays, profactor, currentUsage, amount, bill, description, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] args = { water.getNoOfDays(), water.getProFactor(), water.getCurrentUsage(),
                          water.getAmount(), water.getBill(), water.getDescription(), water.getStatus() };
        int rowAffected = jdbcTemplate.update(sql, args);
        return rowAffected;
    }

    public int update(int waterId, Water water) {
        String sql = "UPDATE water SET noofdays = ?, profactor = ?, currentUsage = ?, amount = ?, " +
                     "bill = ?, description = ?, status = ? WHERE waterid = ?";
        Object[] args = { water.getNoOfDays(), water.getProFactor(), water.getCurrentUsage(),
                          water.getAmount(), water.getBill(), water.getDescription(), water.getStatus(), waterId };
        int rowAffected = jdbcTemplate.update(sql, args);
        return rowAffected;
    }

    public int delete(int waterId) {
        String sql = "DELETE FROM water WHERE waterid = ?";
        int rowAffected = jdbcTemplate.update(sql, waterId);
        return rowAffected;
    }
}
