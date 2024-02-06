package dbAccess;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import model.User;

public class UserDAO {
	JdbcTemplate jdbctemp = new JdbcTemplate(DBConnect.getDataSource());

	public List<User> getAll() {
		String sql = "SELECT * FROM user";
		List<User> rList = jdbctemp.query(sql, new BeanPropertyRowMapper<User>(User.class));

		return rList;
	}

	public User findUserByName(String name) {
		String sql = "SELECT * FROM user WHERE username = ?";
		List<User> users = jdbctemp.query(sql, new BeanPropertyRowMapper<>(User.class), name);

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null; // User not found
		}
	}

	public User findUserById(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		User usr = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
		return usr;
	}

	// add
	public int add(User u) {
		String sql = "INSERT INTO user (username, password, fullName, IC, phone, employmentStatus, employmentSector) VALUES (?, ?, ?, ?, ?, ?, ?)";

		String hashedPassword = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		Object args[] = { u.getUsername(), hashedPassword, u.getFullName(), u.getIC(), u.getPhone(),
				u.getEmploymentStatus(), u.getEmploymentSector() };
		int rowAffected = jdbctemp.update(sql, args);
		return rowAffected;
	}

	// update
	public int update(User u) {
		String sql = "UPDATE user SET username=?, password=?, fullName=?, IC=?, phone=?, employmentStatus=?, employmentSector=?, profileImage=? WHERE id=?";
		
		String hashedPassword = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		Object[] args = { u.getUsername(), hashedPassword, u.getFullName(), u.getIC(), u.getPhone(),
				u.getEmploymentStatus(), u.getEmploymentSector(), u.getProfileImage(), u.getId() };
		int rowAffected = jdbctemp.update(sql, args);
		return rowAffected;
	}

	// delete
	public int delete(int id) {
		String sql = "DELETE FROM user WHERE id=?";
		int rowAffected = jdbctemp.update(sql, id);
		return rowAffected;
	}
}
