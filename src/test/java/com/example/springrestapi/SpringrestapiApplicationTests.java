package com.example.springrestapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;

import com.example.springrestapi.Model.User;
import com.example.springrestapi.Repostory.UserRepostory;
import com.example.springrestapi.Service.UserService;

@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class SpringrestapiApplicationTests {

//	using Mockito test method
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepostory userRepo;

	@Test
	public void testsaveUser() {
		User user = new User("yared","daba");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.saveUser(user));
	}

	@Test
	public void testfindAll() {
		when(userRepo.findAll()).thenReturn(Stream
				.of(new User("abebe","legesse"),new User("andux","kasheshe")).collect(Collectors.toList()));
		assertEquals(2, userService.findAll().size());
	}

	@Test
	public void testDeleteById() {
		int id = 2;
		userService.deleteById(id);
		verify(userRepo, times(3)).deleteById(id);
	}

//	@Test
//	public void testfindById() {
//		int id = 2;
//		when(userRepo.findById(id)).thenReturn(Optional.of(Stream
//				.of(new User("abebe","alemza")).collect(Collectors.toList())));
//		assertEquals(1, userService.findById(id).size());
//	}

//	using junit test method 
//	@Autowired
//	UserRepostory userRepo;
//	
//	//test case for create method for repo
//	@Test
//	@Order(1)
//	public void testCreate() {
//		User user = new User();
//		user.setId(2);
//		user.setFirstname("wengel");
//		user.setLastname("alemu");
//		userRepo.save(user);
//		assertNotNull(userRepo.findById(2).get());
//		
//	}
//	//Test case for read all list of data from repo
//	@Test
//	@Order(2)
//	public void testReadAll() {
//		List<User> list= userRepo.findAll();
//		assertThat(list).size().isGreaterThan(0);
//	}
//	
//	@Test
//	@Order(3)
//	public void testSingleUser() {
//		User user = userRepo.findById(1).get();
//		assertEquals("mengistu", user.getFirstname());
//	}
//	
//	@Test
//	@Order(4)
//	public void testUpdate() {
//		User u = userRepo.findById(1).get();
//		u.setFirstname("andu");
//		userRepo.save(u);
//		assertNotEquals("mengistu", userRepo.findById(1).get().getFirstname());
//	}
//	@Test
//	@Order(5)
//	public void testDelete() {
//		User u = userRepo.findById(2).get();
//		userRepo.deleteById(2);
//		assertThat(userRepo.existsById(1)).isFalse();
//	}

}
