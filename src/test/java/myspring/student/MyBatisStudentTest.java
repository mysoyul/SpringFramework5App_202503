package myspring.student;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.student.dao.mapper.StudentMapper;
import myspring.student.vo.StudentVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
public class MyBatisStudentTest {
	@Autowired
	StudentMapper mapper;
	
	@Test
	void student1() {
		List<StudentVO> stuList = 
				mapper.selectStudentDept();
		stuList.forEach(System.out::println);
	}
}
