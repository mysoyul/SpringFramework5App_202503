package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("consolePrinter")
public class ConsolePrinterBean implements PrinterBean {
	public ConsolePrinterBean() {
		System.out.println(this.getClass().getName() + 
				" 기본 생성자 호출됨");
	}
	public void print(String message) {
		System.out.println("ConsolePrinter print() 메서드");
		System.out.println(message);
	}
}
