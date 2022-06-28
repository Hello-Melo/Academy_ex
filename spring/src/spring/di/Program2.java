package spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.newLecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program2 {
	public static void main(String[] args) {
	
		
		//  Exam exam = new newLecExam(); 
		//ExamConsole console = new InlineExamConsole(exam);
		 // ExamConsole console = new GridExamConsole();
	//	  console.setExam(exam);
		 
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Setting.class);
		
		// ExamConsole console = (ExamConsole) ctx.getBean("console");
		//ExamConsole console = ctx.getBean(ExamConsole.class);
		ExamConsole console = ctx.getBean("console", ExamConsole.class); 
		
		console.print();
	
	
	
	}
}
