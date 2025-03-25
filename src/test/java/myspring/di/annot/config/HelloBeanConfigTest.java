package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloBeanConfig.class,
loader = AnnotationConfigContextLoader.class)
/*
 * Xml 대신 설정역할을 Config 클래스를 작성함
 * Xml => GenericXmlApplicationContext 가 컨테이너 역할을 담당함
 * Config 클래스 => AnnotationConfigApplicationContext 가  컨테이너 역할을 담당함
 * AnnotationConfigContextLoader 로더 클래스의 역할
 *  : 변경된 AnnotationConfigApplicationContext 컨테이너를 로드한다. 
 */
public class HelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Test
	void hello() {
		System.out.println(hello.sayHello());
	}
	
}
