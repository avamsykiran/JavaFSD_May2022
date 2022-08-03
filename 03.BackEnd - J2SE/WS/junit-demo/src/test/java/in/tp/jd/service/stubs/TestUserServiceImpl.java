package in.tp.jd.service.stubs;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;

import in.tp.jd.dao.UserDao;
import in.tp.jd.exception.InvalidUserException;
import in.tp.jd.model.Gender;
import in.tp.jd.model.User;
import in.tp.jd.service.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestUserServiceImpl {

	private UserServiceImpl userService;
	
	@Mock
	private UserDao userDao;
	
	@BeforeEach
	void startUp() {
		this.userService = new UserServiceImpl(userDao);
	}
	
	@Test
	void  testAddUser() {
		User expected = new User("xyz", LocalDate.now().minusYears(10), Gender.GENT);
		
		Mockito.when(userDao.add(expected)).thenReturn(expected);
		
		User actual = userService.add(expected);
		assertEquals(expected, actual);
	}
	
	@Test
	void  testUpdateUser() {
		User expected = new User("xyz", LocalDate.now().minusYears(10), Gender.GENT);
		
		Mockito.when(userDao.update(expected)).thenReturn(expected);
		
		User actual = userService.update(expected);
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("getByFullName shoudl return user given fullName")
	void testGetByFullName1() {
		User expected = new User("xyz", LocalDate.now().minusYears(10), Gender.GENT);
		
		Mockito.when(userDao.getByFullName("xyz")).thenReturn(expected);
		
		User actual = userService.getByFullName("xyz");
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("getByFullName shoudl return null given fullName")
	void testGetByFullName2() {
		
		Mockito.when(userDao.getByFullName(Mockito.anyString())).thenReturn(null);
		
		User actual = userService.getByFullName("xyz");
		assertNull(actual);
	}
	
	@Test
	void testGetAll() {
		List<User> expected = Arrays.asList(new User[] {new User("xyz", LocalDate.now().minusYears(10), Gender.GENT)});
		
		Mockito.when(userDao.getAll()).thenReturn(expected);
		
		List<User> actual = userService.getAll();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("deleteByFullName should not throw any exception given fullName")
	void testDeleteByFullName1() throws InvalidUserException {
		Mockito.when(userDao.existsByFullName(Mockito.anyString())).thenReturn(true);
		Mockito.doNothing().when(userDao).deleteByFullName(Mockito.anyString());
		userService.deleteByFullName("xyz");
		assertTrue(true);
	}
	
	@Test
	@DisplayName("deleteByFullName should throw InvalidUserException given fullName")
	void testDeleteByFullName2() {
		Mockito.when(userDao.existsByFullName(Mockito.anyString())).thenReturn(false);
		//Mockito.doNothing().when(userDao).deleteByFullName(Mockito.anyString());
		
		assertThrows(InvalidUserException.class, ()->{userService.deleteByFullName("xyz");});
	}
}
