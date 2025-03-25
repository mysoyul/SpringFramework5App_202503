package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//Assertions 클래스가 제공하는 모든 static 메서드를 import 한다.
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class HelloJunitTest {
	ApplicationContext context = null;
	
	@BeforeEach
	void create_container() {
		//1. Container 객체생성
		context = new GenericXmlApplicationContext("classpath:spring_di.xml");
		
	}
	
	@Test
	void hello() {
		//2. Container에게  Hello 스프링빈을 요청하기
		Hello hello = (Hello)context.getBean("hello");
		Hello helloBean = context.getBean("hello", Hello.class);
		//3. Hello 스프링빈 의 Singleton Object 여부 확인
		System.out.println(hello == helloBean);
		//주소 비교 assertSame() 호출
		assertSame(hello, helloBean);
		//4. sayHello() 호출, assertEquals() 호출
		assertEquals("Hello 스프링", hello.sayHello());
		
		hello.print();
		
		//Printer의 하위 클래스인 StringPrinter 스프링빈을 요청하기
		Printer printer = context.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
		
		
	}
}






