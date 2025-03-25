package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloJunitTest {
	@Test
	void hello() {
		//1. Container 객체생성
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:spring_di.xml");
		//2. Container에게  Hello 스프링빈을 요청하기
		Hello hello = (Hello)context.getBean("hello");
		Hello helloBean = context.getBean("hello", Hello.class);
		
	}
}
