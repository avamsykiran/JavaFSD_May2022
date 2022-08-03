package in.tp.jd.service;

import java.util.List;

import in.tp.jd.exception.InvalidUserException;
import in.tp.jd.model.User;

public interface UserService {
	User add(User user);
	User update(User user);
	User getByFullName(String fullName);
	List<User> getAll();
	void deleteByFullName(String fullName) throws InvalidUserException;
}
