package spring.di.ui;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {

	private Exam exam;
	
	public GridExamConsole() {
	}
	
	public GridExamConsole(Exam exam) {
		super();
		this.exam = exam;
	}


	@Override
	public void print() {
		System.out.println("=======그리드콘솔=======");
		System.out.println("total is " + exam.total() + ", avg is " + exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
