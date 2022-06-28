package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.newLecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

@Configuration
public class Setting {

	//<!--  Exam exam = new newLecExam(); -->
	//<bean id="exam" class="spring.di.entity.newLecExam" ></bean>
	
	//<!-- ExamConsole console = new GridExamConsole(); -->

	//<bean id="console" class="spring.di.ui.GridExamConsole">
	//	<property name="exam" ref="exam" />
	//</bean>

	@Bean
	public newLecExam exam() {
		return new newLecExam();
	}
	
	@Bean
	public ExamConsole console() {
		InlineExamConsole console = new InlineExamConsole();
		console.setExam(exam());
		return console;
	}
	
}
