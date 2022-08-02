package in.tp.jd.service;

import java.util.List;

import in.tp.jd.dao.UserDao;
import in.tp.jd.model.User;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public User add(User user) {
		return userDao.add(user);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);				
	}

	@Override
	public User getByFullName(String fullName) {
		return userDao.getByFullName(fullName);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void deleteByFullName(String fullName) {
		userDao.deleteByFullName(fullName);
	}
}
