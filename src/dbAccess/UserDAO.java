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
		User usr = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);
		return usr;
	}

	public User findUserById(int id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		User usr = jdbctemp.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
		return usr;
	}

	// add
	public int add(User u) {
		User found = findUserByName(u.getUsername());

		// user already exists
		if (found != null) {
			return -1;
		}

		String sql = "INSERT INTO user (username, password, role, fullName, IC, phone, employmentStatus, employmentSector) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		String hashedPassword = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		Object args[] = { u.getUsername(), hashedPassword, u.getRole(), u.getFullName(), u.getIC(), u.getPhone(),
				u.getEmploymentStatus(), u.getEmploymentSector() };
		int rowAffected = jdbctemp.update(sql, args);
		return rowAffected;
	}

	// update
	public int update(User u) {
		String sql = "UPDATE user SET username=?, password=?, role=?, full_name=?, IC=?, phone=?, employment_status=?, employment_sector=?, profile_image=? WHERE id=?";
		Object[] args = { u.getUsername(), u.getPassword(), u.getRole(), u.getFullName(), u.getIC(), u.getPhone(),
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
