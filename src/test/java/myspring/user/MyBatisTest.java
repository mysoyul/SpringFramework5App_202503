package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
public class MyBatisTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserService userService;
	
	@Test
	void service() {
		List<UserVO> userList = userService.getUserList();
		/*
		 * class MyConsumer implements Consumer{
		 *     accept()
		 * }
		 * userList.forEach(new MyConsumer());
		 */		
		
		//forEach(Consumer) 
		//Consumer의 추상메서드   void accept(T t)
		//1. Anonymous Inner class 
		userList.forEach(new Consumer<UserVO>() {
				@Override
				public void accept(UserVO vo) {
					System.out.println(vo);					
				}
			});
		//2. Lambda Expression 람다식
		userList.forEach(user -> System.out.println(">> UserVO = " + user));
		//3. Method Reference - 람다식을 더 단순하게 argument 생략가능
		userList.forEach(System.out::println);
	}
	
	
	@Test @Disabled
	void userMapper() {
		UserVO user = userMapper.selectUserById("dooly");
		System.out.println(user);
	}
	
	@Test @Disabled
	void mybatis() {
		System.out.println(sessionFactory.getClass().getName());
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
	}
	
	@Test @Disabled
	void conn() throws Exception {
		Connection connection = dataSource.getConnection();
		DatabaseMetaData metaData = connection.getMetaData();
		System.out.println(metaData.getURL());
		System.out.println(metaData.getUserName());
		System.out.println(metaData.getDatabaseProductName());
		System.out.println(connection);
	}
}