package myspring.di.xml;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_di.xml")
public class HelloSpringTest {
	//Hello Type인 스프링빈을 주입받는다. 
	//hello변수명과 동일한 id를 가진 스프링빈을 주입받는다. 
	@Autowired
	Hello hello;
	
	//Hello Type인 스프링빈을 주입받는다.
	//@Qualifier의 값과 동일한 id를 가진 스프링빈을 주입받는다. 
	@Autowired
	@Qualifier("helloC")
	Hello hello1;
	
	//@Resource의 name속성의 값과 동일한 id를 가진 스프링빈을 주입받는다. 
	@Resource(name = "hello")
	Hello hello2;
	
	@Test
	void helloBean() {
		System.out.println(hello.sayHello());
		System.out.println(hello1.sayHello());
		System.out.println(hello2.sayHello());
		
		hello1.print();
	}
	
}
