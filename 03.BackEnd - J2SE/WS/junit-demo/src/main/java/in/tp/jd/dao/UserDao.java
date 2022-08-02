package in.tp.jd.dao;

import java.util.List;

import in.tp.jd.model.User;

public interface UserDao {
	User add(User user);
	User update(User user);
	User getByFullName(String fullName);
	List<User> getAll();
	void deleteByFullName(String fullName);
}
