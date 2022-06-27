package spring.di;

import spring.di.entity.Exam;
import spring.di.entity.newLecExam;
import spring.di.ui.ExamConsole;
import spring.di.ui.GridExamConsole;
import spring.di.ui.InlineExamConsole;

public class Program {
	public static void main(String[] args) {
	
		Exam exam = new newLecExam();
		//ExamConsole console = new InlineExamConsole(exam);
		ExamConsole console = new GridExamConsole(exam);
		
		console.print();
	
	
	
	}
}
