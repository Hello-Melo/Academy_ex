package spring.di.ui;

import spring.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {

	private Exam exam;
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void print() {
		System.out.println("=======인라인 컨설========");
		System.out.println("total is " + exam.total() + ", avg is " + exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
