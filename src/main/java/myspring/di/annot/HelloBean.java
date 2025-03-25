package myspring.di.annot;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
	@Value("${myName}") //어노테이션
	String name;
	
//	@Autowired
//	@Qualifier("${myPrinter}") //stringPrinter
	@Resource(name="${myPrinter}")
	PrinterBean printer;
	
	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + 
				" 기본 생성자 호출됨");
	}

	public HelloBean(String name, PrinterBean printer) {
		System.out.println(this.getClass().getName() + 
				" Overloading 생성자 호출됨");
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

//	public void setName(String name) {
//		System.out.println("setName() 호출 = " + name);
//		this.name = name;
//	}
//
//	public void setPrinter(PrinterBean printer) {
//		System.out.println("setPrinter() 호출 = " + 
//	printer.getClass().getName());
//		this.printer = printer;
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
